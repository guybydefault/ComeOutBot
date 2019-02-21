package ru.guybydefault.comeoutbot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Service
public class RestHttpClient {

    private RestTemplate restTemplate;

    private MediaType contentType = MediaType.APPLICATION_FORM_URLENCODED;

    @Autowired
    public RestHttpClient(ClientHttpRequestFactory clientHttpRequestFactory) {
        restTemplate = new RestTemplate(clientHttpRequestFactory);
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
    }

    public <T> ResponseEntity<T> postForEntity(String url, MultiValueMap<String, String> requestBody, Class<T> responseType) throws RestClientException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(contentType);
        HttpEntity<MultiValueMap<String, String>> httpEntity = new HttpEntity<>(requestBody, headers);
        return restTemplate.exchange(url, HttpMethod.POST, httpEntity, responseType);
    }

}
