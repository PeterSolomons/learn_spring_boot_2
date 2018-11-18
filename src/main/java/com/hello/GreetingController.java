package com.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController implements IGreetingController {
    @RequestMapping(value = "/", method =  RequestMethod.GET)
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
        return "SpringBoot done fucked up.";
    }
}