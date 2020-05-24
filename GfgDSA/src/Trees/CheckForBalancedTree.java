package Trees;

import java.util.HashMap;
import java.util.Scanner;

public class CheckForBalancedTree {

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

				// cout << n1 << " " << n2 << " " << (char)lr << endl;
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

			checkBalanced g = new checkBalanced();

			if (g.isBalanced(root) == true)
				System.out.println(1);
			else
				System.out.println(0);
			t--;
		}
	}

}

class checkBalanced
{
    
     /* This function should return tree if passed  tree 
     is balanced, else false. */
    boolean isBalanced(Node root)
    {
    //	return (isBalancedTree(root) == -1) ? false : true;
    	Height h = new Height();
    	return isBalanced(root, h);
    }

	private int isBalancedTree(Node root) {
		if(root == null)
			return 0;
		
		int lh = isBalancedTree(root.left);
		if(lh == -1)
			return -1;
		int rh = isBalancedTree(root.right);
		if(rh == -1)
			return  -1;
		
		if(Math.abs(lh-rh) > 1)
		    return -1;
		
		return Math.max(lh, rh)+1;
	}
	
	//using wrapper height
	private boolean isBalanced(Node root,Height h) {
		if(root == null) {
			h.h = 0;
			return true;
		}
		Height lh = new Height(),rh = new Height();
		
		boolean isLeftBalanced = isBalanced(root.left, lh);
		boolean isRightBalanced = isBalanced(root.right, rh);
		
		int left = lh.h;
		int right = rh.h;
		
		h.h = Math.max(left, right) + 1;
		
		if(Math.abs(lh.h - rh.h) > 1)
			return false;
		
		return isLeftBalanced && isRightBalanced;
	}
	
	static class Height{
		int h = 0;
	}
}
