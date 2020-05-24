package Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class CheckIfSubtree {

	static Node buildTree(String str) {

		if (str.length() == 0 || str.charAt(0) == 'N') {
			return null;
		}

		String ip[] = str.split(" ");
		// Create the root of the tree
		Node root = new Node(Integer.parseInt(ip[0]));
		// Push the root to the queue

		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		// Starting from the second element

		int i = 1;
		while (queue.size() > 0 && i < ip.length) {

			// Get and remove the front of the queue
			Node currNode = queue.peek();
			queue.remove();

			// Get the current node's value from the string
			String currVal = ip[i];

			// If the left child is not null
			if (!currVal.equals("N")) {

				// Create the left child for the current node
				currNode.left = new Node(Integer.parseInt(currVal));
				// Push it to the queue
				queue.add(currNode.left);
			}

			// For the right child
			i++;
			if (i >= ip.length)
				break;

			currVal = ip[i];

			// If the right child is not null
			if (!currVal.equals("N")) {

				// Create the right child for the current node
				currNode.right = new Node(Integer.parseInt(currVal));

				// Push it to the queue
				queue.add(currNode.right);
			}
			i++;
		}

		return root;
	}

	static void printInorder(Node root) {
		if (root == null)
			return;

		printInorder(root.left);
		System.out.print(root.data + " ");

		printInorder(root.right);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			String tt = br.readLine();
			Node rootT = buildTree(tt);

			String s = br.readLine();
			Node rootS = buildTree(s);
			// printInorder(root);

			boolean st = isSubtree(rootT, rootS);
			if (st == true) {
				System.out.println("1");
			} else {
				System.out.println("0");
			}
		}
	}

	public static boolean isSubtree(Node T, Node S) {
		if (T == null && S != null)
			return true;

		return isSameTree(T, S) || isSubtree(T.left, S) || isSubtree(T.right, S);
	}

	private static boolean isSameTree(Node a, Node b) {
		if (a == null && b == null)
			return true;
		if (a == null || b == null)
			return false;

		return a.data == b.data && isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
	}

}
