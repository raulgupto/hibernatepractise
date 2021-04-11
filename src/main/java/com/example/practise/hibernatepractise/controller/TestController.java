package com.example.practise.hibernatepractise.controller;

import com.example.practise.hibernatepractise.model.User;
import com.example.practise.hibernatepractise.repository.UserRepository;
import com.example.practise.hibernatepractise.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    com.example.practise.hibernatepractise.config.ApiConfiguration ApiConfiguration;

    @Autowired
    TestService testService;

    @GetMapping("/getConfig")
    public String getConfigAtt(){
        return ApiConfiguration.getDefault_pass() + " " + ApiConfiguration.getDefault_user();
    }
    @GetMapping("/multiplepath/getConfigcheck")
    public String getConfigAttributes(){
        return ApiConfiguration.getDefault_pass() + " " + ApiConfiguration.getDefault_user();
    }

    @PostMapping("/addUserForRole")
    public User addUserForRole(@RequestBody User user){
        return testService.saveUser(user);
    }
}
