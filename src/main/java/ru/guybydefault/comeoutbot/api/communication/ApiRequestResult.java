package ru.guybydefault.comeoutbot.api.communication;

import ru.guybydefault.comeoutbot.api.object.Error;

public class ApiRequestResult<T> {

    private T response;

    private Error error;

    public ApiRequestResult() {
    }

    public ApiRequestResult(T response) {
        this.response = response;
    }

    public ApiRequestResult(Error error) {
        this.error = error;
    }

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
