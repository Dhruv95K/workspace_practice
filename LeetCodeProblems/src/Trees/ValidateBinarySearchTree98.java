package Trees;

/*98. Validate Binary Search Tree
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

	The left subtree of a node contains only nodes with keys less than the node's key.
	The right subtree of a node contains only nodes with keys greater than the node's key.
	Both the left and right subtrees must also be binary search trees.

Example 1:
    2
   / \
  1   3

Input: [2,1,3]
Output: true

Example 2:

    5
   / \
  1   4
     / \
    3   6

    Input: [5,1,4,null,null,3,6]
	Output: false
	Explanation: The root node's value is 5 but its right child's value is 4.
*/
public class ValidateBinarySearchTree98 {

	public boolean isValidBST(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return true;

		return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
	}

	private boolean isValidBST(TreeNode root, long minValue, long maxValue) {
		if (root == null)
			return true;

		if (root.val <= minValue || root.val >= maxValue)
			return false;

		return isValidBST(root.left, minValue, root.val) && isValidBST(root.right, root.val, maxValue);
	}

}
