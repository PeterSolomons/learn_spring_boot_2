package com.hello;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DynamicContainer;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class DynamicTestExamplesTest {

   @BeforeEach
   void setUp() {
      System.out.println("Before Each is only called once for each test factory, not twice even though 2 tests are run!");
   }

   //Dynamic tests have no notion of the junit lifecycle! @BeforeAll/@AfterAll ect...
   @TestFactory
   Collection<DynamicTest> dynamicTestsFromCollection() {
      return Arrays.asList(dynamicTest("Collection Test Name",
            () -> assertEquals(1, 1)
            ),
            dynamicTest("Collection Test Name 2",
                  () -> assertEquals(1, 1)
            ));
   }

   @TestFactory
   Iterator<DynamicTest> dynamicTestsFromIterator() {
      return Arrays.asList(dynamicTest("Iterator Test Name",
            () -> assertEquals(1, 1)
            ),
            dynamicTest("Iterator Test Name 2",
                  () -> assertEquals(1, 1)
            )).iterator();
   }

   @TestFactory
   Stream<DynamicTest> dynamicTestFromStream() {
      return getStreamOfRandomNumbers().limit(1000).mapToObj(randomId -> dynamicTest(
            "DisplayName With random number : " + randomId, () -> {
               assertTrue(randomId >= 1000);
               assertTrue(randomId <= 2000);
            }
      ));
   }

   private LongStream getStreamOfRandomNumbers() {
      Random r = new Random();
      return r.longs(1000, 2000);
   }

   @TestFactory
   Stream<DynamicContainer> dynamicTestWithContainers() {
      return LongStream.range(1, 6).mapToObj(productId -> dynamicContainer(
            "Container for ID " + productId,

            Stream.of(
                  dynamicTest(
                        "Valid Id", () ->
                              assertTrue(productId > 0)

                  ),
                  dynamicContainer(
                        "Test", Stream.of(
                              dynamicTest("Discount applied",
                                    () -> {
                                       System.out.println(productId);
                                       assertTrue(productId > 0);
                                       assertTrue(productId != 0);
                                    }
                              )
                        )
                  )
            )

      ));
   }
}
