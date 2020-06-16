package com.yjn.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 测试迭代器遍历
 * @author 82305
 *
 */

public class TestIterator {
	public static void main(String[] args) {
		testIteratorList();
		testIteratorSet();
		testIteratorMap();
	}

	public static void testIteratorList() {
		List<String>list=new ArrayList<>();
		list.add("11");
		list.add("22");
		list.add("33");
		for(Iterator<String> iterator=list.iterator();iterator.hasNext();) {
			String temp=iterator.next();//返回内容，iter向下移一位
			System.out.println(temp);
		}
		
	}
	
	
	public static void testIteratorSet() {
		Set<String>set=new HashSet<>();
		set.add("11");
		set.add("22");
		set.add("33");
		for(Iterator<String> iterator=set.iterator();iterator.hasNext();) {
			String temp=iterator.next();//返回内容，iter向下移一位
			System.out.println(temp);
		}
		
	}
	
	
	public static void testIteratorMap() {
		Map <Integer,String>map=new HashMap<Integer, String>();
		
		map.put(1, "aa");
		map.put(2, "bb");
		map.put(3, "cc");
		Set<Entry<Integer, String>>set=map.entrySet();
		for(Iterator<Entry<Integer, String>>iterator=set.iterator();iterator.hasNext();) {
			Entry<Integer, String>temp=iterator.next();
			System.out.println(temp.getKey()+"---"+temp.getValue());
		}
		
		
		Set<Integer>ss=map.keySet();
		for(Iterator<Integer>iterator=ss.iterator();iterator.hasNext();) {
			Integer temp=iterator.next();
			System.out.println(temp+"---"+map.get(temp));
		}
	}
}
