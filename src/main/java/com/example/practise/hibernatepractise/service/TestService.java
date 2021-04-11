package com.example.practise.hibernatepractise.service;


import com.example.practise.hibernatepractise.model.User;
import com.example.practise.hibernatepractise.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
    @Autowired
    UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
