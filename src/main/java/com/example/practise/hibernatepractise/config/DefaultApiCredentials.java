package com.example.practise.hibernatepractise.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("default")
@ConfigurationProperties("security")
public class DefaultApiCredentials implements ApiConfiguration {
    String default_user;
    String default_pass;

    public String getDefault_user() {
        return default_user;
    }

    public void setDefault_user(String default_user) {
        this.default_user = default_user;
    }

    public String getDefault_pass() {
        return default_pass;
    }

    public void setDefault_pass(String default_pass) {
        this.default_pass = default_pass;
    }
}
