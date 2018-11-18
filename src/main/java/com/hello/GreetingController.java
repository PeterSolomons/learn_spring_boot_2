package com.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class GreetingController implements IGreetingController {
    @RequestMapping(value = "/", method =  RequestMethod.GET)
    public String helloWorld() {
        return "Hello World";
    }
}
