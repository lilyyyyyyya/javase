package com.yjn.learning;

public class TestObject {
	public static void main(String[] args) {
		TestObject to=new TestObject();
		System.out.println(to.toString());//hashCode()的16进制
		Object obj;
		String string;
		User user=new User(1000, "yjn", "111");
		User user1=new User(1000, "yjn", "111");
		System.out.println(user.equals(user1));
		System.out.println(user==user1);

	}
//	public String toString() {
//		return "测试";
//	}
}
class User{
	int id;
	String name;
	String password;
	public User(int id, String name, String password) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
	}
	public boolean equals(User user) {
		return this.id==user.id;
	}
	
}