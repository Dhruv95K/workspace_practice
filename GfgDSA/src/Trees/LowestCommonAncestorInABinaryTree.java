package Trees;

import java.util.HashMap;
import java.util.Scanner;

public class LowestCommonAncestorInABinaryTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
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

			int a = sc.nextInt();
			int b = sc.nextInt();

			Lca g = new Lca();
			Node k = g.lca(root, a, b);
			System.out.println(k.data);
			// System.out.println();
			t--;

		}

	}

}

class Lca
{

	Node lca(Node root, int n1,int n2)
	{
		if(root == null)
			return null;
		
		if(root.data == n1 || root.data == n2)
			return root;
		
		Node leftLca = lca(root.left, n1, n2);
		Node rightLca = lca(root.right, n1, n2);
		
		
		if(leftLca!=null && rightLca !=null)
			return root;
		
		if(leftLca != null)
			return leftLca;
		
		return rightLca;
	}
}
