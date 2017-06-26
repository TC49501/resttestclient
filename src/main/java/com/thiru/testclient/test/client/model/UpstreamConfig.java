package com.thiru.testclient.test.client.model;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by thiru on 6/25/17.
 */
@Configuration
//@PropertySource(value = {"file:${application.properties}"})
public class UpstreamConfig {

    private String code;
    private String name;
    private String system;
    private String format;
    private String product;

    public String getCode() {
        return code;
    }
    @Value("${upstream.code}")
    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }
    @Value("${upstream.name}")
    public void setName(String name) {
        this.name = name;
    }

    public String getSystem() {
        return system;
    }
    @Value("${upstream.system}")
    public void setSystem(String system) {
        this.system = system;
    }

    public String getFormat() {
        return format;
    }
    @Value("${upstream.format}")
    public void setFormat(String format) {
        this.format = format;
    }

    public String getProduct() {
        return product;
    }
    @Value("${upstream.product}")
    public void setProduct(String product) {
        this.product = product;
    }
}
