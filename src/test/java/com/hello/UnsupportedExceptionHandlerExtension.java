package com.hello;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestExecutionExceptionHandler;

import static com.hello.ExtensionUtils.*;

public class UnsupportedExceptionHandlerExtension implements TestExecutionExceptionHandler {

   @Override
   public void handleTestExecutionException(ExtensionContext context, Throwable throwable) throws Throwable {
      if (throwable instanceof UnsupportedOperationException) {
         getEngineContext(context).getStore(NAMESPACE).put(EXCEPTION_KEY, throwable);
         return;
      }
      throw throwable;

   }
}
