package ru.guybydefault.comeoutbot.api.communication;

import ru.guybydefault.comeoutbot.api.object.Error;

public class ErrorResponse {
    private Error error;

    public ErrorResponse() {

    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

}
