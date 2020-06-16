package com.yjn.reflection;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtMethod;

/**
 * 测试使用iavassist生成一个新的类
 * @author 82305
 *
 */
public class TestJavassist {
	public static void main(String[] args) throws Exception {
		//获得类池
		ClassPool pool=ClassPool.getDefault();
		CtClass ctClass=pool.makeClass("com.yjn.reflection.Emp");
		//创建属性
		CtField f1=CtField.make("private int empno", ctClass);
		CtField f2=CtField.make("private String name", ctClass);
		ctClass.addField(f1);
		ctClass.addField(f2);
		
		//创建方法
		CtMethod m1=CtMethod.make("public int getEmpno(){return empno;}", ctClass);
		CtMethod m2=CtMethod.make("public String getName(){return name;}", ctClass);
		CtMethod m3=CtMethod.make("public void setEmpno(int empno){this.empno=empno;}", ctClass);
		CtMethod m4=CtMethod.make("public void setName(String name){this.name=name;}", ctClass);
		ctClass.addMethod(m1);
		ctClass.addMethod(m2);
		ctClass.addMethod(m3);
		ctClass.addMethod(m4);
		
		
		//添加构造器
		CtConstructor constructor=new CtConstructor(new CtClass[] {CtClass.intType,pool.get("java.lang.String")}, ctClass);
		constructor.setBody("{this.empno=empno;this.name=name;}");
		ctClass.addConstructor(constructor);
		//将上面构造好的类写入到
		ctClass.writeFile("");
	}
}
