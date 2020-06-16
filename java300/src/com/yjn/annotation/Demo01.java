package com.yjn.annotation;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Demo01 {
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	@MyAnnotation(age=19,studentName="lily")
	public static void main(String[] args) {
		Date d=new Date();
		d.parse("dd");
	}
	@Deprecated
	public void test01() {
		
	}
	@SuppressWarnings("all")
	public void test02() {
		List list=new ArrayList<>();
	}
}
