package com.tonky.util;
public class LinkedList {
	Node header;
	LinkedList() {
		header = new Node();
	}
	
	void append(int d) {
		Node end = new Node(d);
		Node n = header;
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	void delete(int d) {
		Node n = header;
		while (n.next != null) {
			if(n.data == d) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}
	void retrieve() {
		Node n = header.next;
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n.next = n; 
		}
		System.out.println(n.data);
	}
	
	// inner class
	static class Node {
		int data;
		Node next = null;
		
		public Node() {
		}
		
		public Node(int d) {
			data = d;
			next = null;
		}
	}
}

