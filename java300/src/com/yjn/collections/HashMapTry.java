package com.yjn.collections;
/**
 * 自定义实现hashmap
 * @author 82305
 *
 */
public class HashMapTry <K,V>{
	Node2[] table;//位桶数组，bucketarray
	int size;
	public HashMapTry() {
		table=new Node2[16];//长度一般定义为2的整数次幂
		
	}
	
	public int myHash(int v,int length) {
		return v&(length-1);
	}
	
	public void put(K key,V value) {
		Node2 newNode=new Node2();
		newNode.hash=myHash(key.hashCode(), table.length);
		newNode.key=key;
		newNode.value=value;
		
		Node2 temp=table[newNode.hash];
		Node2 iterLast=null;
		boolean keyRepeat=false;
		if(temp==null) {
			table[newNode.hash]=newNode;
			size++;
		}else {
			while(temp!=null) {
				if(temp.key.equals(newNode.key)) {
					temp.value=value;
					keyRepeat=true;
					break;
				}else {
					iterLast=temp;
					temp=temp.next;
				}

			}
			if(!keyRepeat) {
				iterLast.next=newNode;
				size++;
			}
			
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder stringBuilder=new StringBuilder("[");
		for(int i=0;i<table.length;i++) {
			Node2 temp=table[i];
			while(temp!=null) {
				stringBuilder.append(temp.key+":"+temp.value+",");
				temp=temp.next;
			}
		}
		stringBuilder.setCharAt(stringBuilder.length()-1, ']');
		return stringBuilder.toString();
	}
	
	public Object get(K key) {
		int hash=myHash(key.hashCode(), table.length);
		V value=null;
		Node2 temp=table[hash];
		while(temp!=null) {
			if(temp.key.equals(key)) {
				value=(V)temp.value;
				break;
			}
			temp=temp.next;
		}
		
		
		return value;
	}
	
	public static void main(String[] args) {
		HashMapTry <Integer,String>hashMapTry=new HashMapTry();
		hashMapTry.put(10,"aa");
		hashMapTry.put(20,"bb");
		hashMapTry.put(10,"cc");
		hashMapTry.put(53, "dd");
		hashMapTry.put(69, "ee");
		hashMapTry.put(85, "ff");
		System.out.println(hashMapTry);
		System.out.println(hashMapTry.get(69));
	}
}
