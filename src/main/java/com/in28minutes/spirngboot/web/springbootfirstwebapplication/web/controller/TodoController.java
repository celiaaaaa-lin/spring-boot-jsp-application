package com.in28minutes.spirngboot.web.springbootfirstwebapplication.web.controller;

import com.in28minutes.spirngboot.web.springbootfirstwebapplication.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    TodoService service;
    /* Step 10 List hard-code todos*/
    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model){
        String name = (String)model.get("name");
        model.put("todos", service.retrieveTodos("in28Minutes"));
        return "list-todos";
    }

    /* Step 13: Add a to do*/
    @RequestMapping(value="/add-todo", method = RequestMethod.GET)
    public String showTodo(){
        return "todo";
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String desc) {
        service.addTodo((String) model.get("name"), desc, new Date(), false);
        return "redirect:/list-todos";
    }

    /* Step 16: Delete a specific todo*/
    @RequestMapping(value="/delete-todo", method=RequestMethod.GET)
    public String deleteTodo(@RequestParam int id){
        service.deleteTodo(id);
        return "redirect:/list-todos";
    }
 }