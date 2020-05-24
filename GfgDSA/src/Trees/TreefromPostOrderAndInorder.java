package Trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TreefromPostOrderAndInorder {

	public void preOrder(Node root) {
		if (root == null)
			return;

		System.out.print(root.data + " ");
		preOrder(root.left);

		preOrder(root.right);

	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		TreefromPostOrderAndInorder ip = new TreefromPostOrderAndInorder();
		int T = sc.nextInt();
		while (T > 0) {
			int n = sc.nextInt();
			int inorder[] = new int[n];
			int postorder[] = new int[n];
			for (int i = 0; i < n; i++)
				inorder[i] = sc.nextInt();
			for (int i = 0; i < n; i++)
				postorder[i] = sc.nextInt();

			Node root = buildTree(inorder, postorder, n);
			ip.preOrder(root);
			System.out.println();

			T--;

		}
	}

	static int postIndex;
	static Map<Integer, Integer> pos;

	static Node buildTree(int in[], int post[], int n) {
		postIndex = n - 1;
		pos = new HashMap<>();
		for (int i = 0; i < n; i++)
			pos.put(in[i], i);

		Node head = buildTree(in, post, 0, n - 1);
		return head;
	}

	private static Node buildTree(int[] in, int[] post, int st, int e) {
		if (st > e)
			return null;

		int val = post[postIndex--];
		Node node = new Node(val);
		if (st == e)
			return node;

		int ind = pos.get(val);

		node.right = buildTree(in, post, ind + 1, e);
		node.left = buildTree(in, post, st, ind - 1);

		return node;
	}

}
