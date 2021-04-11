package com.example.practise.hibernatepractise.config.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    For Authentication :
        1. Authentication manager (authenticate()) -> receives calls for authentication -> calls
        2. Authentication Provider (authenticate(), supports())-> calls
        3. UserDetailsService (loadUserByUsername()) ->
        4. JPA Services -> own implementations for DB operations
     */
    final UserDetailsService userDetailsService;

    public SecurityConfig(@Qualifier("userDetailsServicePractise") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{

        auth.userDetailsService(userDetailsService);
    }


    // Handling Resource Authorization using HTTPSecurity here -- using various methods that are available
    /*
        see ant patterns in case of user/** -- ** matches zero or more 'directories' in a path
        Note: csrf must be disabled even if path is matched in permit all so explicitly needs to add them in ignoringAntMatchers
     */

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.csrf().ignoringAntMatchers("/test/**","/movies/**").and()
                .authorizeRequests()
                .antMatchers( "/test/*").permitAll()
                .antMatchers("/movies/**").hasAnyRole( "USER")
                .antMatchers("/user/**").hasAnyRole("ADMIN", "USER")
//                .antMatchers("/**").hasRole("ADMIN") -> this says everything can be only accessed by admin
                .and().formLogin();
    }
    @Bean
    public PasswordEncoder getPasswordEncoder(){
        // not recommended but for practise
        return NoOpPasswordEncoder.getInstance();
    }
}
