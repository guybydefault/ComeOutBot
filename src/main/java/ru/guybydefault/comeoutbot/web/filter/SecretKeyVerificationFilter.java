package ru.guybydefault.comeoutbot.web.filter;

import org.springframework.beans.factory.annotation.Autowired;
import ru.guybydefault.comeoutbot.api.callback.event.CallbackEvent;
import ru.guybydefault.comeoutbot.api.callback.event.CallbackEventType;
import ru.guybydefault.comeoutbot.VkApiProperties;
import ru.guybydefault.comeoutbot.VkCallbackProperties;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecretKeyVerificationFilter implements Filter {

    private VkCallbackProperties vkCallbackProperties;

    private VkApiProperties vkApiProperties;

    private ServletContext servletContext;

    @Autowired
    SecretKeyVerificationFilter(VkCallbackProperties vkCallbackProperties, VkApiProperties vkApiProperties) {
        this.vkCallbackProperties = vkCallbackProperties;
        this.vkApiProperties = vkApiProperties;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.servletContext = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        CallbackEvent callbackEvent = (CallbackEvent) request.getAttribute("event");

        if (callbackEvent.getSecret() == null) {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, "Secret key is required");
            servletContext.log("Authentication failed - secret key was not provided");
            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Secret key not provided");
            return;
        }

        if (!callbackEvent.getSecret().equals(vkCallbackProperties.getSecretKey())) {
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, "Secret key is wrong");
            servletContext.log("Authentication failed - secret key " + callbackEvent.getSecret() + " is wrong");
            httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "Wrong secret key");
            return;
        }

        if (callbackEvent.getCallBackEventType() == CallbackEventType.CONFIRMATION) {
            if (!vkApiProperties.getGroup().equals(String.valueOf(callbackEvent.getGroupId()))) {
                servletContext.log("Confirmation failed, group_id " + request.getParameter("group_id") + " sent in request is not equal to " + vkApiProperties.getGroup() + " in properties");
                httpServletResponse.sendError(422, "Another group id expected");
            } else {
                servletContext.getRequestDispatcher(vkCallbackProperties.getConfirmationUrl()).forward(request, response);
            }
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
