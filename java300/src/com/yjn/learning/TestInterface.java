package com.yjn.learning;

public class TestInterface{
	public static void main(String[] args) {
		MyInterface myInterface=new Angel();
		myInterface.fly();
	}
}

interface Honest{
	void helpOthers();
}

class Angel implements Honest,MyInterface{

	@Override
	public void fly() {
		System.out.println("fly");
		
	}

	@Override
	public void helpOthers() {
		System.out.println("helpothers");
		
	}
	
}