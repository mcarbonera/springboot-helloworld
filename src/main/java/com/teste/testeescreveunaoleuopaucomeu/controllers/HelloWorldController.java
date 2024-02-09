package com.teste.testeescreveunaoleuopaucomeu.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {

    @GetMapping("/hello-world")
    public ResponseEntity<String> getHelloWorld() {
        return ResponseEntity.ok().body("<h1>Hello World</h1>");
    }
}