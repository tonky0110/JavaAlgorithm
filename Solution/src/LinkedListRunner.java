
public class LinkedListRunner {
	public static void main(String[] args) {
		LinkedList ll = new LinkedList();
		System.out.println("-------------------------------");
		ll.retrieved();
		System.out.println("-------------------------------");
		ll.append(1);
		ll.append(2);
		ll.append(3);
		ll.append(4);
		ll.append(5);
		ll.retrieved();
		System.out.println("-------------------------------");
		ll.append(6);
		ll.append(7);
		ll.retrieved();
		ll.delete(1);
		ll.retrieved();
	}
}

class LinkedList {
	Node header;
	
	public LinkedList() {
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
			if (n.next.data == d) {
				n.next = n.next.next;
			} else {
				n = n.next;
			}
		}
	} 
	
	void retrieved() {
		Node n = header.next;
		while (n != null && n.next != null) {
			System.out.print(n.data + " -> ");
			n = n.next;
		}
		if (n != null) {
			System.out.println(n.data);	
		}
	}
	
	static class Node {
		int data;
		Node next = null;
		public Node() {
			super();
			data = 0;
			next = null;
		}
		public Node(int data) {
			super();
			this.data = data;
			this.next = null;
		}
	}
	
	
}
