package ru.guybydefault.comeoutbot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.guybydefault.comeoutbot.VkCallbackProperties;

@RestController()
public class VkCallbackConfirmationController {

    @Autowired
    private VkCallbackProperties vkCallbackProperties;

    @RequestMapping("${app.vk.callback.confirmationUrl}")
    public String confirm() {
        return vkCallbackProperties.getConfirmationCode();
    }

}
