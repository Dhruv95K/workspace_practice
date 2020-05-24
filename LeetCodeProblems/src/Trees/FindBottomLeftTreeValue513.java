package Trees;
/*
513. Find Bottom Left Tree Value
Given a binary tree, find the leftmost value in the last row of the tree.

Example 1:
Input:

    2
   / \
  1   3

Output:
1

Example 2:
	Input:
	
	        1
	       / \
	      2   3
	     /   / \
	    4   5   6
	       /
	      7
	
	Output:
	7

Note: You may assume the tree (i.e., the given root node) is not NULL.
*/

public class FindBottomLeftTreeValue513 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int ans = 0;
	int maxLevel = -1;

	public int findBottomLeftValue(TreeNode root) {
		if (root == null)
			return -1;

		dfs(root, 0);
		
		return ans;
	}

	private void dfs(TreeNode root, int level) {
		if (root == null)
			return;

		if (maxLevel < level) {
			maxLevel = level;
			ans = root.val;
		}

		dfs(root.left, level + 1);
		dfs(root.right, level + 1);

	}
}
