package Trees;

import java.util.HashMap;
import java.util.Scanner;

public class CountNumberOfSubTreesHavingGivenSum {

	public static Node target;

	CountNumberOfSubTreesHavingGivenSum() {
		target = null;
	}

	public static void inorder(Node root, int key) {
		if (root == null)
			return;
		inorder(root.left, key);
		if (root.data == key)
			target = root;
		inorder(root.right, key);
	}

	/* Drier program to test above functions */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			CountNumberOfSubTreesHavingGivenSum llist = new CountNumberOfSubTreesHavingGivenSum();
			Node root = null, parent = null;
			HashMap<Integer, Node> m = new HashMap<>();
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				char c = sc.next().charAt(0);
				if (m.containsKey(a) == false) {
					parent = new Node(a);
					m.put(a, parent);
					if (root == null)
						root = parent;
				} else
					parent = m.get(a);
				Node child = new Node(b);
				if (c == 'L')
					parent.left = child;
				else
					parent.right = child;
				m.put(b, child);
			}
			int x = sc.nextInt();
			MaxSum obj = new MaxSum();
			System.out.println(obj.countSubtreesWithSumX(root, x));
		}
	}

}

class MaxSum {
	static int count;

	int countSubtreesWithSumX(Node root, int x) {
		count = 0;
		int c = helper(root, x);
		if(c == x)
			count++;
		
		return count;
	}

	private int helper(Node root, int x) {
		if (root == null)
			return Integer.MAX_VALUE;
		if (root.left == null && root.right == null)
			return root.data;

		int l = helper(root.left, x);
		int r = helper(root.right, x);

		if (l == x)
			count++;
		if (r == x)
			count++;

		return (l == Integer.MAX_VALUE ? 0 : l) + (r == Integer.MAX_VALUE ? 0 : r) + root.data;
	}
}
