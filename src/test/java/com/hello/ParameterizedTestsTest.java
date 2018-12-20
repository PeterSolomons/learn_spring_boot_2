package com.hello;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParameterizedTestsTest {


   static int counter1 = 1;
   static int counter2 = 2;
   static int counter3 = 3;
   static int counter4 = 0;
   static int[] daysStartingWithT = new int[]{2, 4};

   @ValueSource(longs = {1, 2, 3, 4, 5})
   @DisplayName("Set of tests name")
   @ParameterizedTest(name = "Test #{index}: productId={0}")
   void test(long productId) {
      System.out.println("productId " + productId);
      assertTrue(productId > 0 && productId < 10);
   }

   @ValueSource(longs = {1, 2, 3, 4, 5})
   @DisplayName("Set of tests with additional logging")
   @ParameterizedTest(name = "Test #{index}: productId={0}")
   void testValueSource(long productId, TestInfo testInfo, TestReporter testReporter) {
      System.out.println("Display name: " + testInfo.getDisplayName());
      testReporter.publishEntry("productID", String.valueOf(productId));

      assertTrue(productId > 0 && productId < 10);
   }

   @EnumSource(Days.class)
   @DisplayName("Runs through the enums within Days")
   @ParameterizedTest(name = "Test #{index}: Day ={0}")
   void testEnumSource(Days day) {
      assertTrue(Days.valueOf(counter1++) == day);
   }

   @EnumSource(value = Days.class, names = {"TUESDAY", "WEDNESDAY", "THURSDAY"})
   @DisplayName("Runs through the enums within Days but only the ones specified")
   @ParameterizedTest(name = "Test #{index}: Day ={0}")
   void testEnumSourceIncludeCertainEnums(Days day) {
      assertTrue(Days.valueOf(counter2++) == day);
   }

   @EnumSource(value = Days.class, names = {"MONDAY", "TUESDAY"}, mode = EnumSource.Mode.EXCLUDE)
   @DisplayName("Runs through the enums within Days excluding Mon and Tues")
   @ParameterizedTest(name = "Test #{index}: Day ={0}")
   void testEnumSourceExcludesCertainEnums(Days day) {
      assertTrue(Days.valueOf(counter3++) == day);
   }

   @EnumSource(value = Days.class, names = "^T.*", mode = EnumSource.Mode.MATCH_ALL)
   @DisplayName("Runs through the enums starting with 'T'")
   @ParameterizedTest(name = "Test #{index}: Day ={0}")
   void testEnumSourceEIncludeMatching(Days day) {
      assertTrue(Days.valueOf(daysStartingWithT[counter4++]) == day);
   }

   private static LongStream provideIds(){
      return LongStream.range(1, 6);
   }

   @MethodSource("provideIds") //Matches the provideIds private method and calls it for the source
   @ParameterizedTest
   void testMethodSource(long productId){
      assertTrue(productId > 0 && productId < 6);
   }

   private static Stream<Arguments> productCost(){
      return provideIds().mapToObj(productId -> Arguments.of(productId, 100* productId));
   }

   @MethodSource("productCost")
   @ParameterizedTest
   void testMethodSource2(long productId, long customerPoints){
      assertTrue(productId *100 == customerPoints);
   }

   @CsvSource({"1, 10", "2, 20", "3, 30", "4, 40"})
   @ParameterizedTest
   void testCsvSouce(int id, int val){
      assertTrue(id > 0 && id * 10 == val);
   }


   @CsvFileSource(resources ="/testData.csv")
   @ParameterizedTest
   void testCsvFileSouce(int id, int val){
      assertTrue(id > 0 && val > 0);
   }
}
