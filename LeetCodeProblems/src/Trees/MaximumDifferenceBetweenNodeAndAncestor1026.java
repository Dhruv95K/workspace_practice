package Trees;
/*
1026. Maximum Difference Between Node and Ancestor
Given the root of a binary tree, find the maximum value V for which there exists different nodes A 
and B where V = |A.val - B.val| and A is an ancestor of B.

(A node A is an ancestor of B if either: any child of A is equal to B, or any child of A is an 
ancestor of B.)

Example 1:
	Input: [8,3,10,1,6,null,14,null,null,4,7,13]
	Output: 7
	Explanation: 
	We have various ancestor-node differences, some of which are given below :
	|8 - 3| = 5
	|3 - 7| = 4
	|8 - 1| = 7
	|10 - 13| = 3
	Among all possible differences, the maximum value of 7 is obtained by |8 - 1| = 7.
 

Note:
	1. The number of nodes in the tree is between 2 and 5000.
	2. Each node will have value between 0 and 100000.
*/

public class MaximumDifferenceBetweenNodeAndAncestor1026 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int maxAncestorDiff(TreeNode root) {
		return dfs(root,root.val,root.val);
	}
	
	
	private int dfs(TreeNode root, int min, int max) {
		if(root == null)
			return Math.abs(max - min);
		
		max = Math.max(root.val, max);
		min = Math.min(root.val, min);
		
		return Math.max(dfs(root.left,min,max), dfs(root.right,min,max));
	}


	//this is long
	int ans = -1;
	public int maxAncestorDiff2(TreeNode root) {
		MinMax values = new MinMax();
		maxAncestorDiff(root, values);
		return ans;
	}

	private void maxAncestorDiff(TreeNode root, MinMax values) {
		if(root == null) {
		//	values.max = values.min = 0;
			return ;
		}
		
		MinMax left = new MinMax(),right = new MinMax();
		
		maxAncestorDiff(root.left,left);
		maxAncestorDiff(root.right, right);
		
		values.max = Math.max(root.val, Math.max(left.max, right.max));
		values.min = Math.min(root.val, Math.min(left.min, right.min));
		
		int l = 0,r = 0;
		if(root.left != null)
			l = Math.max(Math.abs(root.val - left.max), Math.abs(root.val - left.min));
		if(root.right != null)
			r = Math.max(Math.abs(root.val - right.max), Math.abs(root.val - right.min));
		
		ans = Math.max(ans, Math.max(l,r));

		
	}

}

class MinMax {
	int max = Integer.MIN_VALUE;
	int min = Integer.MAX_VALUE;
}