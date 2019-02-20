package ru.guybydefault.comeoutbot;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.validation.constraints.NotNull;

@ConfigurationProperties("app.vk.callback")
public class VkCallbackProperties {

    @NotBlank
    private String secretKey;

    private String confirmationCode;

    @NotNull
    private String mainUrl;

    @NotNull
    private String confirmationUrl;


    public VkCallbackProperties() {
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

    @NotNull
    public String getMainUrl() {
        return mainUrl;
    }

    public void setMainUrl(@NotNull String mainUrl) {
        this.mainUrl = mainUrl;
    }

    @NotNull
    public String getConfirmationUrl() {
        return confirmationUrl;
    }

    public void setConfirmationUrl(@NotNull String confirmationUrl) {
        this.confirmationUrl = confirmationUrl;
    }
}
