package ru.guybydefault.comeoutbot.web.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.guybydefault.comeoutbot.VkApiProperties;
import ru.guybydefault.comeoutbot.VkCallbackProperties;

import javax.validation.Validator;

@Configuration
public class VkCallbackFilterConfiguration {

    @Autowired
    private VkCallbackProperties vkCallbackProperties;

    @Autowired
    private VkApiProperties vkApiProperties;

    @Bean
    public FilterRegistrationBean initFilterRegistrationBean(SecretKeyVerificationFilter secretKeyVerificationFilter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(secretKeyVerificationFilter);
        filterRegistrationBean.addUrlPatterns(vkCallbackProperties.getMainUrl());
        filterRegistrationBean.setOrder(2);
        return filterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean initRequestObjectMappingFilterRegistrationBean(CallbackEventDeserializerFilter callbackEventDeserializerFilter) {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(callbackEventDeserializerFilter);
        filterRegistrationBean.addUrlPatterns(vkCallbackProperties.getMainUrl(), vkCallbackProperties.getConfirmationUrl());
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;
    }

    @Bean
    public ObjectMapper initVkCallbackEventObjectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.setPropertyNamingStrategy(
                PropertyNamingStrategy.SNAKE_CASE);
        return objectMapper;
    }

    @Bean
    public SecretKeyVerificationFilter initSecretKeyVerificationFilter() {
        return new SecretKeyVerificationFilter(vkCallbackProperties, vkApiProperties);
    }

    @Bean
    public CallbackEventDeserializerFilter initRequestMapperFilter(ObjectMapper objectMapper, Validator validator) {
        return new CallbackEventDeserializerFilter(objectMapper, validator);
    }

}
