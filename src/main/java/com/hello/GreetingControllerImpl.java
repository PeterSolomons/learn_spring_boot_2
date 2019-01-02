package com.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class GreetingControllerImpl implements GreetingController  {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello World";
    }

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public String error() {
        return "SpringBoot done fucked up.";
    }

    public String throwsUnsuportedException() {
        throw new UnsupportedOperationException("Fool of a Took!");
    }
}