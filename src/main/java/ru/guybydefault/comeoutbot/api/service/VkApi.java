package ru.guybydefault.comeoutbot.api.service;

import org.springframework.stereotype.Service;
import ru.guybydefault.comeoutbot.api.communication.messages.MessagesApiMethod;

@Service
public class VkApi {

    private MessagesApiMethod messages;

    public VkApi() {
        messages = new MessagesApiMethod();
    }

    public MessagesApiMethod getMessages() {
        return messages;
    }


}
