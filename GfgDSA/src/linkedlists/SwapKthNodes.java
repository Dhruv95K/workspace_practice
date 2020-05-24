package linkedlists;

import java.util.*;
import java.io.*;
import java.lang.*;

public class SwapKthNodes {
	static SingleNode head;
	static SingleNode lastNode;

	public static void addToTheLast(SingleNode node) {
		if (head == null) {
			head = node;
			lastNode = node;
		} else {
			SingleNode temp = head;
			lastNode.next = node;
			lastNode = node;
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n, K;
			n = sc.nextInt();
			K = sc.nextInt();

			SingleNode head = null;
			int val = sc.nextInt();
			head = new SingleNode(val);
			addToTheLast(head);

			for (int i = 1; i < n; i++) {
				val = sc.nextInt();
				addToTheLast(new SingleNode(val));
			}

			SingleNode before[] = new SingleNode[n];
			addressstore(before, head);

			head = swapkthnode(head, n, K);

			SingleNode after[] = new SingleNode[n];
			addressstore(after, head);

			if (check(before, after, n, K) == true)
				System.out.println("1");
			else
				System.out.println("0");

		}
	}

	static boolean check(SingleNode before[], SingleNode after[], int num, int K) {
		if (K > num)
			return true;

		return (before[K - 1] == after[num - K]) && (before[num - K] == after[K - 1]);

	}

	static void addressstore(SingleNode arr[], SingleNode head) {
		SingleNode temp = head;
		int i = 0;
		while (temp != null) {
			arr[i] = temp;
			i++;
			temp = temp.next;
		}

	}

	static SingleNode swapkthnode(SingleNode head, int n, int K) {

		SingleNode curr = head;
		SingleNode kStart = head;
		SingleNode prevkStart = null;
		SingleNode kEnd = head;
		SingleNode prevkEnd = null;
		K = K%n;
		for (int i = 1; i < K; i++) {
			prevkStart = curr;
			curr = curr.next;
		}

		kStart = curr;

		while (curr.next != null) {
			prevkEnd = kEnd;
			kEnd = kEnd.next;
			curr = curr.next;
		}

		if (prevkStart != null)
			prevkStart.next = kEnd;
		else
			head = kEnd;

		if (prevkEnd != null)
			prevkEnd.next = kStart;
		else
			head = kEnd;

		SingleNode temp = kStart.next;
		kStart.next = kEnd.next;
		kEnd.next = temp;

		return head;
	}
}
