package Trees;

import java.util.Stack;

/*
230. Kth Smallest Element in a BST
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ¡Ü k ¡Ü BST's total elements.

Example 1:
	Input: root = [3,1,4,null,2], k = 1
	   3
	  / \
	 1   4
	  \
	   2
	Output: 1

Example 2:
	Input: root = [5,3,6,2,4,null,null,1], k = 3
	       5
	      / \
	     3   6
	    / \
	   2   4
	  /
	 1
	Output: 3

Follow up:
	1. What if the BST is modified (insert/delete operations) often and you need to find the kth 
smallest frequently? How would you optimize the kthSmallest routine?
*/

public class KthSmallestElementInABST230 {
		
	public int kthSmallest(TreeNode root, int k) {
		Stack<TreeNode> st = new Stack<>();
		TreeNode cur = root;
		
		while(!st.isEmpty() || cur != null) {
			while(cur != null) {
				st.push(cur);
				cur = cur.left;
			}
			
			cur = st.pop();
			k--;
			if(k == 0)
				return cur.val;
			
			cur = cur.right;
		}
		
		return -1;
	}
	
	int ans,cur;
	public int kthSmallestRecursive(TreeNode root, int k) {
		ans = -1;
		cur = 0;
		inorder(root,k);
		
		return ans;
	}
	private void inorder(TreeNode root, int k) {
		if(root == null)
			return;
		
		inorder(root.left,k);
		cur++;
		if(cur == k)
			ans = root.val;
		if(ans == -1)
			inorder(root.right,k);
		
	}

}
