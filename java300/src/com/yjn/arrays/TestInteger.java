package com.yjn.arrays;

public class TestInteger {
	public static void main(String[] args) {
		Integer a=new Integer(3);
		Integer b=Integer.parseInt("111");
		Integer c=new Integer("1111");
		int d=c.intValue();
		double e=c.doubleValue();
		String s=b.toString();
		Integer h=5;//自动装箱，假自动
		
		
		Integer in1 = -128;
        Integer in2 = -128;
        System.out.println(in1 == in2);//true 因为123在缓存范围内
        System.out.println(in1.equals(in2));//true
        Integer in3 = 1234;
        Integer in4 = 1234;
        System.out.println(in3 == in4);//false 因为1234不在缓存范围内
        System.out.println(in3.equals(in4));//true
	}
}
