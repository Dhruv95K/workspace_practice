package Trees;
/*
563. Binary Tree Tilt
Given a binary tree, return the tilt of the whole tree.

The tilt of a tree node is defined as the absolute difference between the sum of all left subtree node values and the sum of all right subtree node values. Null node has tilt 0.

The tilt of the whole tree is defined as the sum of all nodes' tilt.

Example:
	Input: 
	         1
	       /   \
	      2     3
	Output: 1
	Explanation: 
	Tilt of node 2 : 0
	Tilt of node 3 : 0
	Tilt of node 1 : |2-3| = 1
	Tilt of binary tree : 0 + 0 + 1 = 1
	
Note:
	1. The sum of node values in any subtree won't exceed the range of 32-bit integer.
	2. All the tilt values won't exceed the range of 32-bit integer.
*/

public class BinaryTreeTilt563 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	int tilt;
    public int findTilt(TreeNode root) {
    	if(root == null)
    		return 0;
    	
	    tilt = 0;
	    sum(root);
	    return tilt;
	}
	

	private int sum(TreeNode root) {
		if(root == null)
			return 0;
		
		int lsum = sum(root.left);
		int rsum = sum(root.right);
		
		tilt += Math.abs(lsum - rsum);
		
		return root.val + lsum + rsum;
	}


	public int findTiltRecursive(TreeNode root) {
		if(root == null)
			return 0;
		
		int lsum = sumTree(root.left);
		int rsum = sumTree(root.right);
		
		return Math.abs(lsum - rsum) + findTiltRecursive(root.left) + findTiltRecursive(root.right);
	}

	private int sumTree(TreeNode root) {
		if(root == null)
			return 0;
		
		return root.val + sumTree(root.left) + sumTree(root.right);
	}
}
