package com.yanproject.rest_with_spring_e_java;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class HelloWorldController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/helloworld")
    public HelloWorld helloWorld(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new HelloWorld(counter.incrementAndGet(), String.format(template, name));
    }
}
