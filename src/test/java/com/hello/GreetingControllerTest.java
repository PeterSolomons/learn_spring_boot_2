package com.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@ApplicationTest
@DisplayName("\uD83D\uDE04")
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

    @Nested
    @DisplayName("Given a small order")
    class smallOrder{


        @Nested
        @DisplayName("And the user has no points")
        class noPoints{


            @Test
            @DisplayName("The customer gets no discount")
            public void testTestStructure(){
                assertEquals(1, 1);
            }


        }
        @Nested
        @DisplayName("And the user has enough points")
        class hasPoints {

            @Test
            @DisplayName("The customer gets a 10% discount")
            public void testTestStructure() {
                assertEquals(1, 1);
            }

        }
    }

    @Nested
    @DisplayName("Given a big order")
    class bigOrder{


        @Nested
        @DisplayName("And the user has no points")
        class noPoints{


            @Test
            @DisplayName("The customer gets a standard 20$ bulk discount")
            public void testTestStructure(){
                assertEquals(1, 1);
            }


        }
        @Nested
        @DisplayName("And the user has enough points")
        class hasPoints {

            @Test
            @DisplayName("The customer gets a special 35% bulk discount")
            public void testTestStructure() {
                assertEquals(1, 1);
            }

        }
    }
}