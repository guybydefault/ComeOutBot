package ru.guybydefault.comeoutbot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.guybydefault.comeoutbot.api.callback.event.CallbackEvent;
import ru.guybydefault.comeoutbot.service.CallbackEventHandler;

@RestController(value = "${app.vk.callback.mainUrl}")
public class VkCallbackController {

    @Autowired
    private CallbackEventHandler callbackEventHandler;

    @RequestMapping("${app.vk.callback.mainUrl}")
    public ResponseEntity<String> callbackRequest(@RequestAttribute("event") CallbackEvent event) {
        callbackEventHandler.handle(event);
        return new ResponseEntity<String>("ok", HttpStatus.OK);
    }
}
