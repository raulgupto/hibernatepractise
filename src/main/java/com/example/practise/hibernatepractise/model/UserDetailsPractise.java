package com.example.practise.hibernatepractise.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Notice how this talks to JPA internally and in turn talks to Authentication Provider which has to talk to AuthenticationManager
 */

public class UserDetailsPractise implements UserDetails {
    String username;
    boolean isEnabled = true;
    boolean isCredNonExpired = true;
    boolean isAccountNonLocked = true;
    boolean isAccountNonExpired = true;
    String password = "pass";
    Collection<? extends GrantedAuthority> roles;

    public UserDetailsPractise(String username) {
        this.username = username;
    }

    public UserDetailsPractise() {
    }
    public UserDetailsPractise(User user){
        this.username = user.getUserName();
        this.password = user.getPassword();
        this.isEnabled = user.isActive();
        this.roles = Arrays.stream(user.getRoles().split(" ")).map( role -> new SimpleGrantedAuthority("ROLE_"+role)).collect(Collectors.toList());

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("Called: -> getAuthority");
//        return Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"));
        return this.roles;
    }

    @Override
    public String getPassword() {
        System.out.println("called : pass " + this.password);
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
