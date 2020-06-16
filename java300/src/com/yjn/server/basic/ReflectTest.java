package com.yjn.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * 反射：把java中的类的各种结构，映射成一个个的java对象
 * 1.获取class对象
 * 2.类.class
 * 3.Class.forName(“包名.类名”)
 * @author 82305
 *
 */
public class ReflectTest {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		//三种方式
		//1.对象.getClass()
		Iphone iphone=new Iphone();
		Class clz=iphone.getClass();
		//2.类.class
		clz=Iphone.class;
		//3.Class.forName(“包名.类名”)
		clz=Class.forName("com.yjn.server.basic.Iphone");
		
		//创建对象
		Iphone iphone2=(Iphone)clz.getConstructor().newInstance();
		System.out.println(iphone2);
	}
}
class Iphone{
	public Iphone() {
		// TODO Auto-generated constructor stub
	}
}