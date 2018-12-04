package com.startup.loginservice.com.startup.loginservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/login")
    public String login(){
        return "<h1>Login</h1>";
    }
}
