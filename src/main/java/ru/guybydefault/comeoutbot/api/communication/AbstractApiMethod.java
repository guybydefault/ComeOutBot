package ru.guybydefault.comeoutbot.api.communication;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;
import ru.guybydefault.comeoutbot.api.communication.AbstractApiRequest;
import ru.guybydefault.comeoutbot.api.service.RestHttpClient;

public abstract class AbstractApiMethod {

    private final static String API_URL = "https://api.vk.com/method/";

    protected final String methodGroupName;

    protected AbstractApiMethod(String methodGroupName) {
        this.methodGroupName = methodGroupName;
    }


    protected <T extends AbstractApiRequest, S> S makeRequest(RestHttpClient restHttpClient, String methodName, T request, Class<S> responseType) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(API_URL + methodGroupName + "." + methodName);
        ResponseEntity<S> responseEntity = restHttpClient.postForEntity(uriComponentsBuilder.toUriString(), request.toQueryParams(), responseType);
        return responseEntity.getBody();
    }

}
