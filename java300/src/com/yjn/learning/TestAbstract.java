package com.yjn.learning;

public class TestAbstract {

}
abstract class People{
	abstract public void shout();
	public void run() {
		System.out.println("跑");
	}
}
class Person1 extends People{

	@Override
	public void shout() {
		System.out.println("汪");
		
	}
	
}