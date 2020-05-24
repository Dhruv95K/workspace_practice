package Trees;

/*226. Invert Binary Tree
Invert a binary tree.

Example:

Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
Trivia:
This problem was inspired by this original tweet by Max Howell:

Google: 90% of our engineers use the software you wrote (Homebrew), but you can¡¯t invert a binary
tree on a whiteboard so f*** off.
*/

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class InvertBinaryTree226 {

	public static void main(String[] args) {

	}

	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;
		
		root.left = invertTree(root.left);
		root.right = invertTree(root.right);
		
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		
		return root;
	}

}
