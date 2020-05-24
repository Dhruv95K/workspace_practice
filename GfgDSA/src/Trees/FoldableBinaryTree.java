package Trees;

import java.util.Scanner;

public class FoldableBinaryTree {

	public static void insert(Node root, int a, int a1, char lr) {
		if (root == null) {
			return;
		}
		if (root.data == a) {
			switch (lr) {
			case 'L':
				root.left = new Node(a1);
				break;
			case 'R':
				root.right = new Node(a1);
				break;
			}
			return;
		}
		insert(root.left, a, a1, lr);
		insert(root.right, a, a1, lr);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			if (n == 0) {
				System.out.println(0);
				continue;
			}
			Node root = null;
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int a1 = sc.nextInt();
				char lr = sc.next().charAt(0);
				if (i == 0) {
					root = new Node(a);
					switch (lr) {
					case 'L':
						root.left = new Node(a1);
						break;
					case 'R':
						root.right = new Node(a1);
						break;
					}
				} else {
					insert(root, a, a1, lr);
				}
			}

			GFG5 gfg = new GFG5();
			boolean val = gfg.isFoldable(root);
			if (val == true)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}

	public static void mirror(Node node) {
		if (node == null)
			return;
		else {
			Node temp;

			mirror(node.left);
			mirror(node.right);

			temp = node.left;
			node.left = node.right;
			node.right = temp;
		}

	}

}

class GFG5
{
    static FoldableBinaryTree obj = new FoldableBinaryTree();
    
    public static boolean isFoldable(Node root)
    {
        if(root == null)
        	return false;
        
        return isFoldableTree(root.left,root.right);
    }

	private static boolean isFoldableTree(Node n1, Node n2) {
		if(n1 == null && n2 == null)
			return true;
		if(n1 == null || n2 == null)
			return false;
		
		return isFoldableTree(n1.left, n2.right) && isFoldableTree(n1.right, n2.left);
	}
    
    
}
