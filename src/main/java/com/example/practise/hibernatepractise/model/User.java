package com.example.practise.hibernatepractise.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User {
    String userName;
    String roles;
    boolean active = false;
    String password = "12345";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;




    public User(String userName, String role, boolean isActive, String password) {
        this.userName = userName;
        this.roles = role;
        this.active = isActive;
        this.password = password;
    }



    public User(String userName, String roles) {
        this.userName = userName;
        this.roles = roles;
    }

    public User() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
