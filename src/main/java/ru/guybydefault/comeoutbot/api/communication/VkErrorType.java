package ru.guybydefault.comeoutbot.api.communication;

/**
 * At this point here are only some of the error types which may not turn up after retry request
 */
public enum VkErrorType {

    UNKNOWN_ERROR(1),
    INTERNAL_SERVER_ERROR(10),

    UNRECOGNIZED(-1);

    private final int code;

    VkErrorType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static VkErrorType findByCode(int code) {
        for (VkErrorType vkErrorType : values()) {
            if (vkErrorType.getCode() == code) {
                return vkErrorType;
            }
        }
        return UNRECOGNIZED;
    }
}
