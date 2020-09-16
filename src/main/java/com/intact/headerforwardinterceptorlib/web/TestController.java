package com.intact.headerforwardinterceptorlib.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController(value = "/rest")
public class TestController {


    @Autowired
    RestTemplate restTemplate;

    @GetMapping(value = "/test")
    public String test(){
        restTemplate.getForObject("https://jsonplaceholder.typicode.com/todos/1",Object.class);
        return "toto";
    }
}
