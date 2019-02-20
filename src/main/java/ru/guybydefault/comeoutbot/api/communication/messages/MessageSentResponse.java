package ru.guybydefault.comeoutbot.api.communication.messages;

import ru.guybydefault.comeoutbot.api.communication.AbstractApiResponse;

public class MessageSentResponse extends AbstractApiResponse {

    /**
     * Message ID
     */
    private int response;

    public MessageSentResponse() {
    }

    public int getResponse() {
        return response;
    }

    public void setResponse(int response) {
        this.response = response;
    }

}
