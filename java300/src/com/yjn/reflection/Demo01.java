package com.yjn.reflection;
/**
 * 测试java.lang.Class的获取方式
 * @author 82305
 *
 */
public class Demo01 {
	public static void main(String[] args) {
		String path="com.yjn.reflection.UserBean";
		try {
			Class class1=Class.forName(path);
			//对象用来表示或封装数据，一个类加载后 jvm会创建一个对应该类的Class对象，类的整个结构会放到对应的Class对象中
			System.out.println(class1.hashCode());
			
			
			Class class2=Class.forName(path);
			System.out.println(class2.hashCode());//和class1的hashcode相同，一个类只对应一个class对象
			
			Class strClass=String.class;
			System.out.println(strClass.hashCode());
			Class strClass2=path.getClass();//path 是一个字符串对象
			System.out.println(strClass2.hashCode());
			
			int []a=new int[10];
			int []b=new int [20];//同样类型 同样维度 在一个Class对象中
			System.out.println(a.getClass().hashCode());
			System.out.println(b.getClass().hashCode());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
