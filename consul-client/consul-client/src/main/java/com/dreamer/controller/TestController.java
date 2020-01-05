package com.dreamer.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Value("${server.port}")
    private String serverPort;
    
    public String getServerPort() {
    	return serverPort;
    }
}
