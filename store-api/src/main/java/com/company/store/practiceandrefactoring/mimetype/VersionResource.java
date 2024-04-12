package com.company.store.practiceandrefactoring.mimetype;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface VersionResource {

    String media() default "application/vnd.example";
    String from() default "";
    String to() default MAX_VERSION;

    String MAX_VERSION = "99.99";
}