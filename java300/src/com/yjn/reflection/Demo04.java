package com.yjn.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * 通过反射获取泛型信息
 * @author 82305
 *
 */
public class Demo04 {
	public void test01(Map<String, UserBean>map,List<UserBean>list) {
		System.out.println("test01");
	}
	
	public Map<String, UserBean> test02(){
		System.out.println("test02");
		return null;
	}
	public static void main(String[] args) {
		try {
			Method method=Demo04.class.getMethod("test01", Map.class,List.class);
			Type []types=method.getGenericParameterTypes();
			for(Type type:types) {
				System.out.println("#"+type);
				if(type instanceof ParameterizedType) {
					Type[]types2=((ParameterizedType)type).getActualTypeArguments();
					for(Type type2:types2) {
						System.out.println("泛型类型："+type2);
					}
				}
			}
			
			System.out.println("=====================");
			
			Method method2=Demo04.class.getMethod("test02", null);
			Type t=method2.getGenericReturnType();
			
				if(t instanceof ParameterizedType) {
					Type[]types2=((ParameterizedType)t).getActualTypeArguments();
					for(Type type2:types2) {
						System.out.println("泛型类型："+type2);
					}
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
