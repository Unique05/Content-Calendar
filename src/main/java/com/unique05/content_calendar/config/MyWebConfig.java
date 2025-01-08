package com.unique05.content_calendar.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration //looks for bean definitions and put them in the application context
public class MyWebConfig {

    @Bean //To define a bean, you have to do so in a configuration class
    public RestTemplate restTemplate() {// something that te spring framework provide, and it's a client that you can use to call out to a public API or another service within your organisation
        return new RestTemplateBuilder().build();
    }
}
