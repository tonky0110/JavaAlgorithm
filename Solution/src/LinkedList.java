
public class LinkedList {
	public static void main(String[] args) {
		Node head = new Node();
		head.append(1);
		head.append(2);
		head.append(3);
		head.append(4);
		head.append(5);
		head.append(6);
		head.append(7);
		
		head.retrieve();
		
		head.delete(3);
		head.retrieve();
		
		head.delete(1);
		head.retrieve();
	}
}
class Node {
	int data;
	Node next;
	public Node() {
		super();
		this.data = 0;
		this.next = null;
	}
	public Node(int data) {
		super();
		this.data = data;
		this.next = null;
	}
	public Node(int data, Node next) {
		super();
		this.data = data;
		this.next = next;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
	void append(int d) {
		Node end = new Node(d);
		Node n = this;
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	void delete(int d) {
		Node n = this;
		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	}
	void retrieve() {
		Node n = this;
		while(n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		System.out.println(n.data);
	}
}