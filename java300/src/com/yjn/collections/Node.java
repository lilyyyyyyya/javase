package com.yjn.collections;

public class Node {
	Node pre;
	Node next;
	Object value;
	public Node() {
		
	}
	
	public Node(Object value) {
		super();
		this.value = value;
	}

	public Node(Node pre, Node next, Object value) {
		super();
		this.pre = pre;
		this.next = next;
		this.value = value;
	}
	
}
