package linkedlists;

import java.util.ArrayList;
import java.util.Scanner;

class Geeks {
	public static SingleNode newNode(int data) {
		SingleNode temp = new SingleNode();
		temp.data = data;
		temp.next = null;
		return temp;
	}

	public static SingleNode insert(SingleNode head, int data) {
		if (head == null)
			head = newNode(data);
		else
			head.next = insert(head.next, data);
		return head;
	}

	public static void makeLoop(SingleNode head, int x) {
		if (x == 0)
			return;
		SingleNode curr = head;
		SingleNode last = head;
		int counter = 0;
		while (counter < x) {
			curr = curr.next;
			counter++;
		}
		while (last.next != null)
			last = last.next;
		last.next = curr;
	}

	public static int detectloop(SingleNode head) {
		SingleNode hare = head.next;
		SingleNode tortoise = head;
		while (hare != tortoise && hare != null && tortoise != null) {
			hare = hare.next;
			tortoise = tortoise.next;
			if (hare != null && hare.next != null)
				hare = hare.next;
			if (hare == tortoise)
				return 1;
		}
		if (hare == tortoise)
			return 1;
		return 0;
	}

	public static int length(SingleNode head, boolean hasloop) {
		int len = 0;
		if (hasloop == false) {
			SingleNode temp = head;
			while (temp != null) {
				len++;
				temp = temp.next;
			}
			return len;
		} else {
			SingleNode hare = head.next;
			SingleNode tortoise = head;
			while (hare != tortoise) {
				hare = hare.next;
				tortoise = tortoise.next;
				hare = hare.next;
				if (hare == tortoise)
					break;
			}

			int looplen = 0;
			while (hare.next != tortoise) {
				hare = hare.next;
				looplen++;
			}

			looplen++;
			SingleNode begin = head;
			int startlen = 0;
			tortoise = tortoise.next;
			while (begin != tortoise) {

				begin = begin.next;
				tortoise = tortoise.next;
				startlen++;
			}
			return looplen + startlen;

		}
	}
}

public class RemoveLoop {
	public static void main(String[] args) {
		/* code */
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int sizeOfArray = sc.nextInt();
			int arr[] = new int[sizeOfArray];

			for (int i = 0; i < sizeOfArray; i++)
				arr[i] = sc.nextInt();

			SingleNode head = null;

			for (int i = 0; i < sizeOfArray; i++) {
				head = new Geeks().insert(head, arr[i]);
			}
			int x = sc.nextInt();
			new Geeks().makeLoop(head, x);

			int length = 0;
			if (new Geeks().detectloop(head) == 1) {
				length = new Geeks().length(head, true);
			} else {
				length = new Geeks().length(head, false);
			}
			removeTheLoop(head);
			if (new Geeks().detectloop(head) == 0 && length == new Geeks().length(head, false))
				System.out.println("1");
			else
				System.out.println("0");
		}
	}

	public static void removeTheLoop(SingleNode head) {
		// Your code here
		/*SingleNode slo = head;
		SingleNode fast = head.next.next;

		while (fast != null && fast.next != null && slo != fast) {
			fast = fast.next.next;
			slo = slo.next;
		}

		if (slo != fast)
			return;

		slo = head;
		SingleNode prev = null;
		while (slo != fast) {
			slo = slo.next;
			prev = fast;
			fast = fast.next;
		}
		
		prev.next = null;*/
		if(head == null)
            return;
            
		SingleNode prev = null;
		SingleNode curr = head;
        
        ArrayList<SingleNode> list = new ArrayList<>();
        
        while(curr !=null)
        {
            if(list.contains(curr)) // loop is found
            {
                prev.next = null;
                return;
            }
            else
            {
                list.add(curr);
            }
                
            prev = curr;
            curr = curr.next;
        }
		
	}
}
