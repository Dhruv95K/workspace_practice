
public class LinkedList <T> {

	class ListNode {
		T val;
		ListNode next;
		
		public ListNode() {
			next = null;
		}
		
		public ListNode(T val) {
			this.val = val;
			next = null;
		}

	}
	
	private ListNode head;
	private int size ;

	public ListNode getHead() {
		return head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public LinkedList() {
		head = null;
		size = 0;
	}

	public T get(int index) {
		ListNode cur = head;
		while (index-- > 0) {
			cur = cur.next;
			if (cur == null)
				return null;
		}

		return cur.val;
	}

	public void addAtHead(T val) {
		if (head == null) {
			head = new ListNode(val);
			return;
		}

		ListNode newNode = new ListNode(val);
		newNode.next = head;
		head = newNode;
		size++;
	}

	public void addAtTail(T val) {
		if(head == null) {
			addAtHead(val);
			return;
		}
		ListNode cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		ListNode newNode = new ListNode(val);
		cur.next = newNode;
		size++;
	//	newNode.next = null;
	}

	public void addAtIndex(int index, T val) {
		ListNode newNode = new ListNode(val);
		if(index == 0) {
			addAtHead(val);
			return;
		}
		
		ListNode cur = head;
		while (index-- > 1) {
			cur = cur.next;
			if (cur == null)
				return;
		}

		newNode.next = cur.next;
		cur.next = newNode;
		size++;
	}
	
	public void deleteAtHead() {
		if(head == null)
			return ;
		head = head.next;
		size--;
	}

	public void deleteAtIndex(int index) {
		if(index == 0){
			deleteAtHead();
            return;
        }
		ListNode cur = head;
		while (index-- > 1) {
			cur = cur.next;
			if (cur == null)
				return;
		}
		
		if(cur.next != null) {
			cur.next = cur.next.next;
			size--;
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void printList() {
		ListNode cur = head;
		while(cur != null) {
			System.out.print(cur.val + " ");
			cur = cur.next;
		}
		
		System.out.println("");
	}

	public static void main(String[] args) {
		LinkedList<String> list1 = new LinkedList<String>();
		list1.addAtHead("Dhruv");
		list1.addAtTail("Parth");
		list1.addAtIndex(2, "Kaju");
		list1.printList();
	}

}
