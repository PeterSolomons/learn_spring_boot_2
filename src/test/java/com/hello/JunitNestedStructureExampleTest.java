package com.hello;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
@DisplayName("CHECK OUT MY TEST STRUCTURE IN JUNIT VIEW!!! \uD83D\uDE04")
public class JunitNestedStructureExampleTest {

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
