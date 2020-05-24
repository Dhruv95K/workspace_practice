package linkedlists;

import java.util.*;

public class Remove_Duplicate_From_LL {
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
			
			llist.head = removeDuplicates(llist.head);
			llist.printList();

			t--;
		}
	}


	static SingleNode removeDuplicates(SingleNode root) {
		SingleNode curr = root;
		while(curr!=null) {
			SingleNode currNext = curr.next;
			while(currNext!=null && currNext.data == curr.data) {
				currNext = currNext.next;
			}
			curr.next = currNext;
			curr = curr.next;
		}
		
		return root;
	}
}
