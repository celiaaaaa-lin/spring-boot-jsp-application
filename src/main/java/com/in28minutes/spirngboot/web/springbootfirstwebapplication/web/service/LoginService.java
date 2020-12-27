package com.in28minutes.spirngboot.web.springbootfirstwebapplication.web.service;

import org.springframework.stereotype.Component;

// Spring Bean
@Component
public class LoginService {

    public boolean validateUser(String userid, String password){
        return userid.equalsIgnoreCase("Celia") && password.equals("123");
    }
}
