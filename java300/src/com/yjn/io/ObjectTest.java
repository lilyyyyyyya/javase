package com.yjn.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * 对象流
 * 1.先写出后读取
 * 2.读取的顺序和写出的顺序一致
 * 3.不是所有对象都能被序列化，必须实现接口Serializable
 * @author 82305
 *
 */
public class ObjectTest {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		//写出--》序列化
		ByteArrayOutputStream baos=new ByteArrayOutputStream();
		ObjectOutputStream dos=new ObjectOutputStream(new BufferedOutputStream(baos));
		
		
		//操作数据类型加数据
		dos.writeObject("11111");
		dos.writeObject(new Date());//实现了接口
		Employee employee=new Employee("lily",30000);
		dos.writeObject(employee);//若不实现接口，报错 java.io.NotSerializableException
		dos.flush();
		
		byte[]datas=baos.toByteArray();
		System.out.println(datas.length);//输出字节流大小
		
		//读取--》反序列化
		ObjectInputStream dis=new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
		Object str=dis.readObject();
		Object date=dis.readObject();
		Object emp=dis.readObject();
		if(emp instanceof Employee) {//还原一定要先判断
			Employee e1=(Employee)emp;
			System.out.println(e1);
		}
		
	}
}

class Employee implements java.io.Serializable{
	private String name;
	//transient关键字：该序列不需要序列化
//	private transient String name;
	private double salary;
	public Employee() {
		// TODO Auto-generated constructor stub
	}
	
	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}
	

	@Override
	public String toString() {
		return "Employee [name=" + name + ", salary=" + salary + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
}
