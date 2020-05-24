package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class DiagonalTraversalOfBinaryTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			Node root = null;
			if (n == 1) {
				int a = sc.nextInt();
				System.out.println(a);
				continue;
			} else {
				while (n-- > 0) {
					int n1 = Integer.parseInt(sc.next());
					int n2 = Integer.parseInt(sc.next());
					char lr = sc.next().charAt(0);
					if (root == null) {
						root = new Node(n1);
						switch (lr) {
						case 'L':
							root.left = new Node(n2);
							break;
						case 'R':
							root.right = new Node(n2);
							break;
						}
					} else {
						insert(root, n1, n2, lr);
					}
				}
			}
			GfG3 tree = new GfG3();
			tree.diagonalPrint(root);
			System.out.println();

		}
	}

	public static void insert(Node root, int n1, int n2, char lr) {
		if (root == null)
			return;
		if (root.data == n1) {
			switch (lr) {
			case 'L':
				root.left = new Node(n2);
				break;
			case 'R':
				root.right = new Node(n2);
				break;
			}
		} else {
			insert(root.left, n1, n2, lr);
			insert(root.right, n1, n2, lr);
		}
	}

}

class GfG3 {
	static Map<Integer, ArrayList<Node>> map;

	public void diagonalPrint(Node root) {
		map = new TreeMap<>();

		diagonalPrint(root, 0);

		for (int i : map.keySet()) {
			for (Node j : map.get(i))
				System.out.print(j.data + " ");
		}
	}

	private void diagonalPrint(Node root, int dl) {
		if (root == null)
			return;

		if (map.get(dl) == null)
			map.put(dl, new ArrayList<>());

		map.get(dl).add(root);

		diagonalPrint(root.right, dl);
		diagonalPrint(root.left, dl + 1);

	}

	public void diagonalPrintIterative(Node root) {
		Node cur = root;
		Queue<Node> q = new LinkedList<>();

		while (cur != null) {
			q.add(cur);
			cur = cur.right;
		}

		q.add(null);
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur != null) {
				System.out.print(cur.data +" ");
				cur = cur.left;
				while(cur != null) {
					q.add(cur);
					cur = cur.right;
				}
			}
			else {
				if(!q.isEmpty())
					q.add(null);
			}
		}
	}
}
