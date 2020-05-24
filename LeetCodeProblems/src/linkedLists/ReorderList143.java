package linkedLists;

/*143. Reorder List
Given a singly linked list L: L0¡úL1¡ú¡­¡úLn-1¡úLn,
reorder it to: L0¡úLn¡úL1¡úLn-1¡úL2¡úLn-2¡ú¡­

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.

*/

public class ReorderList143 {

	public static void main(String[] args) {

	}

	public void reorderList(ListNode head) {
		if (head == null || head.next == null || head.next.next == null)
			return;

		ListNode cur = head;

		while (cur != null && cur.next != null && cur.next.next != null) {

			reOrder(cur);
			cur = cur.next.next;
		}

	}

	private void reOrder(ListNode cur) {

		ListNode tail = cur;
		ListNode prevTail = cur;

		while (tail.next != null) {
			prevTail = tail;
			tail = tail.next;
		}

		tail.next = cur.next;
		cur.next = tail;
		prevTail.next = null;

	}

}
