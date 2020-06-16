package com.yjn.annotation;

@TjTable("tb_student")//对应的表名
public class TjStudent {
	@TjField(colmunName="id",type="int",length=10)
	private int id;
	@TjField(colmunName="sname",type="varchar",length=10)
	private String name;
	@TjField(colmunName="age",type="int",length=3)
	private int age;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
