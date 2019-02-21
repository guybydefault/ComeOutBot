package ru.guybydefault.comeoutbot.api.communication;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.guybydefault.comeoutbot.api.communication.messages.MessagesApiMethod;

@Service
public class VkApi {


    private MessagesApiMethod messages;

    public VkApi(MessagesApiMethod messages) {
        this.messages = messages;
    }

    public MessagesApiMethod getMessages() {
        return messages;
    }


}
