package linkedlists;

import java.util.*;

class DNode {
	int data;
	DNode next;
	DNode prev;

	DNode(int data) {
		this.data = data;
		next = prev = null;
	}
}

public class DLinkedList {

	DNode newNode(DNode head, int data) {
		DNode p;
		DNode temp = new DNode(data);
		if (head == null)
			return temp;
		p = head;
		while (p.next != null) {
			p = p.next;
		}
		p.next = temp;
		temp.prev = p;
		return head;
	}

	void printList(DNode node) {
		DNode temp = node;
		while (temp.next != null) {
			temp = temp.next;
		}

		while (temp.prev != null) {
			temp = temp.prev;
		}

		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		DLinkedList DLL = new DLinkedList();
		int t = sc.nextInt();

		while (t > 0) {
			DNode temp;
			DNode head = null;
			int n = sc.nextInt();
			for (int i = 0; i < n; i++) {
				int x = sc.nextInt();
				head = DLL.newNode(head, x);
			}
			int pos = sc.nextInt();
			int data = sc.nextInt();

			GfG g = new GfG();
			g.addNode(head, pos, data);

			DLL.printList(head);
			while (head.next != null) {
				temp = head;
				head = head.next;
			}
			t--;
		}
	}
}

class GfG {
	void addNode(DNode head_ref, int pos, int data) {
		// Your code here
		DNode curr = head_ref;
		DNode pre = null;

		for (int i = 0; i <= pos; i++) {
			pre = curr;
			curr = curr.next;
		}

		DNode newNode = new DNode(data);

		if (curr == null) {
			pre.next = newNode;
			newNode.prev = pre;
			return;
		}
		
		curr.prev.next = newNode;
		newNode.next = curr;
		newNode.prev = curr.prev;
		curr.prev = newNode;
		
	}
}