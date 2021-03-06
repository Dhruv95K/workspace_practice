package Trees;
/*
543. Diameter of Binary Tree
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of 
a binary tree is the length of the longest path between any two nodes in a tree. This path 
may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.
*/

public class DiameterOfBinaryTree543 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int ans;

	public int diameterOfBinaryTree(TreeNode root) {
		int ans = 1;

		height(root);
		return ans - 1;
	}

	private int height(TreeNode root) {
		if (root == null)
			return 0;

		int l = height(root.left);
		int r = height(root.right);

		ans = Math.max(ans, l + r + 1);

		return 1 + Math.max(l, r);

	}

}
