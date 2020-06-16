package com.yjn.arrays;

import java.util.Arrays;

public class TestArrays {
	public static void main(String[] args) {
		int[]a= {10,0,30};
		System.out.println(a);//输出是哈希码
		System.out.println(Arrays.toString(a));
		Arrays.sort(a);
		System.out.println(Arrays.toString(a));
		System.out.println(Arrays.binarySearch(a, 0));
	}
}
