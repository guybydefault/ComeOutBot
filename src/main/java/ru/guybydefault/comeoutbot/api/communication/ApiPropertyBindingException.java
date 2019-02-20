package ru.guybydefault.comeoutbot.api.communication;

public class ApiPropertyBindingException extends RuntimeException {

    public ApiPropertyBindingException() {
    }

    public ApiPropertyBindingException(String message) {
        super(message);
    }

    public ApiPropertyBindingException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApiPropertyBindingException(Throwable cause) {
        super(cause);
    }

    public ApiPropertyBindingException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
