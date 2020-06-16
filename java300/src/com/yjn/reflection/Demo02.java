package com.yjn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 应用反射的API，获取类的信息（名字、属性、方法、构造器）
 * @author 82305
 *
 */
public class Demo02 {
	public static void main(String[] args) {
		String path="com.yjn.reflection.UserBean";
		try {
			Class class1=Class.forName(path);
			//获取类的名字
			System.out.println(class1.getName());//获得包名+类名
			System.out.println(class1.getSimpleName());//获得类名
			
			
			//获取属性
			Field []field=class1.getFields();//只能获取public的属性
			System.out.println(field.length);
			Field []fields=class1.getDeclaredFields();//获取所有属性
			System.out.println(fields.length);
			for(Field temp:fields) {
				System.out.println("属性："+temp);
			}
			//获取方法
			Method []methods=class1.getMethods();
			Method method=class1.getDeclaredMethod("getAge", null);	//如果方法有参，必须传递参数类型对应的class对象
			
			System.out.println(method);
			for(Method temp:methods) {
				System.out.println("方法："+temp);
			}
			//获取构造器
			Constructor[]constructors=class1.getConstructors();
			for(Constructor temp:constructors) {
				System.out.println("构造器："+temp);
			}
			Constructor constructor=class1.getDeclaredConstructor(null);
			Constructor constructor2=class1.getDeclaredConstructor(int.class,int.class,String.class);
			System.out.println(constructor);
			System.out.println(constructor2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
