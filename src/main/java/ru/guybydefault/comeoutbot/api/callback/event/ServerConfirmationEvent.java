package ru.guybydefault.comeoutbot.api.callback.event;

public class ServerConfirmationEvent extends CallbackEvent {

    @Override
    public CallbackEventType getCallBackEventType() {
        return CallbackEventType.CONFIRMATION;
    }
}
