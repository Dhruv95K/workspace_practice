package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LeftViewOfBinaryTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// Node root=null;
		while (t > 0) {
			HashMap<Integer, Node> m = new HashMap<Integer, Node>();
			int n = sc.nextInt();
			Node root = null;
			while (n > 0) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);
				Node parent = m.get(n1);
				if (parent == null) {
					parent = new Node(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}
				Node child = new Node(n2);
				if (lr == 'L')
					parent.left = child;
				else
					parent.right = child;
				m.put(n2, child);
				n--;
			}
			LeftView g = new LeftView();
			g.leftView(root);
			System.out.println();
			t--;
		}

	}

}

class LeftView {
	void leftView(Node root) {
		Queue<Node> q = new LinkedList<>();
		Node cur;
		q.add(root);

		while (!q.isEmpty()) {
			int n = q.size();
			System.out.print(q.peek().data + " ");
			for (int i = 0; i < n; i++) {
				cur = q.poll();
				if (cur.left != null)
					q.add(cur.left);
				if (cur.right != null)
					q.add(cur.right);
			}
		}
	}
}
