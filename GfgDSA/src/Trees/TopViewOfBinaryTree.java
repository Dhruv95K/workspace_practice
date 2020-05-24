package Trees;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TopViewOfBinaryTree {

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

			new TopViewBinaryTree().topView(root);
			System.out.println();
			t--;

		}
	}

}

class TopViewBinaryTree {
	static Map<Integer, MapNode> map;

	static void topView(Node root) {
		map = new TreeMap<>();
		topView(root, 0, 0);

		for (int i : map.keySet()) {
			System.out.print(map.get(i).n.data + " ");
		}

	}

	private static void topView(Node root, int level, int hd) {
		if (root == null)
			return;

		if (map.get(hd) == null)
			map.put(hd, new MapNode(root, level));
		else {
			if (map.get(hd).level > level)
				map.put(hd, new MapNode(root, level));
		}

		topView(root.left, level + 1, hd - 1);
		topView(root.right, level + 1, hd + 1);

	}
}

class MapNode {
	Node n;
	int level;

	public MapNode(Node n, int level) {

		this.n = n;
		this.level = level;
	}

}
