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
		
		ll.append(3);
		ll.append(5);
		ll.append(7);
		ll.append(9);
		ll.append(9);
		System.out.println("-------------------------------");
		ll.retrieved();
		
		ll.removeDups();
		System.out.println("-------------------------------");
		ll.retrieved();
		
		System.out.println("-------------------------------");
		System.out.println(ll.kthToLas(ll.header, 3).data);;
		
		
		System.out.println("-------------------------------");
		ll.kthToLasWithStack(ll.header, 3);
		ll.kthToLasWithStack(ll.header, 4);
		ll.kthToLasWithStack(ll.header, 5);
		ll.kthToLasWithStack(ll.header, 6);
		
		System.out.println("-------------------------------");
		Reference r = new Reference();
		LinkedList.Node found = ll.kthToLasWithStack(ll.header, 3, r);
		System.out.println("Found: " + found.data);
		
		r.count = 0;
		found = ll.kthToLasWithStack(ll.header, 4, r);
		System.out.println("Found: " + found.data);
		
		r.count = 0;
		found = ll.kthToLasWithStack(ll.header, 5, r);
		System.out.println("Found: " + found.data);
		
		r.count = 0;
		found = ll.kthToLasWithStack(ll.header, 6, r);
		System.out.println("Found: " + found.data);
		
		
		System.out.println("-------------------------------");
		found = ll.kthToLasWithPointer(ll.header, 1);
		System.out.println("Found: " + found.data);
		found = ll.kthToLasWithPointer(ll.header, 2);
		System.out.println("Found: " + found.data);
		found = ll.kthToLasWithPointer(ll.header, 3);
		System.out.println("Found: " + found.data);
	}
}

class Reference{
	int count;
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
	
	void removeDups() {
		Node n = header;
		
		while(n != null && n.next != null) {
			Node r = n;
			while(r.next != null) {
				if (r.next.data == n.data) {
					r.next = r.next.next;
				} else {
					r = r.next;
				}
				
			}
			n = n.next;
		}
	}
	
	Node kthToLas(Node first, int k) {
		Node n = first;
		int total = 1;
		while(n.next != null) {
			total++;
			n = n.next;
		}
		n = first;
		for(int i = 1; i < total-k+1; i++) {
			n = n.next;
		}
		return n;
	}
	
	
	int kthToLasWithStack(Node n, int k) {
		if (n == null) {
			return 0;
		}
		
		int count = kthToLasWithStack(n.next, k) + 1;
		if (count == k) {
			System.out.println(k + "th to last node is " + n.data);
		}
		return count;
	}
	Node kthToLasWithStack(Node n, int k, Reference r) {
		if (n == null) {
			return null;
		}
		
		Node found = kthToLasWithStack(n.next, k, r);
		r.count++;
		if (r.count == k) {
			return n;
		}
		return found;
	}
	
	Node kthToLasWithPointer(Node first, int k) {
		Node p1 = first;
		Node p2 = first;
		
		for(int i = 0; i < k; i++) {
			if (p1 == null) return null;
			p1 = p1.next;
		}
		while(p1 != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p2;
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
