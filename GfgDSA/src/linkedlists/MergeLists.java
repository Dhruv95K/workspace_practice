package linkedlists;

import java.util.LinkedList;
import java.util.Scanner;

public class MergeLists {
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

	/* Function to print linked list */
	void printList() {
		SingleNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	/* Driver program to test above functions */
	public static void main(String args[]) {

		/*
		 * Constructed Linked List is 1->2->3->4->5->6-> 7->8->8->9->null
		 */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t > 0) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			MergeLists llist1 = new MergeLists();
			MergeLists llist2 = new MergeLists();

			int a1 = sc.nextInt();
			SingleNode head1 = new SingleNode(a1);
			llist1.addToTheLast(head1);
			if (sc.hasNextInt())
				for (int i = 1; i < n1; i++) {
					// int a;

					int a = sc.nextInt();
					llist1.addToTheLast(new SingleNode(a));
				}

			int b1 = sc.nextInt();
			SingleNode head2 = new SingleNode(b1);
			llist2.addToTheLast(head2);
			if (sc.hasNextInt())
				for (int i = 1; i < n2; i++) {
					// int b;

					int b = sc.nextInt();
					llist2.addToTheLast(new SingleNode(b));
				}
			llist1.head = sortedMerge(llist1.head, llist2.head);
			llist1.printList();

			t--;

		}
	}

	static SingleNode sortedMerge(SingleNode headA, SingleNode headB) {
		SingleNode root = new SingleNode(0);
		SingleNode curr = root;
		while (headA != null && headB != null) {
			if (headA.data <= headB.data) {
				curr.next = headA;
				headA = headA.next;
			} else {
				curr.next = headB;
				headB = headB.next;
			}
			curr = curr.next;
		}
		if(headA == null)
			curr.next = headB;
		else if(headB == null)
			curr.next = headA;
		
		return root.next;
	}
}
