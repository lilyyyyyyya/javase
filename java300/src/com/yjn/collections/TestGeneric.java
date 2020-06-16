package com.yjn.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试泛型
 * @author 82305
 *
 */

public class TestGeneric {
	public static void main(String[] args) {
		MyCollection <String>myCollection=new MyCollection<>();
		myCollection.set("hahaha", 0);
		String string=myCollection.get(0);
		
		
	}
}
class MyCollection<T>{
	Object []objects=new Object[5];
	public void set(T object,int index) {
		objects[index]=object;
	}
	public T get(int index) {
		return (T)objects[index];
	}
}