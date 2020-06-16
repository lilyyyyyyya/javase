package com.yjn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value= {ElementType.METHOD,ElementType.CONSTRUCTOR})//数组
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
	String studentName() default "";
	int age() default 0;
	String [] schools() default {};
}