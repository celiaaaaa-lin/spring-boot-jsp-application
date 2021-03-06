package com.in28minutes.spirngboot.web.springbootfirstwebapplication.web.controller;

import com.in28minutes.spirngboot.web.springbootfirstwebapplication.web.model.Todo;
import com.in28minutes.spirngboot.web.springbootfirstwebapplication.web.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@SessionAttributes("name")
public class TodoController {

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

    @Autowired
    TodoService service;
    /* Step 10 List hard-code todos*/
    @RequestMapping(value="/list-todos", method = RequestMethod.GET)
    public String showTodos(ModelMap model){
        String name = getLoggedInUserName(model);
        model.put("todos", service.retrieveTodos(name));
        return "list-todos";
    }

    /* Step 13: Add a to do*/
    @RequestMapping(value="/add-todo13", method = RequestMethod.GET)
    public String showTodo13(){
        return "todo";
    }

    @RequestMapping(value="/add-todo13", method = RequestMethod.POST)
    public String addTodo13(ModelMap model, @RequestParam String desc) {
        // service.addTodo((String) model.get("name"), desc, new Date(), false);
        // Step 22: Refactor login
        service.addTodo(getLoggedInUserName(model), desc, new Date(), false);
        return "redirect:/list-todos";
    }

    /* Step 16: Delete a specific todo*/
    @RequestMapping(value="/delete-todo", method=RequestMethod.GET)
    public String deleteTodo(@RequestParam int id){
        service.deleteTodo(id);
        return "redirect:/list-todos";
    }

    /* Step 18: Command Bean */
    @RequestMapping(value="/add-todo", method = RequestMethod.GET)
    public String showTodo(ModelMap model){
        // bean to form
        model.addAttribute("todo", new Todo(0, (String)model.get("name"), "Default Desc", new Date(), false));
        return "todo";
    }

    @RequestMapping(value="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
        if(result.hasErrors()){
            return "todo";
        }
        // form to bean
        //service.addTodo((String) model.get("name"), todo.getDesc(), todo.getTargetDate(), false);
        // Step 22: Refactor login
        service.addTodo(getLoggedInUserName(model), todo.getDesc(), todo.getTargetDate(), false);
        return "redirect:/list-todos";
    }

    /* Step 19: Update todo */
    @RequestMapping(value="/update-todo", method= RequestMethod.GET)
    public String showUpdateTodo(@RequestParam int id, ModelMap model){
        Todo todo = service.retrieveTodo(id);
        model.put("todo", todo);
        return "todo";
    }

    @RequestMapping(value="/update-todo", method= RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){

        // Step 19: Hard-code user to get around null user exception
        // todo.setUser((String) model.get("name"));
        // Step 22: Refactor login
        todo.setUser(getLoggedInUserName(model));

        if(result.hasErrors()){
            return "todo";
        }
        // form to bean
        service.updateTodo(todo);
        return "redirect:/list-todos";
    }

    private String getLoggedInUserName(ModelMap model) {
        return (String) model.get("name");
    }
 }