package com.yjn.collections;

import javax.management.RuntimeErrorException;

/**
 * 自定义实现ArrayList
 * @author 82305
 *
 */

public class ArrayListTry <E>{
	private Object[] elementData;
	private int size;
	private static final int DEFAULT_CAPACITY=10;
	
	
	public ArrayListTry() {
		elementData=new Object[DEFAULT_CAPACITY];
	}
	
	
	public ArrayListTry(int capacity) {
		if(capacity<0) {
			throw new RuntimeException("容量不能为负数");
		}else if(capacity==0) {
			elementData=new Object[DEFAULT_CAPACITY];
		}else {
			elementData=new Object[capacity];
		}

	}
	
	
	public void add(E object) {
		//扩容操作
		if(size==elementData.length) {
			Object []newArray=new Object[elementData.length+(elementData.length>>1)];//10+5
			System.arraycopy(elementData, 0, newArray, 0, elementData.length);
			elementData=newArray;
		}
		elementData[size++]=object;
	}
	
	
	@Override
	public String toString() {
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("[");
		for(int i=0;i<size;i++) {
			stringBuilder.append(elementData[i]+",");
		}
		stringBuilder.setCharAt(stringBuilder.length()-1, ']');
		return stringBuilder.toString();
	}
	
	
	public E get(int index) {
		check(index);
		return (E)elementData[index];
	}
	
	
	public void set(E e,int index) {
		check(index);
		elementData[index]=e;
	}
	
	
	public void check(int index) {
		if(index<0||index>=size) {
			throw new RuntimeException("索引不合法"+index);
		}
	}
	
	public void remove(int index) {
		check(index);
		System.arraycopy(elementData, index+1, elementData, index, size-index-1);
		elementData[--size]=null;
	}
	
	public void remove(E e) {
		for(int i=0;i<size;i++) {
			if(e.equals(get(i))) {
				remove(i);
			}
		}
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0?true:false;
	}
	
	public static void main(String[] args) {
		ArrayListTry arrayListTry=new ArrayListTry();
		arrayListTry.add("111");
		arrayListTry.add("222");
		System.out.println(arrayListTry);
		System.out.println(arrayListTry.get(0));
	}
}
