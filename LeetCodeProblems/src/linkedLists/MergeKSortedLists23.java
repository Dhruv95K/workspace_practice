package linkedLists;
/*
23. Merge k Sorted Lists
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:
	Input:
	[
	  1->4->5,
	  1->3->4,
	  2->6
	]
	Output: 1->1->2->3->4->4->5->6
*/

public class MergeKSortedLists23 {

	public static void main(String[] args) {

	}

	public ListNode mergeKLists(ListNode[] lists) {
		int k = lists.length;

		return mergeKLists(lists, k - 1);
	}

	private ListNode mergeKLists(ListNode[] lists, int last) {

		while (last != 0) {
			int i = 0, j = last;

			while (i < j) {
				lists[i] = mergeLists(lists[i], lists[j]);
				i++;
				j--;
				if (i >= j)
					last = j;
			}
		}

		return lists[0];
	}

	private ListNode mergeLists(ListNode l1, ListNode l2) {

		ListNode newHead = new ListNode(0);
		ListNode curr = newHead;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				curr.next = l1;
				l1 = l1.next;
			} else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		
		if(l1==null)
			curr.next = l2;
		else
			curr.next = l1;
		
		return newHead.next;
	}

}
