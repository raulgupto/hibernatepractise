package com.example.practise.hibernatepractise.service;

import com.example.practise.hibernatepractise.repository.UserRepository;
import com.example.practise.hibernatepractise.model.User;
import com.example.practise.hibernatepractise.model.UserDetailsPractise;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by rahulg1 on 4/11/2021.
 */
@Service
public class UserDetailsServicePractise implements UserDetailsService {

    final UserRepository userRepository;

    public UserDetailsServicePractise(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(s);
        user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return user.map(UserDetailsPractise::new).get();

    }
}
