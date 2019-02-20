package ru.guybydefault.comeoutbot.api.callback.event;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;


@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type", include = JsonTypeInfo.As.PROPERTY)
@JsonSubTypes({
        @JsonSubTypes.Type(value = NewMessageEvent.class, name = "message_new"),
        @JsonSubTypes.Type(value = ServerConfirmationEvent.class, name = "confirmation")

})
public abstract class CallbackEvent {

    /**
     * Id of the community for which event is fired
     */
    @NotNull
    private Integer groupId;

    @NotBlank
    private String secret;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public abstract CallbackEventType getCallBackEventType();

}
