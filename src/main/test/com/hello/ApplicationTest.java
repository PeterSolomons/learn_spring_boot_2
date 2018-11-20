package com.hello;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@Documented
@Inherited
@Retention(RUNTIME)
@Target(TYPE)
@ExtendWith(SpringExtension.class)
public @interface ApplicationTest {

}
