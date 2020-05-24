package linkedLists;

/*
 82. Remove Duplicates from Sorted List II
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

Example 1:

Input: 1->2->3->3->4->4->5
Output: 1->2->5
Example 2:

Input: 1->1->1->2->3
Output: 2->3
*/

public class RemoveDuplicatesFromSortedListII82 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode deleteDuplicates(ListNode head) {
		if(head == null)
			return null;
		
		ListNode newHead = new ListNode(0);
		newHead.next = head;
		ListNode pre = newHead;
		ListNode cur = head;
		
		while(cur!=null) {
			while(cur.next!=null && cur.val == cur.next.val)
				cur = cur.next;
			
			if(pre.next == cur) 
				pre = pre.next;
			else {
				pre.next = cur.next;
			}
			cur = cur.next;
		}
		
		return newHead.next;
	}

}
