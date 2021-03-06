package Trees;

import java.util.ArrayList;
import java.util.List;

/*
897. Increasing Order Search Tree
Given a binary search tree, rearrange the tree in in-order so that the leftmost node 
in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
	Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
	
	       5
	      / \
	    3    6
	   / \    \
	  2   4    8
	 /        / \ 
	1        7   9
	
	Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
	
	 1
	  \
	   2
	    \
	     3
	      \
	       4
	        \
	         5
	          \
	           6
	            \
	             7
	              \
	               8
	                \
	                 9
                 
Note:
	1. The number of nodes in the given tree will be between 1 and 100.
	2. Each node will have a unique integer value from 0 to 1000.
*/
public class IncreasingOrderSearchTree897 {

	public static void main(String[] args) {

	}
	
	TreeNode cur;
	
	public TreeNode increasingBST(TreeNode root) {
	//	List<Integer> list = new ArrayList<>();

		TreeNode ans = new TreeNode(0);
		cur = ans;
		inorder(root);
		
		/*for(int x : list) {
			cur.right = new TreeNode(x);
			cur = cur.right;
		}*/
		
		return ans.right;
	}

	private void inorder(TreeNode node) {
		if(node == null)
			return;
		
		inorder(node.left);
		//list.add(root.val);
		node.left = null;
		cur.right = node;
		cur = node;
		inorder(node.right);
	}

}
