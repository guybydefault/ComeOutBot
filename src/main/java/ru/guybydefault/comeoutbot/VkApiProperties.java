package ru.guybydefault.comeoutbot;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.boot.context.properties.ConfigurationProperties;

import javax.annotation.PostConstruct;
import javax.el.PropertyNotFoundException;

@ConfigurationProperties("app.vk.api")
public class VkApiProperties {

    @NotBlank
    private String token;

    @NotBlank
    private String group;

    public String getToken() {
        return token;
    }

    public String getGroup() {
        return group;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setGroup(String group) {
        this.group = group;
    }

}
