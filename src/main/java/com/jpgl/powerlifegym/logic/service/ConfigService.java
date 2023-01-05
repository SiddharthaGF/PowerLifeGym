package com.jpgl.powerlifegym.logic.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:logicalLayer.properties")
public class ConfigService {

    @Value("${nameServer}")
    private String nameServer;

    public String getNameServer() {
        return nameServer;
    }

}