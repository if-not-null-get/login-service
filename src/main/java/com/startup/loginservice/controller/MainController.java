package com.startup.loginservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/login")
    public String login(){
        return "You have successfully logged in";
    }

    @GetMapping("/success")
    public String success() {
        return "Successfully logged in";
    }
}
