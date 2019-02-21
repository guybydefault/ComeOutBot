package ru.guybydefault.comeoutbot.api.communication;

public class VkApiException extends RuntimeException {
    public VkApiException() {
    }

    public VkApiException(String message) {
        super(message);
    }

    public VkApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public VkApiException(Throwable cause) {
        super(cause);
    }

    public VkApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
