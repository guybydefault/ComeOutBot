package ru.guybydefault.comeoutbot.web.filter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ru.guybydefault.comeoutbot.api.callback.event.CallbackEvent;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.util.Set;

public class CallbackEventDeserializerFilter implements Filter {

    private ServletContext servletContext;

    private ObjectMapper objectMapper;

    private Validator validator;

    CallbackEventDeserializerFilter(ObjectMapper objectMapper, Validator validator) {
        this.objectMapper = objectMapper;
        this.validator = validator;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
    }

    private boolean validateCallbackEvent(CallbackEvent callbackEvent) {
        Set<ConstraintViolation<Object>> constraintViolationSet = validator.validate(callbackEvent);
        if (constraintViolationSet.size() == 0) {
            return true;
        }

        for (ConstraintViolation<Object> constraintViolation : constraintViolationSet) {
            this.servletContext.log(constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage());
        }

        return false;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        if (request.getAttribute("event") == null) {
            try {
                CallbackEvent callbackEvent = objectMapper.readValue(request.getInputStream(), CallbackEvent.class);
                if (validateCallbackEvent(callbackEvent)) {
                    request.setAttribute("event", callbackEvent);
                    chain.doFilter(request, response);
                    return;
                }
            } catch (JsonMappingException ex) {
                servletContext.log("Perhaps VK API version is not set correctly in VK API settings", ex);
            } catch (JsonParseException ex) {
                servletContext.log("Request body is not correctly formed to be JSON", ex);
            } catch (IOException ex) {
                servletContext.log("IO is in trouble", ex);
            }
            httpServletResponse.sendError(HttpServletResponse.SC_BAD_REQUEST);
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
