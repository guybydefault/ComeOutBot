package ru.guybydefault.comeoutbot.api.communication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.annotation.Annotation;

public class AbstractApiRequest {

    /**
     * Token which is used to access API
     */
    private String accessToken;

    /**
     * VK API version
     */
    protected final String apiVersion = "5.92"; // probably some of requests will require other versions

    public AbstractApiRequest(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @VkApiRequestProperty(name = "v")
    public String getApiVersion() {
        return apiVersion;
    }

    public MultiValueMap<String, String> toQueryParams() {
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(getClass(), Object.class);
            for (PropertyDescriptor pd : beanInfo.getPropertyDescriptors()) {
                String propertyName = null;
                for (Annotation annotation : pd.getReadMethod().getDeclaredAnnotations()) {
                    if (annotation.annotationType().equals(VkApiRequestProperty.class)) {
                        VkApiRequestProperty vkApiRequestProperty = (VkApiRequestProperty) annotation;
                        propertyName = vkApiRequestProperty.name();
                    }
                }
                final Object value = pd.getReadMethod().invoke(this);
                if (value != null) {
                    if (propertyName == null) {
                        // if getter was not annotated with property name for request, then we
                        // are going to transform camelCase property name to snake_case
                        String regex = "([a-z])([A-Z]+)";
                        String replacement = "$1_$2";
                        propertyName = pd.getName()
                                .replaceAll(regex, replacement)
                                .toLowerCase();
                    }
                    queryParams.add(propertyName, value.toString());
                }
            }
        } catch (Exception ex) {
            throw new ApiPropertyBindingException(ex);
        }

        return queryParams;
    }
}
