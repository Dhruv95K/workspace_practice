package Trees;
/*
662. Maximum Width of Binary Tree
Given a binary tree, write a function to get the maximum width of the given tree. 
The width of a tree is the maximum width among all levels. The binary tree has the same structure 
as a full binary tree, but some nodes are null.

The width of one level is defined as the length between the end-nodes (the leftmost and right 
most non-null nodes in the level, where the null nodes between the end-nodes are also counted 
into the length calculation.

Example 1:
	Input: 
	
	           1
	         /   \
	        3     2
	       / \     \  
	      5   3     9 
	
	Output: 4
	Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
	
Example 2:
	Input: 
	
	          1
	         /  
	        3    
	       / \       
	      5   3     
	
	Output: 2
	Explanation: The maximum width existing in the third level with the length 2 (5,3).
	
Example 3:
	Input: 
	
	          1
	         / \
	        3   2 
	       /        
	      5      
	
	Output: 2
	Explanation: The maximum width existing in the second level with the length 2 (3,2).
	
Example 4:
	Input: 
	
	          1
	         / \
	        3   2
	       /     \  
	      5       9 
	     /         \
	    6           7
	Output: 8
	Explanation:The maximum width existing in the fourth level with the length 8 
	(6,null,null,null,null,null,null,7).

Note: Answer will in the range of 32-bit signed integer.
*/

public class MaximumWidthOfBinaryTree662 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int widthOfBinaryTree(TreeNode root) {
		Values2 val = new Values2();
		widthOfBinaryTree(root, 0, val);
		
		return Math.abs(val.max - val.min);
	}

	private void widthOfBinaryTree(TreeNode root, int hd, Values2 val) {
		if (root == null)
			return;

		val.max = Math.max(val.max, hd);
		val.min = Math.min(val.min, hd);

		widthOfBinaryTree(root.left, hd - 1, val);
		widthOfBinaryTree(root.right, hd + 1, val);
	}

}

class Values {
	int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
}