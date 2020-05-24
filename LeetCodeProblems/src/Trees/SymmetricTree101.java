package Trees;
/*
101. Symmetric Tree
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3
 

Note:
	1. Bonus points if you could solve it both recursively and iteratively.
*/

public class SymmetricTree101 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;
		return isSymmetric(root.left, root.right);
	}

	public boolean isSymmetric(TreeNode a, TreeNode b) {
		if (a == null && b == null)
			return true;
		if ((a == null && b != null) || (a != null & b == null) || (a.val != b.val))
			return false;

		return isSymmetric(a.left, b.right) && isSymmetric(a.right, b.left);
	}

}
