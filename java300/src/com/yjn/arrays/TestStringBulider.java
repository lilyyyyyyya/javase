package com.yjn.arrays;

public class TestStringBulider {
	public static void main(String[] args) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<26;i++) {
			sb.append((char)('a'+i));
		}
		System.out.println(sb);
		sb.reverse();
		System.out.println(sb);
		sb.setCharAt(3, '姚');
		System.out.println(sb);
		sb.insert(0, '我').insert(6, '金');//链式调用，核心：该方法调用了return this;将自己返回去
		System.out.println(sb);
		sb.delete(0, 2);
		System.out.println(sb);
		
		//测试String和StringBuilder的性能
		String str8 = "";
        //本质上使用StringBuilder拼接, 但是每次循环都会生成一个StringBuilder对象
        long num1 = Runtime.getRuntime().freeMemory();//获取系统剩余内存空间
        long time1 = System.currentTimeMillis();//获取系统的当前时间
        for (int i = 0; i < 5000; i++) {
            str8 = str8 + i;//相当于产生了10000个对象
        }
        long num2 = Runtime.getRuntime().freeMemory();
        long time2 = System.currentTimeMillis();
        System.out.println("String占用内存 : " + (num1 - num2));
        System.out.println("String占用时间 : " + (time2 - time1));
        /**使用StringBuilder进行字符串的拼接*/
        StringBuilder sb1 = new StringBuilder("");
        long num3 = Runtime.getRuntime().freeMemory();
        long time3 = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++) {
            sb1.append(i);
        }
        long num4 = Runtime.getRuntime().freeMemory();
        long time4 = System.currentTimeMillis();
        System.out.println("StringBuilder占用内存 : " + (num3 - num4));
        System.out.println("StringBuilder占用时间 : " + (time4 - time3));
	}
}
