
class ListNode {
	int val;
	ListNode next;

	public ListNode(int val) {
		this.val = val;
		next = null;
	}

	public ListNode() {

	}
}

public class LinkedList {

	ListNode head;

	public LinkedList() {
		head = null;
	}

	public int get(int index) {
		ListNode cur = head;
		while (index-- > 0) {
			cur = cur.next;
			if (cur == null)
				return -1;
		}

		return cur.val;
	}

	public void addAtHead(int val) {
		if (head == null) {
			head = new ListNode(val);
			return;
		}

		ListNode newNode = new ListNode(val);
		newNode.next = head;
		head = newNode;
	}

	public void addAtTail(int val) {
		ListNode cur = head;
		while (cur.next != null) {
			cur = cur.next;
		}
		ListNode newNode = new ListNode(val);
		cur.next = newNode;
		newNode.next = null;
	}

	public void addAtIndex(int index, int val) {
		ListNode newNode = new ListNode(val);
		if(index == 0)
			addAtHead(val);
		
		ListNode cur = head;
		while (index-- > 1) {
			cur = cur.next;
			if (cur == null)
				return;
		}

		newNode.next = cur.next;
		cur.next = newNode;
	}

	public void deleteAtIndex(int index) {
		if(index == 0){
            head = head.next;
            return;
        }
		ListNode cur = head;
		while (index-- > 1) {
			cur = cur.next;
			if (cur == null)
				return;
		}
		
		if(cur.next != null)
			cur.next = cur.next.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
