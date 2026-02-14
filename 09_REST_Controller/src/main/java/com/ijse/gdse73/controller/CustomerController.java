package com.ijse.gdse73.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/customer")
@CrossOrigin
public class CustomerController {

    @GetMapping("/hello1")
    public String hello1() {
        return "Hello World";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "Hello World 2";
    }

    @PostMapping
    public String hello3() {
        return "Hello World 3";
    }

    @DeleteMapping
    public String hello4() {
        return "Hello World 4";
    }

    @PutMapping
    public String hello5() {
        return "Hello World 5";
    }
    @PatchMapping
    public String hello6() {
        return "Hello World 6";
    }
}
