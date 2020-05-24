package linkedlists;

import java.util.*;
import java.util.TreeMap;
import java.util.Scanner;
import java.util.Iterator;

public class LengthOfLoop {
	SingleNode head;

	void printList(SingleNode head) {
		SingleNode temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

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

	/* Drier program to test above functions */
	public static void main(String args[]) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			LengthOfLoop llist1 = new LengthOfLoop();
			int a1 = sc.nextInt();
			SingleNode head = new SingleNode(a1);
			llist1.addToTheLast(head);
			for (int i = 1; i < n; i++) {
				int a = sc.nextInt();
				llist1.addToTheLast(new SingleNode(a));
			}
			llist1.head = head;
			SingleNode temp = null;
			SingleNode te = null;
			int c = sc.nextInt();
			if (c > 0) {
				temp = head;
				te = head;
				while (te.next != null)
					te = te.next;
				while (c-- > 0)
					temp = temp.next;
				te.next = temp;
				// s->next=temp;
			}

			System.out.println(countNodesinLoop(llist1.head));
		}
	}

	static int countNodesinLoop(SingleNode head) {

		SingleNode slo = head;
		SingleNode fast = head.next.next;
		
		while (fast != null && fast.next != null && slo != fast) {
			fast = fast.next.next;
			slo = slo.next;
		}
		
		if(slo!=fast)
			return 0;
		else {
			slo = fast.next;
			int l = 1;
			while(slo!=fast) {
				slo = slo.next;
				l++;
			}
			return l;
		}
		
	}
}