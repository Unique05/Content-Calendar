package com.unique05.content_calendar.controller;


import com.unique05.content_calendar.config.ContentCalendarProperties;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class HomeController {

    @Value("${cc.welcomeMessage: Default Welcome Message}")//gets a value from application.properties into this controller
    private String welcomeMessage;

    @Value("${cc.about}")//gets a value from application.properties into this controller
    private String about;

    @GetMapping("/")
    public String Home(){
        return welcomeMessage;
    }

    @GetMapping("/hhh")
    public Map<String, String> Homes(){
        return Map.of("welcomeMessage", welcomeMessage, "about", about) ;
    }

    private final ContentCalendarProperties properties;

    public HomeController(ContentCalendarProperties properties) {
        this.properties = properties;
    }

    @GetMapping("/ddd")
    public ContentCalendarProperties noOnesHome(){
        return properties;
    }
}
