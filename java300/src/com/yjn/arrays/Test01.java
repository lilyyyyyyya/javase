package com.yjn.arrays;

public class Test01 {
	public static void main(String[] args) {
		int [] arr01=new int [10];
		String [] strings;
		User [] users=new User[3];
		for(int n:arr01) {
			System.out.println(n);
		}
	}
}

class User{
	private int id;
	private String name;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}