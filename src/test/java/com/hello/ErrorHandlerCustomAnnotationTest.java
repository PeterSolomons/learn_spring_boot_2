package com.hello;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ErrorHandlerCustomAnnotationTest {

     //If this hits an unsupported operation exception then it will pass but next time it hits
     // one it will disable the test with the message
   @TestWithErrorHandler
   void identicalTest2() {
      identicalTest();
   }

   @TestWithErrorHandler
   void identicalTest1() {
      identicalTest();

   }

   @TestWithErrorHandler
   void passes(){
      assertTrue(true);
   }

   private void identicalTest() {
      GreetingControllerImpl controller = new GreetingControllerImpl();
      controller.throwsUnsuportedException();
      assertTrue(true);
   }


}
