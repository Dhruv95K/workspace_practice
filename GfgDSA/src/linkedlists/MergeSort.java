package linkedlists;

//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;

public class MergeSort {

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

			head = mergeSort(head);
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

	static SingleNode mergeSort(SingleNode head) {
		if (head == null || head.next == null)
			return head;

		SingleNode midNode = getMiddleNode(head);
		SingleNode afterMidNode = midNode.next;
		midNode.next = null;

		SingleNode left = mergeSort(head);
		SingleNode right = mergeSort(afterMidNode);

		head = merge(left, right);

		return head;
	}

	private static SingleNode merge(SingleNode left, SingleNode right) {
		if(left==null)
			return right;
		if(right==null)
			return left;
		
		SingleNode head = new SingleNode(0);
		if(left.data<=right.data) {
			head = left;
			head.next = merge(left.next, right);
		}
		else {
			head = right;
			head.next = merge(left, right.next);
		}
		
		return head;
	}

	private static SingleNode getMiddleNode(SingleNode head) {
		
		SingleNode slo = head;
		SingleNode fast = head.next;
		
		while(fast!=null && fast.next!=null) {
			slo = slo.next;
			fast=fast.next.next;
		}
		return slo;
	}
}
