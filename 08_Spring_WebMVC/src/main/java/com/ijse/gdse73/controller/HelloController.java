package com.ijse.gdse73.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// localhost:8080/Webexploteded/hello
@RestController
@RequestMapping(path = "hello")
public class HelloController {

    public HelloController() {
        System.out.println("HelloController  constructor");
    }
    @GetMapping("index")
    public String index() {
        return "index";
    }
    @GetMapping
    public String hello() {
        return "hello";
    }
}
