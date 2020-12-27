package com.in28minutes.spirngboot.web.springbootfirstwebapplication.web.controller;

import com.in28minutes.spirngboot.web.springbootfirstwebapplication.web.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("name")
public class LoginController {

    /* Step 02
    * /login => "Hello World
    */
    @RequestMapping("/login02")
    @ResponseBody
    public String loginMessage02(){
        return "Hello World";
    }
    /* Step 04
    * /login => login jsp page
    */
    @RequestMapping("/login04")
    public String loginMessage04() {
        return "login";
    }
    /* Step 05
    * http://localhost:8080/login?name=Celia
    */
    @RequestMapping("/login05")
    public String loginMessage05(@RequestParam String name, ModelMap model){
        // add name in model
        model.put("name", name);
        System.out.println("Name is" + name);
        return "login";
    }
    /* Step 07
       Show name and password field
       show welcome page after submission
     */
    @RequestMapping(value="/login07", method = RequestMethod.GET)
    public String showLoginPage07(ModelMap model){
        return "login";
    }
    @RequestMapping(value="/login07", method = RequestMethod.POST)
    public String showWelcomePage(@RequestParam String name, ModelMap model){
        model.put("name", name);
        return "welcome";
    }
    /* Step 08
       Add validation
     */
    // Injected automatically - auto wired, dependency injection
    //LoginService service = new LoginService();
    @Autowired
    LoginService service;

    @RequestMapping(value="/login08", method = RequestMethod.GET)
    public String showLoginPage08(ModelMap model){
        return "login";
    }

    @RequestMapping(value="/login08", method = RequestMethod.POST)
    public String showWelcomePage08(ModelMap model, @RequestParam String name, @RequestParam String password){
        boolean isValidUser = service.validateUser(name,password);
        if (!isValidUser){
            model.put("errMessage", "Invalid credentials");
            return "login";
        }
        model.put("name", name);
        model.put("password", password);
        return "welcome";
    }

    /* Step 10, 12
       Show todos
       Add @SessionAttributes
    */

    @RequestMapping(value="/login10", method = RequestMethod.GET)
    public String showLoginPage10(ModelMap model){
        return "login";
    }

    @RequestMapping(value="/login10", method = RequestMethod.POST)
    public String showWelcomePage10(ModelMap model, @RequestParam String name, @RequestParam String password){
        boolean isValidUser = service.validateUser(name,password);
        if (!isValidUser){
            model.put("errMessage", "Invalid credentials");
            return "login";
        }
        model.put("name", name);
        model.put("password", password);
        return "welcome";
    }

    /* Step 22 Spring Security
    *
    * */
    @RequestMapping(value="/", method = RequestMethod.GET)
    public String showLoginPage(ModelMap model){
        model.put("name", "Celia");
        return "welcome";
    }
}