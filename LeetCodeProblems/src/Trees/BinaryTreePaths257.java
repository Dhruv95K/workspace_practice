package Trees;
/*
257. Binary Tree Paths
Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

	Input:
	
	   1
	 /   \
	2     3
	 \
	  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
*/

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> temp = new ArrayList<>();

		binaryTreePaths(root, "", temp);

		return temp;
	}

	private void binaryTreePaths(TreeNode root, String cur, List<String> temp) {
		if (root == null)
			return;
		if (root.left == null && root.right == null) {
			temp.add(cur + root.val);
			return;
		}

		if (root.left != null) {
			binaryTreePaths(root.left, cur + root.val + "->", temp);
		}

		if (root.right != null) {
			binaryTreePaths(root.right, cur + root.val + "->", temp);
		}
	}

}
