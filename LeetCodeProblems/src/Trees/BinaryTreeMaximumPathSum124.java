package Trees;
/*
124. Binary Tree Maximum Path Sum
Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting 
node to any node in the tree along the parent-child connections. The path must contain at 
least one node and does not need to go through the root.

Example 1:
	Input: [1,2,3]
	
	       1
	      / \
	     2   3

	Output: 6
	
Example 2:
	Input: [-10,9,20,null,null,15,7]
	
	   -10
	   / \
	  9  20
	    /  \
	   15   7
	
	Output: 42
*/

public class BinaryTreeMaximumPathSum124 {
	
	int ans = Integer.MIN_VALUE;
	public int maxPathSum(TreeNode root) {
		
		sum(root);
		return ans;
	}
	
	private int sum(TreeNode root) {
		if(root == null)
			return 0;
		
		int lsum = sum(root.left);
		int rsum = sum(root.right);
		
		int sum = root.val + Math.max(lsum, 0) + Math.max(rsum, 0);
		ans = Math.max(ans, sum);
		sum = root.val + Math.max(0, Math.max(rsum, lsum));
		
		return sum;
	}

}
