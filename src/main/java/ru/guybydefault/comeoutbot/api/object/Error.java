package ru.guybydefault.comeoutbot.api.object;

public class Error {
    private Integer errorCode;

    private Integer errorMsg;

    private RequestParam[] requestParams;

    public Error() {
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public Integer getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(Integer errorMsg) {
        this.errorMsg = errorMsg;
    }

    public RequestParam[] getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(RequestParam[] requestParams) {
        this.requestParams = requestParams;
    }
}
