package linkedlists;

import java.util.*;
import java.lang.*;
import java.io.*;

public class Partition012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			SingleNode head = new SingleNode(sc.nextInt());
			SingleNode tail = head;
			while (n-- > 1) {
				tail.next = new SingleNode(sc.nextInt());
				tail = tail.next;
			}

			head = segregate(head);
			printList(head);
			System.out.println();
		}
	}

	public static void printList(SingleNode head) {
		if (head == null)
			return;

		SingleNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	static SingleNode segregate(SingleNode head) {
		SingleNode before = new SingleNode(0);
		SingleNode after = new SingleNode(0);
		SingleNode equal = new SingleNode(0);
		SingleNode head1 = before;
		SingleNode head2 = equal;
		SingleNode head3 = after;

		SingleNode curr = head;

		while (curr != null) {
			if (curr.data < 1) {
				head1.next = curr;
				head1 = head1.next;
			} else if (curr.data == 1) {
				head2.next = curr;
				head2 = head2.next;
			} else {
				head3.next = curr;
				head3 = head3.next;
			}
			curr = curr.next;
		}
		if (equal.next != null) {
			head1.next = equal.next;
			head2.next = after.next;
			head3.next = null;
		}else {
			head1.next = after.next;
			head3.next = null;
		}
		return before.next;
	}
}
