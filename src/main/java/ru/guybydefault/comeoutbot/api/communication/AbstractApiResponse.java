package ru.guybydefault.comeoutbot.api.communication;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import ru.guybydefault.comeoutbot.api.communication.messages.MessageSentResponse;
import ru.guybydefault.comeoutbot.api.object.RequestParam;

import java.util.List;

@JsonSubTypes({
        @JsonSubTypes.Type(value = MessageSentResponse.class)
})
public abstract class AbstractApiResponse {

    private List<RequestParam> requestParams;

    public AbstractApiResponse() {

    }

    public List<RequestParam> getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(List<RequestParam> requestParams) {
        this.requestParams = requestParams;
    }
}
