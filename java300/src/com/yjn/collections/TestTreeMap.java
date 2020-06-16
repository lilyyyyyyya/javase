package com.yjn.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {
	public static void main(String[] args) {
		Map<Integer, String> map=new TreeMap<>();
		map.put(20, "123");
		map.put(98, "789");
		map.put(31, "345");
		//按照key的正序排列
		for(Integer key:map.keySet()) {
			System.out.println(key+"---"+map.get(key));
		}
		//根据Comparable接口的compareTo方法排序
		Map<Employee,String>map2=new TreeMap<>();
		Employee key=new Employee(111, "张三", 2000);
		map2.put(key, "111");
		System.out.println(map2.get(key));
		
		Map<Employee, Integer>map3=new HashMap<>();
		map3.put(key, 11);
		System.out.println(map3.get(key));
	}
}


class Employee implements Comparable<Employee>{
	int id;
	String name;
	double salary;
	public Employee() {
	
	}
	public Employee(int id, String name, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "id:"+this.id+" name:"+this.name+" salary:"+this.salary;
	}
	@Override
	public int compareTo(Employee o) {//负数小于
		if(this.salary>o.salary) {
			return 1;
		}else if(this.salary<o.salary) {
			return -1;
		}else {
			if(this.id>o.id) {
				return 1;
			}else if (this.id<o.id){
				return -1;
			}else {
				return 0;
			}
		}
	}
	
	
}