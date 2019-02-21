package ru.guybydefault.comeoutbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.guybydefault.comeoutbot.VkApiProperties;
import ru.guybydefault.comeoutbot.api.callback.event.CallbackEvent;
import ru.guybydefault.comeoutbot.api.callback.event.CallbackEventType;
import ru.guybydefault.comeoutbot.api.callback.event.NewMessageEvent;
import ru.guybydefault.comeoutbot.api.communication.ApiRequestResult;
import ru.guybydefault.comeoutbot.api.communication.VkApi;
import ru.guybydefault.comeoutbot.api.communication.VkErrorType;
import ru.guybydefault.comeoutbot.api.communication.messages.MessageSendRequest;
import ru.guybydefault.comeoutbot.api.communication.messages.MessageSentResponse;

@Service
public class QuotationBot implements CallbackEventHandler {

    private RestHttpClient restHttpClient;

    private VkApi vkApi;

    private VkApiProperties vkApiProperties;

    @Autowired
    public QuotationBot(RestHttpClient restHttpClient, VkApi vkApi, VkApiProperties vkApiProperties) {
        this.restHttpClient = restHttpClient;
        this.vkApi = vkApi;
        this.vkApiProperties = vkApiProperties;
    }

    @Override
    public void handle(CallbackEvent callbackEvent) {
        if (callbackEvent.getCallBackEventType() == CallbackEventType.MESSAGE_NEW) {
            NewMessageEvent newMessageEvent = (NewMessageEvent) callbackEvent;
            if (newMessageEvent.getMessage().getText().contains("stride-bot")) {
                MessageSendRequest messageSendRequest = new MessageSendRequest(vkApiProperties.getToken(), newMessageEvent.getMessage().getFromId(), "You said: " + newMessageEvent.getMessage().getText());
                ApiRequestResult<MessageSentResponse> response = vkApi.getMessages().sendMessage(restHttpClient, messageSendRequest);
                if (response.getError() != null) {
                    switch (VkErrorType.findByCode(response.getError().getErrorCode())) {
                        case INTERNAL_SERVER_ERROR:
                        case UNKNOWN_ERROR:
                            // retry
                    }
                }
            }
        }
    }
}
