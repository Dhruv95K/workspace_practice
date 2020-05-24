package linkedLists;

/*61. Rotate List
Given a linked list, rotate the list to the right by k places, where k is non-negative.

Example 1:
	Input: 1->2->3->4->5->NULL, k = 2
	Output: 4->5->1->2->3->NULL
	Explanation:
	rotate 1 steps to the right: 5->1->2->3->4->NULL
	rotate 2 steps to the right: 4->5->1->2->3->NULL

Example 2:
	Input: 0->1->2->NULL, k = 4
	Output: 2->0->1->NULL
	Explanation:
	rotate 1 steps to the right: 2->0->1->NULL
	rotate 2 steps to the right: 1->2->0->NULL
	rotate 3 steps to the right: 0->1->2->NULL
	rotate 4 steps to the right: 2->0->1->NULL

*/

public class RotateList61 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
		    return head;
	
	    ListNode copyHead = head;
	
        int len = 1;
        while (copyHead.next != null) {
            copyHead = copyHead.next;
            len++;
        }
        
        if(k%len == 0)
        	return head;

        copyHead.next = head;

        for (int i = len - k % len; i > 1; i--)
            head = head.next;

        copyHead = head.next;
        head.next = null;

        return copyHead;
	}
}
