package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ConstructBinaryTreeFromParentArray {

	static ArrayList<Integer> result = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];

			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();

			GfG1 gfg = new GfG1();
			Node root = gfg.createTree(arr, n);

			printLevelOrder(root);
			System.out.println();
		}
	}

	public static void printList(Node root) {
		while (root != null) {
			System.out.print(root.data + " ");
		}
	}

	public static void printLevelOrder(Node root) {
		int h = height(root);
		int i;
		for (i = 1; i <= h; i++) {
			result.clear();
			printGivenLevel(root, i);
			Collections.sort(result);
			for (int j = 0; j < result.size(); j++)
				System.out.print(result.get(j) + " ");
		}
	}

	public static int height(Node root) {
		if (root == null)
			return 0;

		else {
			int lheight = height(root.left);
			int rheight = height(root.right);
			if (lheight > rheight)
				return (lheight + 1);
			else
				return (rheight + 1);
		}
	}

	public static void printGivenLevel(Node node, int level) {
		if (node == null)
			return;
		if (level == 1)
			result.add(node.data);
		else if (level > 1) {
			printGivenLevel(node.left, level - 1);
			printGivenLevel(node.right, level - 1);
		}
	}

}

class GfG1 {

	public static Node createTree(int parent[], int n) {
		Node root = null;
		Map<Integer, Node> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(i, new Node(i));
		}

		for (int i = 0; i < n; i++) {
			if (parent[i] == -1)
				root = map.get(i);
			else {
				Node prt = map.get(parent[i]);

				if (prt.left == null)
					prt.left = map.get(i);
				else
					prt.right = map.get(i);
			}
		}

		return root;

	}

	static Node root;

	public static Node createTreeRecursive(int parent[], int n) {
		Node[] created = new Node[n];
		root = null;
		for (Node node : created)
			node = null;

		for (int i = 0; i < n; i++)
			createNode(parent, i, created);

		return root;

	}

	private static void createNode(int[] parent, int i, Node[] created) {

		if (created[i] != null)
			return;

		created[i] = new Node(i);
		if (parent[i] == -1)
			root = created[i];
		else {
			if (created[parent[i]] == null)
				createNode(parent, parent[i], created);

			if (created[parent[i]].left == null)
				created[parent[i]].left = created[i];
			else
				created[parent[i]].right = created[i];

		}
	}

}
