package com.hello;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.descriptor.JupiterEngineExtensionContext;

import java.util.Optional;

public class ExtensionUtils {

   public static final ExtensionContext.Namespace NAMESPACE = ExtensionContext.Namespace.create("My", "Custom",
         "Namespace", "for", "my", "extension");

   public static final String EXCEPTION_KEY = "EXCEPTION";

   public static ExtensionContext getEngineContext(ExtensionContext contextParams) {

      Optional<ExtensionContext> context = Optional.of(contextParams);
      while (context.isPresent() && !(context.get() instanceof JupiterEngineExtensionContext)){
         context = context.get().getParent();
      }

      return context.get();
   }
}
