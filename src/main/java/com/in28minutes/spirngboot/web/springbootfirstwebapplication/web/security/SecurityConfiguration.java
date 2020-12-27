package com.in28minutes.spirngboot.web.springbootfirstwebapplication.web.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{
    //Create User - Celia/123
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("Celia").password("123")
                .roles("USER", "ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // show default login page from security jar
        http.authorizeRequests().antMatchers("/login", "/h2-console/**").permitAll()
                .antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
                .formLogin();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}