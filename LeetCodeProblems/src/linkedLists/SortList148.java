package linkedLists;
/*
148. Sort List
Sort a linked list in O(n log n) time using constant space complexity.

Example 1:
	Input: 4->2->1->3
	Output: 1->2->3->4

Example 2:
	Input: -1->5->3->4->0
	Output: -1->0->3->4->5
*/

public class SortList148 {

	public static void main(String[] args) {

	}

	public ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode midNode = findMiddle(head);
		ListNode afterMid = midNode.next;
		midNode.next = null;

		ListNode left = sortList(head);
		ListNode right = sortList(afterMid);

		return merge(left, right);
	}

	private ListNode mergeRecursive(ListNode h1, ListNode h2) {
		if (h1 == null)
			return h2;
		if (h2 == null)
			return h1;

		ListNode head = null;

		if (h1.val <= h2.val) {
			head = h1;
			head.next = merge(h1.next, h2);
		} else {
			head = h2;
			head.next = merge(h1, h2.next);
		}

		return head;
	}

	private ListNode merge(ListNode h1, ListNode h2) {
		ListNode head = new ListNode(0);
		while (h1 != null && h2 != null) {
			if (h1.val <= h2.val) {
				head.next = h1;
				h1 = h1.next;
			} else {
				head.next = h2;
				h2 = h2.next;
			}
			
			head = head.next;
		}
		
		if(h1== null)
			head.next = h2;
		else
			head.next = h1;
		
		return head.next;
	}

	private ListNode findMiddle(ListNode head) {
		ListNode slo = head;
		ListNode fast = head.next;

		while (fast != null && fast.next != null) {
			slo = slo.next;
			fast = fast.next;
		}

		return slo;
	}

}
