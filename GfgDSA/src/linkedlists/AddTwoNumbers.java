package linkedlists;

import java.util.*;

public class AddTwoNumbers {
	SingleNode head;

	void printList(SingleNode head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		// System.out.println("");
	}

	public void push(int new_data) {

		SingleNode new_node = new SingleNode(new_data);

		new_node.next = head;

		head = new_node;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T > 0) {
			int n1 = sc.nextInt();
			AddTwoNumbers list1 = new AddTwoNumbers();
			for (int i = 1; i <= n1; i++) {
				int a = sc.nextInt();
				list1.push(a);
			}
			int n2 = sc.nextInt();
			AddTwoNumbers list2 = new AddTwoNumbers();
			for (int i = 0; i < n2; i++) {
				int b = sc.nextInt();
				list2.push(b);
			}
			AddTwoNumbers list3 = new AddTwoNumbers();

			SingleNode rs = addTwoLists(list1.head, list2.head);
			list3.printList(rs);
			System.out.println();
			T--;
		}
	}

	static SingleNode addTwoLists(SingleNode first, SingleNode second) {
		SingleNode newHead = new SingleNode(0);
		SingleNode curr = newHead;
		int cf  = 0;
		int sum = 0;
		while (first!=null || second != null) {
			int a  = first == null ? 0 : first.data;
			int b  = second == null ? 0 : second.data;
			
			sum = (a + b + cf)%10;
			cf = (a + b + cf)/10;
			
			curr.next = new SingleNode(sum);
			curr = curr.next;
			
			if(first!=null)
				first = first.next;
			if(second!=null)
				second = second.next;
		}
		
		while(cf > 0) {
			curr.next = new SingleNode(cf);
		}
		
		return newHead.next;
	}
}