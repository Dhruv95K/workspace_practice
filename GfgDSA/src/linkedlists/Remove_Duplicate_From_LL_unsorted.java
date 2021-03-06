package linkedlists;

import java.util.*;

public class Remove_Duplicate_From_LL_unsorted {
	SingleNode head;

	public void addToTheLast(SingleNode node) {
		if (head == null) {
			head = node;
		} else {
			SingleNode temp = head;
			while (temp.next != null)
				temp = temp.next;
			temp.next = node;
		}
	}

	void printList() {
		SingleNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {

		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n = sc.nextInt();
			Remove_Duplicate_From_LL llist = new Remove_Duplicate_From_LL();
			int a1 = sc.nextInt();
			SingleNode head = new SingleNode(a1);
			llist.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist.addToTheLast(new SingleNode(a));
			}
			// llist.printList();

			llist.head = removeDuplicates(llist.head);
			llist.printList();

			t--;
		}
	}

	// Function to remove duplicates from the given linked list
	static SingleNode removeDuplicates(SingleNode head) {
		SingleNode curr = head;
		SingleNode currNext = null;
		SingleNode prev = null;
		while (curr != null) {
			currNext = curr.next;
			prev = curr;
			while (currNext != null) {
				if (currNext.data == curr.data) {
					prev.next = currNext.next;
					currNext = currNext.next;
				} else {
					prev = currNext;
					currNext = currNext.next;
				}
			}
			curr = curr.next;
		}

		return head;
	}
}
