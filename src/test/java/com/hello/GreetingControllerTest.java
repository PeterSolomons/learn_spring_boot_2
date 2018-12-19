package com.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@ApplicationTest
class GreetingControllerTest {

    GreetingControllerImpl controller = new GreetingControllerImpl();

    @Test
    @DisplayName("Hello world test")
    void myFirstTest() {
        assertEquals(controller.helloWorld(), "Hello World");
    }

    @Test
    @DisplayName("Controller Error message")
    void mySecondTest() {
        assertEquals(controller.error(), "SpringBoot done fucked up.");
    }

}