package com.yjn.arrays;

public class TestString {
	public static void main(String[] args) {
		String str="abc";
		String str1=new String("ABc");
		String str2="abc"+19;//字符串两边只要有一个是字符串，+就是连接符
		
		String str10="lily";
		String str11="lily";
		String str12=new String("lily");
		System.out.println(str10==str11);//true
		System.out.println(str10==str12);//false
		
		//常用方法
		System.out.println(str.charAt(2));
		System.out.println(str.length());
		System.out.println(str.equalsIgnoreCase(str1));//忽略大小写
		System.out.println(str.indexOf("ab"));//返回字符串中出现ab的第一个索引值
		String s=str.replace('a', 'h');//用h替换a
		System.out.println(s);
		System.out.println(str.startsWith("ab"));//是否以ab开头
		System.out.println(str.endsWith("bc"));//是否以bc结尾
		
		
		s=str.substring(1);
		System.out.println(s);//从1开始到最后
		s=str.substring(0, 2);//下标从0到2，不包括2
		System.out.println(s);
		
		
		s=str1.toLowerCase();//转小写
		System.out.println(s);
		s=str2.toUpperCase();//转大写
		System.out.println(s);
		
		
		String s2="   haha  ha    ";
		s=s2.trim();//去首尾空格 中间不去
		System.out.println(s);
		
		
		 //编译器做了优化,直接在编译的时候将字符串进行拼接
        String str111 = "hello" + " java";//相当于str1 = "hello java";
        String str222 = "hello java";
        System.out.println(str111 == str222);//true
        String str3 = "hello";
        String str4 = " java";
        //编译的时候不知道变量中存储的是什么,所以没办法在编译的时候优化
        String str5 = str3 + str4;
        System.out.println(str2 == str5);//false
	}
}
