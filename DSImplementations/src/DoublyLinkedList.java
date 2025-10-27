
public class DoublyLinkedList<T> {

	class Node {
		T val;
		Node next, prev;

		Node(T val) {
			this.val = val;
			next = prev = null;
		}
	}

	private int size = 0;
	private Node head, tail;

	public boolean isEmpty() {
		return size == 0;
	}

	public DoublyLinkedList() {
		head = tail = null;
	}

	public void add(T val) {
		if (head == null) {
			addAtHead(val);
			return;
		}

		Node newNode = new Node(val);
		tail.next = newNode;
		newNode.prev = tail;
		tail = newNode;
		this.size++;
	}

	public void addAtHead(T val) {
		Node newNode = new Node(val);
		this.size++;
		if (head == null) {
			head = tail = newNode;
			return;
		}

		newNode.next = head;
		head.prev = newNode;
		head = newNode;
	}

	public void addAtIndex(int ind, T val) {
		if (ind == 0) {
			addAtHead(val);
			return;
		}
		if (ind >= this.size) {
			add(val);
			return;
		}
		Node newNode = new Node(val);

		Node cur = head;
		while (ind-- > 1) {
			cur = cur.next;
			if (cur == null)
				return;
		}

		newNode.next = cur.next;
		cur.next.prev = newNode;
		newNode.prev = cur;
		cur.next = newNode;
		this.size++;

	}

	public T get(int ind) {
		if (ind >= size)
			return null;
		if (ind == 0)
			return head.val;

		Node cur = head;
		while (ind-- > 0) {
			cur = cur.next;
			if (cur == null)
				return null;
		}

		return cur.val;
	}

	public boolean contains(T val) {
		Node cur = head;
		while (cur != null) {
			if (cur.equals(val))
				return true;
			cur = cur.next;
		}

		return false;
	}

	public void remove(int ind) {
		if (ind == 0) {
			removeHead();
			return;
		}

		if (ind == size - 1) {
			removeTail();
			return;
		}

		Node cur = head;
		while (ind-- > 0) {
			cur = cur.next;
			if (cur == null)
				return;
		}

		cur.prev.next = cur.next;
		cur.next.prev = cur.prev;
		this.size--;
	}

	private void removeHead() {
		if (head == null)
			return;
		this.size--;
		if (head == tail) {
			head = tail = null;
			return;
		}

		head = head.next;
		head.prev = null;
	}

	private void removeTail() {
		if (tail == null)
			return;
		this.size--;
		if (head == tail) {
			head = tail = null;
			return;
		}

		tail = tail.prev;
		tail.next = null;
	}

	public void print() {
		Node cur = head;
		while (cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		System.out.println("");
	}

	public static void main(String[] args) {
		DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
		list.add(1);
		list.add(1);
		list.add(2);
		list.add(3);
		list.addAtIndex(0, 4);
		list.addAtIndex(2, 5);
		list.print();
		System.out.println("size of list " + list.size);
		
		list.addAtIndex(5, 6);
		list.addAtIndex(10, 7);
		list.print();
		System.out.println("size of list " + list.size);
		
		list.remove(5);
		list.print();
		System.out.println("size of list " + list.size);
		
		System.out.println(list.get(6));
	}

}
