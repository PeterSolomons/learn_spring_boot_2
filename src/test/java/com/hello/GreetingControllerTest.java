package com.hello;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

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
    void myThirdTest() {
        RuntimeException exception = assertThrows(UnsupportedOperationException.class, () -> {
            controller.throwsUnsuportedException();
        });
        assertTrue(exception.getMessage().contains("Fool of a Took!"));
    }

    @Test
    @DisplayName("Controller returns in certain amount of time")
    void myFourthTest() {
        assertTimeout(Duration.ofMillis(10), () -> controller.helloWorld());
    }

    @Test
    @DisplayName("Controller throws unsupported error on ")
    @Disabled("Test disabled for some reason :)")
    void myFifthTest() {
        controller.throwsUnsuportedException();
        assertTrue(false);
    }


    @Test
    @DisplayName("Assumed Test")
    void mySixthTest() {
        //If 'a' was not 12 then the assumption below would fail and
        //the entire test would stop and be put to ignored status.
        int a = 12;
        assumeTrue(a == 12);
        assertEquals(a, 12);

    }
}