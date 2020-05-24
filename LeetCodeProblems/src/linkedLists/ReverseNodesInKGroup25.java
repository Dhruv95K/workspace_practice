package linkedLists;
/*
Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
k is a positive integer and is less than or equal to the length of the linked list. 
If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
Example:
	Given this linked list: 1->2->3->4->5
	
	For k = 2, you should return: 2->1->4->3->5
	
	For k = 3, you should return: 3->2->1->4->5

Note:

1. Only constant extra memory is allowed.
2. You may not alter the values in the list's nodes, only nodes itself may be changed.
*/

public class ReverseNodesInKGroup25 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode cur = head;
		ListNode prev = null;
		ListNode nextNode = null;

		ListNode tail = cur;
		ListNode con = prev;

		int len = 0;
		while (cur != null) {
			cur = cur.next;
			len++;
		}

		cur = head;

		while (cur != null && len >= k) {

			for (int i = 0; i < k; i++) {
				nextNode = cur.next;
				cur.next = prev;
				prev = cur;
				cur = nextNode;
			}

			tail.next = cur;
			if (con == null)
				head = prev;
			else
				con.next = prev;

			con = tail;
			tail = cur;
			len -= k;
		}

		return head;
	}

}
