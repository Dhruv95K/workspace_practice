package linkedLists;

/*86. Partition List
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
*/

public class PartitionList86 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode partition(ListNode head, int x) {
		ListNode before = new ListNode(0);
		ListNode after = new ListNode(0);
		
		ListNode h1 = before;
		ListNode h2 = after;
		
		while(head != null) {
			if(head.val < x) {
				h1.next = head;
				h1 = h1.next;
			}
			else {
				h2.next = head;
				h2 = h2.next;
			}
			
			head= head.next;
		}
		
		if(h2!=null)
            h2.next = null;
		
		h1.next = after.next;
		
		return before.next;
	}

}
