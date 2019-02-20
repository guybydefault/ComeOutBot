package ru.guybydefault.comeoutbot.api.communication.messages;

import ru.guybydefault.comeoutbot.api.communication.AbstractApiMethod;
import ru.guybydefault.comeoutbot.api.service.RestHttpClient;

import java.util.Random;

public final class MessagesApiMethod extends AbstractApiMethod {


    private Random random = new Random();

    public MessagesApiMethod() {
        super("messages");
    }


    public MessageSentResponse sendMessage(RestHttpClient restHttpClient, MessageSendRequest messageSendRequest) {
        messageSendRequest.setRandomId(random.nextInt());
        return makeRequest(restHttpClient, "send", messageSendRequest, MessageSentResponse.class);
    }

}
