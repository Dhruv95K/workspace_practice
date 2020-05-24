package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class TreeN {
	int data;
	TreeN left;
	TreeN right;

	TreeN(int d) {
		data = d;
		left = null;
		right = null;
	}
}

class NodeN {
	int data;
	NodeN next;

	NodeN(int d) {
		data = d;
		next = null;
	}
}

public class MakeBinaryTreeFromLinkedList {

	static NodeN lhead;
	static Queue<TreeN> queue = new LinkedList<TreeN>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			TreeN node = null;
			lhead = null;
			NodeN head = null;
			while (!queue.isEmpty()) {
				queue.poll();
			}
			int n = sc.nextInt();
			if (n != 0) {
				MakeBinaryTreeFromLinkedList llist = new MakeBinaryTreeFromLinkedList();
				int a1 = sc.nextInt();
				head = new NodeN(a1);
				llist.addToTheLast(head);
				lhead = head;
				for (int i = 1; i < n; i++) {
					int a = sc.nextInt();
					llist.addToTheLast(new NodeN(a));
				}
			}
			GfG4 g = new GfG4();
			TreeN root = g.convert(lhead, node);
			try {
				levelOrder(root, n);
			} catch (NullPointerException ex) {
				System.out.println(-1);
			}
			System.out.println();
		}
	}

	public static void levelOrder(TreeN root, int n) {
		queue.add(root);
		while (!queue.isEmpty() && n-- > 0) {
			TreeN proot = queue.remove();
			try {
				queue.add(proot.left);
				queue.add(proot.right);
				System.out.print(proot.data + " ");
			} catch (NullPointerException ex) {
			}
		}
	}

	public void addToTheLast(NodeN head) {
		if (lhead == null)
			lhead = head;
		else {
			NodeN temp = lhead;
			while (temp.next != null)
				temp = temp.next;
			temp.next = head;
		}
	}

}

class GfG4 {
    public static TreeN convert(NodeN head, TreeN node) {
    	if(head == null)
            return null;
        TreeN root = new TreeN(head.data);
        head = head.next;
        Queue<TreeN> q = new LinkedList<>();
        q.add(root);
        while(head!=null) {
        	TreeN parent = q.poll();
        	
        	TreeN left = new TreeN(head.data),right = null;
        	q.add(left);
        	head=head.next;
        	if(head!=null) {
        		right = new TreeN(head.data);
        		q.add(right);
        		head = head.next;
        	}
        	parent.left = left;
        	parent.right = right;
        }
        
        return root;	
    }
}
