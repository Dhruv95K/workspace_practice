package linkedlists;

import java.util.*;

public class DetectLoop {
	SingleNode head;

	public void push(int new_data) {

		SingleNode new_node = new SingleNode(new_data);
		new_node.next = head;
		head = new_node;
	}

	public static void main(String args[]) {
        int t, d, n, i, x, c;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        for (d = 0; d < t; d++) {
            n = sc.nextInt();
            DetectLoop llist = new DetectLoop();
            SingleNode q;
            for (i = 0; i < n; i++) {
                x = sc.nextInt();
                llist.push(x);
            }
            SingleNode p;
            p = llist.head;
            q = llist.head;
            while (q.next != null) q = q.next;
            c = sc.nextInt();
            if (c > 0) {
                c = c - 1;
                for (i = 0; i < c; i++) {
                    p = p.next;
                }
                q.next = p;
            }
            if (detectLoop(llist.head) == 1)
                System.out.print("True");
            else
                System.out.print("False");
            // System.gc();
        }
    }

	static int detectLoop(SingleNode head) {
		SingleNode slo = head;
		SingleNode fast = head.next;
		while(fast!=null && fast.next!=null && fast != slo) {
			fast = fast.next.next;
			slo = slo.next;
		}
		
		if(fast == slo)
			return 1;
		
		return 0;
	}
}
