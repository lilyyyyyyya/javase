package com.yjn.arrays;

public class TestArrayCopy {
	public static void main(String[] args) {
		String [] s1= {"aa","bb","cc","dd","ee"};
		String [] s2=new String[10];
		System.arraycopy(s1, 2, s2, 6, 2);//将s1从index为2的位置开始拷贝两个到s2index为6的位置
//		for(int i=0;i<s2.length;i++) {
//			System.out.println(s2[i]);
//		}
//		removeIndex(s1, 1);
		s1=extendsRange(s1, 0, "haha");
	}
	//在=从数组中删除某个元素
	public static void testCopy() {
		String [] s1= {"aa","bb","cc","dd","ee"};
//		String [] s2=new String[5];
		System.arraycopy(s1, 3, s1, 2, 2);
		for(int i=0;i<s1.length;i++) {
			System.out.println(s1[i]);
		}
	}
	public static String[] removeIndex(String[]s,int index) {
		System.arraycopy(s, index+1, s, index, s.length-index-1);
		s[s.length-1]=null;
		for(int i=0;i<s.length;i++) {
			System.out.println(s[i]);
		}
		return s;
	}
	//数组的扩容，先定义一个更大的数组，将原数组拷贝到新数组
	public static String[] extendsRange(String[]s,int index,String s1) {
		String []s2=new String[s.length+1];
		System.arraycopy(s, 0, s2, 0, index);
		s2[index]=s1;
		System.arraycopy(s, index, s2, index+1, s.length-index);
		for(int i=0;i<s2.length;i++) {
			System.out.println(s2[i]);
		}
		return s2;
	}
}
