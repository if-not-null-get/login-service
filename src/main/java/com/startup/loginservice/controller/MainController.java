package com.startup.loginservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

    @GetMapping("/success")
    public String success() {
        return "<h1>Successfully logged in</h1>";
    }
}
