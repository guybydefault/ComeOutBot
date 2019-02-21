package ru.guybydefault.comeoutbot.api.callback.event;

public enum CallbackEventType {
    MESSAGE_NEW("message_new"),
    MESSAGE_REPLY("message_reply"),
    MESSAGE_EDIT("message_edit"),
    MESSAGE_ALLOW("message_allow"),
    MESSAGE_DENY("message_deny"),

    CONFIRMATION("confirmation");

    private final String typeName;

    CallbackEventType(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

}
