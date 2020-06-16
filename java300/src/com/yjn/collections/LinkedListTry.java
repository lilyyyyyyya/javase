package com.yjn.collections;

import java.io.ObjectInputStream.GetField;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

/**
 * 自定义一个链表
 * @author 82305
 *
 */

public class LinkedListTry {
	private Node head;
	private Node tail;
	private int size;
	public void add(Object obj) {
		Node node=new Node(obj);
		if(head==null) {
			node.pre=null;
			node.next=null;
			
			head=node;
			tail=node;
		}else {
			node.pre=tail;
			tail.next=node;
			node.next=null;
			tail=node;
		}
		size++;
	}
	
	public Object get(int index) {
		if(index<0||index>=size) {
			throw new RuntimeException("索引不合法");
		}
		Node temp=getNode(index);
		
		return temp==null?null:temp.value;
	}
	
	public Node getNode(int index) {
		Node temp=null;
		if(index<=(size>>1)) {
			temp=head;
			for(int i=0;i<index;i++) {
				temp=temp.next;
			}
		}else {
			temp=tail;
			for(int i=size-1;i>index;i++) {
				temp=temp.pre;
			}
		}
		return temp;
	}
	
	public void remove(int index) {
		Node temp=getNode(index);
		if(temp!=null) {
			Node up=temp.pre;
			Node down=temp.next;
			if(up!=null) {
				up.next=down;
			}
			if(down!=null) {
				down.pre=up;
			}
			if(index==0) {
				head=down;
			}
			if(index==size-1) {
				tail=up;
			}
			size--;
		}
	}
	
	public void add(int index,Object obj) {
		Node newNode=new Node(obj);
		Node temp=getNode(index);
		if(temp!=null) {
			Node up=temp.pre;
			up.next=newNode;
			newNode.pre=up;
			newNode.next=temp;
			temp.pre=newNode;
			size++;
		}

	}
	
	@Override
	public String toString() {
		Node temp=head;
		StringBuilder stringBuilder=new StringBuilder();
		stringBuilder.append("[");
		while(temp!=null) {
			stringBuilder.append(temp.value+",");
			temp=temp.next;
		}
		stringBuilder.setCharAt(stringBuilder.length()-1, ']');
		return stringBuilder.toString();
	}
	
	public static void main(String[] args) {
		LinkedListTry linkedListTry=new LinkedListTry();
		linkedListTry.add("122");
		linkedListTry.add("e23");
		linkedListTry.add("skdla");
		System.out.println(linkedListTry);
		System.out.println(linkedListTry.get(0));
		linkedListTry.remove(0);
		System.out.println(linkedListTry);
	}
}
