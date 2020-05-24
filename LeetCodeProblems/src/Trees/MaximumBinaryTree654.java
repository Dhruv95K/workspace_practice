package Trees;

import java.util.Stack;

/*
654. Maximum Binary Tree
Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum 
number. Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
	Input: [3,2,1,6,0,5]
	Output: return the tree root node representing the following tree:
	
	      6
	    /   \
	   3     5
	    \    / 
	     2  0   
	      \
	       1
	        
Note:
	1. The size of the given array will be in the range [1,1000].
*/

public class MaximumBinaryTree654 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode constructMaximumBinaryTree(int[] nums) {
		return constructMaximumBinaryTree(nums, 0, nums.length - 1);
	}
	
	private TreeNode constructMaximumBinaryTreeIterative(int[] nums) {
		Stack<TreeNode> st = new Stack<>();
		
		for(int num : nums) {
			TreeNode cur = new TreeNode(num);
			while(!st.isEmpty() && st.peek().val < cur.val) {
				cur.left = st.pop();
			}
			
			if(!st.isEmpty())
				st.peek().right = cur;
			
			st.push(cur);
		}
		
		while(st.size() > 1)
			st.pop();
		
		return st.peek();
	}

	private TreeNode constructMaximumBinaryTree(int[] nums, int start, int end) {
		if (start > end)
			return null;

		if (start == end)
			return new TreeNode(nums[start]);

		int max = findMax(nums, start, end);
		TreeNode root = new TreeNode(nums[max]);

		root.left = constructMaximumBinaryTree(nums, start, max - 1);
		root.right = constructMaximumBinaryTree(nums, max + 1, end);

		return root;
	}

	private int findMax(int[] nums, int start, int end) {
		int maxIndex = -1;
		int max = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++) {
			if(nums[i] > max) {
				max = nums[i];			
				maxIndex = i;
			}
		}
		
		return maxIndex;
	}

}
