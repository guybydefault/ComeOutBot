package ru.guybydefault.comeoutbot.api.callback.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.guybydefault.comeoutbot.api.object.Message;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class NewMessageEvent extends CallbackEvent {

    @JsonProperty("object")
    @NotNull
    @Valid
    private Message message;

    @Override
    public CallbackEventType getCallBackEventType() {
        return CallbackEventType.MESSAGE_NEW;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }
}
