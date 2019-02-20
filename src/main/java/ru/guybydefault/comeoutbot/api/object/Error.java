package ru.guybydefault.comeoutbot.api.object;

public class Error {
    private int errorCode;

    private int errorMsg;

    private RequestParam[] requestParams;

    public Error() {
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public int getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(int errorMsg) {
        this.errorMsg = errorMsg;
    }

    public RequestParam[] getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(RequestParam[] requestParams) {
        this.requestParams = requestParams;
    }
}
