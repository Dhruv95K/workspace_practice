package linkedLists;

import java.util.Stack;

/*
 445. Add Two Numbers II
You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and
each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:
	Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
	Output: 7 -> 8 -> 0 -> 7
*/

public class AddTwoNumbersII445 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> st1 = new Stack<>();
		Stack<Integer> st2 = new Stack<>();

		while (l1 != null) {
			st1.push(l1.val);
			l1 = l1.next;
		}

		while (l2 != null) {
			st2.push(l2.val);
			l2 = l2.next;
		}

		ListNode l = new ListNode(0);
		int sum = 0;

		while (!st1.isEmpty() || !st2.isEmpty()) {
			if (!st1.isEmpty())
				sum += st1.pop();

			if (!st2.isEmpty())
				sum += st2.pop();

			l.val = sum % 10;
			sum /= 10;
			ListNode head = new ListNode(sum);
			head.next = l;
			l = head;
		}

		return l.val == 0 ? l.next : l;
	}

}
