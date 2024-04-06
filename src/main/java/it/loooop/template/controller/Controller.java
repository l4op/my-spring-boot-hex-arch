package it.loooop.template.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class Controller {
        @GetMapping
        public String getAllUsers() {
            return "Hello, World!!";
        }
    }

