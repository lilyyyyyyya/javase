package com.yjn.reflection;

public class UserBean {
	private int id;
	private int age;
	private String name;
	
	public UserBean() {
		// TODO Auto-generated constructor stub
	}
	public UserBean(int id, int age, String name) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void sayHello(int a) {
		System.out.println("hello "+a);
	}
	
}
