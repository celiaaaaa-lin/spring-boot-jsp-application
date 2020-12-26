package com.in28minutes.spirngboot.web.springbootfirstwebapplication.web.service;

import org.springframework.stereotype.Component;

// Spring Bean
@Component
public class LoginService {

    public boolean validateUser(String userid, String password){
        return userid.equalsIgnoreCase("In28Minutes") && password.equals("123");
    }
}
