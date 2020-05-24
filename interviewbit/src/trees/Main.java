package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class Main {

	class TreeNode {
		int val;
		TreeNode left, right;

		TreeNode(int x) {
			val = x;
			left = right = null;
		}
	}

	static TreeNode prev;

	TreeNode solve(TreeNode root) {
		prev = null;
		return bToDLL(root);
	}

	TreeNode bToDLL(TreeNode root) {
		if (root == null)
			return null;

		TreeNode head = bToDLL(root.left);
		if (prev == null)
			head = root;
		else {
			prev.right = root;
			root.left = prev;
		}

		prev = root;
		bToDLL(root.right);
		return head;
	}

	BufferedReader br;
	PrintWriter out;

	void traversal(TreeNode root) {
		if (root == null)
			return;
		TreeNode t = root;
		do {
			out.print(root.val + " ");
			root = root.right;
		} while (t != root && root != null);
		out.println();
	}

	void deSerialize(TreeNode root, int a[], int n) {
		if (n == 0)
			return;
		int val = a[n - 1];
		n--;
		if (val == -1)
			return;
		root = new TreeNode(val);
		deSerialize(root.left, a, n);
		deSerialize(root.right, a, n);
	}

	void solve() {
		int t = ni();
		while (t-- > 0) {
			int n = ni();
			int a[] = new int[n];
			for (int i = 0; i < n; i++)
				a[n - i - 1] = ni();
			TreeNode root = null;
			deSerialize(root, a, n);
			root = solve(root);
			traversal(root);
		}
	}

	int ni() {
		return Integer.parseInt(ns());
	}

	StringTokenizer ip;

	String ns() {
		if (ip == null || !ip.hasMoreTokens()) {
			try {
				ip = new StringTokenizer(br.readLine());
			} catch (IOException e) {
				throw new InputMismatchException();
			}
		}
		return ip.nextToken();
	}

	void run() {
		br = new BufferedReader(new InputStreamReader(System.in));
		out = new PrintWriter(System.out);
		solve();
		out.flush();
	}

	public static void main(String[] args) {
		new Main().run();
	}

}

