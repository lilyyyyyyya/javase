package com.yjn.learning;

import java.awt.geom.Dimension2D;

import javax.xml.bind.SchemaOutputResolver;

/**
 * 测试多态
 * @author 82305
 *
 */
public class TestPolym {
	public static void main(String[] args) {
		Animal animal=new Animal();
		cry(animal);
		Animal d=new Dog();
//		d.seeDoor();//d是animal类型 编译器不识别
		Dog d2=(Dog)d;
		d2.seeDoor();
		Dog dog=new Dog();
		cry(dog);
		
		final Animal animal2=new Animal();
		animal2.num=1;
		animal2.num=2;//引用对象的内容可变
//		animal2=animal;//编译不通过，引用不能变
		
	}
	static void cry(Animal animal) {
		animal.shout();
	}
}
class Animal{
	public int num;
	public void shout() {
		System.out.println("叫");
	}
}
class Dog extends Animal{
	public void shout() {
		System.out.println("汪");
	}
	public void seeDoor() {
		System.out.println("看门");
	}
}
class Cat extends Animal{
	public void shout() {
		System.out.println("喵");
	}
}