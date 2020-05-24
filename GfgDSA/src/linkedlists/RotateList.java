package linkedlists;

import java.util.*;

public class RotateList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			SingleNode head = null;
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				head = addToTheLast(new SingleNode(a), head);
			}
			int k = sc.nextInt();

			head = rotate(head, k); // rotate linked list anti-clockwise by k nodes
			printList(head);
		}
	}

	// insert function to build linked list
	public static SingleNode addToTheLast(SingleNode node, SingleNode head) {
		if (head == null) {
			head = node;
		} else {
			SingleNode temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = node;
		}
		return head;
	}

	public static void printList(SingleNode node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.next;
		}
		System.out.println();
	}

	public static SingleNode rotate(SingleNode head, int k) {
		// add code here.
		SingleNode prev  = null;
		SingleNode curr  = head;
		
		for(int i = 1;i<k;i++) {
			curr = curr.next;
			if(curr==null)
				curr = head;	
		}
		
		SingleNode temp  = curr;
		while(temp.next!=null) 
			temp = temp.next;
		
		temp.next = head;
		head = curr.next;
		curr.next = null;
		
		return head;
	}
}
