package com.yjn.learning;
/**
 * 测试继承
 * @author 82305
 *
 */
public class TestExtends {
	public static void main(String[] args) {
		Student student=new Student();
		student.name="yjn";
		student.major="软工";
		System.out.println(student instanceof Student);
		System.out.println(student instanceof Person);
		student.test();
		
	}
}

class Person{
	String name="111";
	int height;
	public Person(){
		System.out.println("创建Person");
	}
	public void rest() {
		System.out.println("休息一会");
	}
}

class Student extends Person{
	String major;
	public Student() {
		System.out.println("创建Student");
	}
	public void study() {
		System.out.println("学习！");
	}
	public void test() {
		super.rest();//调用父类中的rest方法
		System.out.println("休息两分钟");
	}
}