package com.yjn.reflection;

import java.lang.reflect.Method;
import java.util.Arrays;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.Modifier;
import javassist.NotFoundException;

/**
 * 测试javassist的api
 * 
 * @author 82305
 *
 */
public class TestJavassistApi {
	/**
	 * 处理类的基本用法
	 * @throws Exception 
	 */
	public static void test01() throws Exception {
		ClassPool pool=ClassPool.getDefault();
		CtClass ctClass=pool.get("com.yjn.reflection.UserBean");
		byte[]bytes=ctClass.toBytecode();
		System.out.println(Arrays.toString(bytes));
		System.out.println(ctClass.getName());
		System.out.println(ctClass.getSimpleName());
	}
	/**
	 * 测试产生新的方法
	 * @throws Exception
	 */
	public static void test02() throws Exception {
		ClassPool pool=ClassPool.getDefault();
		CtClass ctClass=pool.get("com.yjn.reflection.UserBean");
		
//		CtMethod method=CtNewMethod.make("public int add(int a,int b){return a+b;}", ctClass);
		
		CtMethod method=new CtMethod(CtClass.intType, "add",
				new CtClass[] {ctClass.intType,ctClass.intType},ctClass);
		method.setModifiers(Modifier.PUBLIC);
		method.setBody("{System.out.println(\"1234567489\");return $1+$2;}");
		ctClass.addMethod(method);
		//通过反射调用新的方法
		Class clazz=ctClass.toClass();
		Object object=clazz.newInstance();
		Method m=clazz.getDeclaredMethod("add", int.class,int.class);
		Object result=m.invoke(object, 200,300);
		System.out.println(result);
		
	}
	/**
	 * 修改已有的方法信息
	 * @throws Exception
	 */
	public static void test03() throws Exception {
		ClassPool pool=ClassPool.getDefault();
		CtClass ctClass=pool.get("com.yjn.reflection.UserBean");
		CtMethod ctMethod=ctClass.getDeclaredMethod("sayHello",new CtClass[] {CtClass.intType});
		ctMethod.insertBefore("System.out.println($1);");
		ctMethod.insertAfter("System.out.println($1);");
		//通过反射调用新的方法
		Class clazz=ctClass.toClass();
		Object object=clazz.newInstance();
		Method m=clazz.getDeclaredMethod("sayHello",int.class);
		Object result=m.invoke(object,300);
		System.out.println(result);
	}
	
	public static void test04() throws Exception {
		ClassPool pool=ClassPool.getDefault();
		CtClass ctClass=pool.get("com.yjn.reflection.UserBean");
		CtField f1=new CtField(CtClass.intType, "empno", ctClass);
		f1.setModifiers(Modifier.PRIVATE);
		ctClass.addField(f1);
		ctClass.addMethod(CtNewMethod.getter("getEmpno", f1));
	}
	
	
	public static void main(String[] args) throws Exception {
//		test01();
//		test02();
		test04();
	}
}
