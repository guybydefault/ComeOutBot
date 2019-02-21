package ru.guybydefault.comeoutbot.service;

import ru.guybydefault.comeoutbot.api.callback.event.CallbackEvent;

public interface CallbackEventHandler {
    void handle(CallbackEvent callbackEvent);
}
