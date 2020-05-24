package linkedlists;

import java.util.*;
import java.io.*;

public class ReverseLinkedList {
	SingleNode head; // head of lisl
	SingleNode lastNode;
	static PrintWriter out;

	/* Linked list Node */
	/* Utility functions */
	/* Inserts a new Node at front of the list. */
	public void addToTheLast(SingleNode node) {
		if (head == null) {
			head = node;
			lastNode = node;
		} else {
			SingleNode temp = head;
			lastNode.next = node;
			lastNode = node;
		}
	}

	/* Function to print linked list */
	void printList() {
		SingleNode temp = head;
		while (temp != null) {
			out.print(temp.data + " ");
			temp = temp.next;
		}
		out.println();
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(new BufferedOutputStream(System.out));
		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			int n = Integer.parseInt(br.readLine());
			ReverseLinkedList llist = new ReverseLinkedList();
			String nums[] = br.readLine().split(" ");
			if (n > 0) {
				int a1 = Integer.parseInt(nums[0]);
				SingleNode head = new SingleNode(a1);
				llist.addToTheLast(head);
			}
			for (int i = 1; i < n; i++) {
				int a = Integer.parseInt(nums[i]);
				llist.addToTheLast(new SingleNode(a));
			}
			llist.head = reverseList(llist.head);

			llist.printList();

			t--;
		}
		out.close();
	}

	static SingleNode reverseList(SingleNode head) {
		SingleNode curr = head;
		SingleNode prev = null;
		SingleNode nxt = null;
		while(curr != null) {
			nxt = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nxt;
		}
		
		head = prev;
		return head;
	}
}
