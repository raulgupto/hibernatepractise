package com.example.practise.hibernatepractise.config;

/**
 * JFI can be directly read from @Value annotation too
 */

public interface ApiConfiguration {
    String getDefault_user();
    String getDefault_pass();

}
