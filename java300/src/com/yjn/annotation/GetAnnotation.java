package com.yjn.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;


/**
 * 使用反射读取注解
 * @author 82305
 *
 */
public class GetAnnotation {
	public static void main(String[] args) {
		try {
			Class c=Class.forName("com.yjn.annotation.TjStudent");
			Annotation[] annotation=c.getDeclaredAnnotations();//获取类的全部注解
			for(Annotation a:annotation) {
				System.out.println(a);
			}
			//获取类的指定注解
			TjTable table=(TjTable) c.getAnnotation(TjTable.class);
			System.out.println(table.value());
			//获取类属性的注解
			Field field=c.getDeclaredField("name");
			TjField tjField=field.getAnnotation(TjField.class);
			System.out.println(tjField.colmunName()+"--"+tjField.type()+"--"+tjField.length());
			//根据获得的表名字段等拼出sql语句
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
