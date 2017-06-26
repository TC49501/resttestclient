package com.thiru.testclient.test.client.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * Created by thiru on 6/25/17.
 */
@Configuration
//@PropertySource(value = {"file:${application.properties}"})
public class DownstreamConfig {
    private String code;
    private String name;
    private String host;
    private String port;
    private String protocol;

    public String getCode() {
        return code;
    }
    @Value("${downstream.code}")
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    @Value("${downstream.name}")
    public void setName(String name) {
        this.name = name;
    }

    public String getHost() {
        return host;
    }
    @Value("${downstream.host}")
    public void setHost(String host) {
        this.host = host;
    }

    public String getPort() {
        return port;
    }
    @Value("${downstream.port}")
    public void setPort(String port) {
        this.port = port;
    }

    public String getProtocol() {
        return protocol;
    }
    @Value("${downstream.protocol}")
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }
}
