package com.USE.petcareapp.controllers;

import com.USE.petcareapp.data.User;
import com.USE.petcareapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/register")
    public void addUser(@RequestBody User user){
         userService.addUser(user) ;
    }
    @PostMapping("/login")
    public String authenticateUser(@RequestBody User user){
        return userService.authenticateUser(user) ;
    }
}
