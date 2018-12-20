package com.hello;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParamaterizedTestsTest {


   @ValueSource(longs = {1,2,3,4,5})
   @DisplayName("Set of tests name")
   @ParameterizedTest(name = "Test #{index}: productId={0}")
   void test(long productId){
      System.out.println("productId " + productId);
      assertTrue(productId > 0 && productId < 10);
   }

   @ValueSource(longs = {1,2,3,4,5})
   @DisplayName("Set of tests with additional logging")
   @ParameterizedTest(name = "Test #{index}: productId={0}")
   void testValueSource(long productId, TestInfo testInfo, TestReporter testReporter){
      System.out.println("Display name: " + testInfo.getDisplayName());
      testReporter.publishEntry("productID" , String.valueOf(productId));

      assertTrue(productId > 0 && productId < 10);
   }

   @EnumSource(Days.class)
   @DisplayName("Runs through the enums within Days")
   @ParameterizedTest(name = "Test #{index}: Day ={0}")
   void testEnumSource(Days day){
      assertTrue(Days.valueOf(counter++) == day);
   }static int counter = 1;

}
