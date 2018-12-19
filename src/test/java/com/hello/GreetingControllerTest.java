package com.hello;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("Controller throws unsupported error on ")
    void myThirdTest(){
        RuntimeException exception = assertThrows(UnsupportedOperationException.class, () -> {
           controller.throwsUnsuportedException();
        });
        assertTrue(exception.getMessage().contains("Fool of a Took!"));
    }

    @Test
    @DisplayName("Controller returns in certain amount of time")
    void myFourthTest(){
        assertTimeout(Duration.ofMillis(10), () -> controller.helloWorld());
    }
}