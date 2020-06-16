package com.yjn.reflection;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

/**
 * 动态编译
 * @author 82305
 *
 */
public class DynamicCompiler {
	public static void main(String[] args) {
		JavaCompiler javaCompiler=ToolProvider.getSystemJavaCompiler();
//		int result=javaCompiler.run(null, null, null, arguments);//最后一个参数为java文件地址
		
	}
}
