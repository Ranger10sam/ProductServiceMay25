package com.example.ProductService.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sample")
public class SampleController {

    //PathVariable is what is mentioned in the path endpoint
    //RequestParam is what is mentioned after ? in the endpoint


    @GetMapping("/sayHello")
    public String sample(@RequestParam("x") int x){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<x; i++){
            sb.append("Hello ").append(i);
        }
        return sb.toString();
    }

    @GetMapping("/sayHello2/{name}")
    public String sample2(@PathVariable("name") String str){
        return "Hello World "+str+ "from 2";
    }
}
