package com.example.practise.hibernatepractise.repository;

import com.example.practise.hibernatepractise.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UserRepository extends JpaRepository <User, Long>{

    Optional<User> findByUserName(String userName);
}
