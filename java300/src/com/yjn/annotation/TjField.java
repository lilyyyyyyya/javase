package com.yjn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.FIELD)//属性注解
@Retention(RetentionPolicy.RUNTIME)
public @interface TjField {
	String colmunName();
	String type();
	int length();
}
