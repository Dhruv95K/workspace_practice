package Trees;
/*
965. Univalued Binary Tree
A binary tree is univalued if every node in the tree has the same value.

Return true if and only if the given tree is univalued.
Note:
	1. The number of nodes in the given tree will be in the range [1, 100].
	2. Each node's value will be an integer in the range [0, 99].
*/

public class UnivaluedBinaryTree965 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isUnivalTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;

		if ((root.left != null && root.val != root.left.val) || 
				(root.right != null && root.val != root.right.val))
			return false;

		return isUnivalTree(root.left) && isUnivalTree(root.right);
	}

}
