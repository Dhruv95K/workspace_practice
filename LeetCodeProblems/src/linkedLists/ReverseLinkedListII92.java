package linkedLists;
/*
92. Reverse Linked List II
Reverse a linked list from position m to n. Do it in one-pass.

Note: 1 ¡Ü m ¡Ü n ¡Ü length of list.

Example:

	Input: 1->2->3->4->5->NULL, m = 2, n = 4
	Output: 1->4->3->2->5->NULL
*/

public class ReverseLinkedListII92 {

	public static void main(String[] args) {
		
	}
	
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
		
		ListNode con = null ,tail = head;
		
		for(int i=0;i<m-1;i++) {
			con = tail;
			tail = tail.next;
		}
		
		ListNode prev = tail;
		ListNode curr = tail.next;
		
		for(int i=0;i<n-m;i++) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		
		con.next = prev;
		tail.next = curr;
		
		
		return head;
	}
}
