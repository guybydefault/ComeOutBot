package ru.guybydefault.comeoutbot.api.communication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import ru.guybydefault.comeoutbot.api.object.Error;
import ru.guybydefault.comeoutbot.service.RestHttpClient;

import java.io.IOException;

public abstract class AbstractApiMethod {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final static String API_URL = "https://api.vk.com/method/";

    protected final String methodGroupName;

    @Autowired
    private ObjectMapper responseObjectMapper;

    protected AbstractApiMethod(String methodGroupName) {
        this.methodGroupName = methodGroupName;
    }

    protected <T extends AbstractApiRequest, S> ApiRequestResult<S> makeRequest(RestHttpClient restHttpClient, String methodName, T request, Class<S> responseType) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(API_URL + methodGroupName + "." + methodName);

        ApiRequestResult<S> apiRequestResult = new ApiRequestResult<>();
        ResponseEntity<String> responseEntity = restHttpClient.postForEntity(uriComponentsBuilder.toUriString(), request.toQueryParams(), String.class);
        try {
            apiRequestResult.setResponse(responseObjectMapper.readValue(responseEntity.getBody(), responseType));
        } catch (IOException requestParseException) {
            logger.error("Error while trying to parse " + responseType.getSimpleName() + ", trying to parse it as VK API Error", requestParseException);
            try {
                apiRequestResult.setError(responseObjectMapper.readValue(responseEntity.getBody(), Error.class));
            } catch (IOException errorParseException) {
                logger.error("Error while trying to parse VK API Error while handling unsuccessful " + responseType.getSimpleName(), errorParseException, responseEntity.getBody());
                throw new VkApiException(errorParseException);
            }
        }

        return apiRequestResult;
    }

}
