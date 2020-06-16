package com.yjn.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value=ElementType.TYPE)//修饰类
@Retention(RetentionPolicy.RUNTIME)
public @interface TjTable {
	String value();
}
