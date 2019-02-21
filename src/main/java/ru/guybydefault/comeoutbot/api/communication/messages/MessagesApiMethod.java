package ru.guybydefault.comeoutbot.api.communication.messages;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.guybydefault.comeoutbot.api.communication.AbstractApiMethod;
import ru.guybydefault.comeoutbot.api.communication.ApiRequestResult;
import ru.guybydefault.comeoutbot.service.RestHttpClient;

import java.util.Random;

@Service
public final class MessagesApiMethod extends AbstractApiMethod {


    private Random random = new Random();

    public MessagesApiMethod(@Qualifier("snakeCaseObjectMapper") ObjectMapper responseObjectMapper) {
        super("messages", responseObjectMapper);
    }

    public ApiRequestResult<MessageSentResponse> sendMessage(RestHttpClient restHttpClient, MessageSendRequest messageSendRequest) {
        messageSendRequest.setRandomId(random.nextInt());
        return makeRequest(restHttpClient, "send", messageSendRequest, MessageSentResponse.class);
    }

}
