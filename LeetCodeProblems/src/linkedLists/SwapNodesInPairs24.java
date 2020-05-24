package linkedLists;

/*
 24. Swap Nodes in Pairs
Given a linked list, swap every two adjacent nodes and return its head.

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example:

Given 1->2->3->4, you should return the list as 2->1->4->3.
*/

public class SwapNodesInPairs24 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode swapPairsRecursive(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode node = head.next.next;
		ListNode oldHead = head;
		ListNode newHead = head.next;
		newHead.next = oldHead;
		oldHead.next = swapPairsRecursive(node);
		return newHead;
	}

	public ListNode swapPairs(ListNode head) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode pre = dummy;
		
		while(head!=null && head.next!=null) {
			ListNode sec = head.next;
			head.next = sec.next;
			sec.next = head;
			pre.next = sec;
			pre = head;
			head = head.next;
		}

		return dummy.next;
	}
}
