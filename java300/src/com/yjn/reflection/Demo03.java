package com.yjn.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 通过反射API动态的操作构造器、方法、属性
 * @author 82305
 *
 */
public class Demo03 {
	public static void main(String[] args) {
		String path="com.yjn.reflection.UserBean";
		try {
			Class class1=Class.forName(path);
			//通过动态调用构造方法，构造对象
			UserBean bean=(UserBean)class1.newInstance();
			Constructor<UserBean>constructor=class1.getDeclaredConstructor(int.class,int.class,String.class);
			UserBean bean2 =constructor.newInstance(1001,18,"lily");
			System.out.println(bean2.getName());
			
			
			//通过反射调用普通方法
//			bean.setAge(20);
			Method method=class1.getDeclaredMethod("setAge", int.class);
			method.invoke(bean, 20);
			System.out.println(bean.getAge());
			
			
			//通过反射机制操作属性
			Field field=class1.getDeclaredField("name");
//			field.set(bean, "lucy");
//			System.out.println(bean.getName());//不能访问私有属性
			field.setAccessible(true);//不做安全检查可以访问私有
			field.set(bean, "lucy");
			System.out.println(bean.getName());
			System.out.println(field.get(bean));
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
