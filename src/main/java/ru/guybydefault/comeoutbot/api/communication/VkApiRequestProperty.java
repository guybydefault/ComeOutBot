package ru.guybydefault.comeoutbot.api.communication;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface VkApiRequestProperty {
    /**
     * Property name which will be used to send a request
     */
    String name();

}
