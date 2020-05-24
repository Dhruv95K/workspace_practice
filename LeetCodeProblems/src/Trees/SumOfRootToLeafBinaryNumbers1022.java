package Trees;
/*
1022. Sum of Root To Leaf Binary Numbers
Given a binary tree, each node has value 0 or 1.  Each root-to-leaf path represents a binary number 
starting with the most significant bit.  For example, if the path is 0 -> 1 -> 1 -> 0 -> 1, then 
this could represent 01101 in binary, which is 13.

For all leaves in the tree, consider the numbers represented by the path from the root to that leaf.

Return the sum of these numbers.

Example 1:
	Input: [1,0,1,0,1,0,1]
	Output: 22
	Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
	 
Note:
	1. The number of nodes in the tree is between 1 and 1000.
	2. node.val is 0 or 1.
	3. The answer will not exceed 2^31 - 1.

*/

public class SumOfRootToLeafBinaryNumbers1022 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int sumRootToLeaf(TreeNode root) {
		
		return sumRootToLeaf(root,0);
	}

	private int sumRootToLeaf(TreeNode root, int prevSum) {
		if(root == null)
			return 0;
		
		prevSum = prevSum*2 + root.val;
		if(root.left == null && root.right == null)
			return prevSum;
		
		return sumRootToLeaf(root.left, prevSum) + sumRootToLeaf(root.right, prevSum);
	}

}
