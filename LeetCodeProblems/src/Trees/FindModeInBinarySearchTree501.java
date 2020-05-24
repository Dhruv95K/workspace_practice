package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
501. Find Mode in Binary Search Tree
Given a binary search tree (BST) with duplicates, find all the mode(s) (the most frequently
occurred element) in the given BST.

Assume a BST is defined as follows:

	The left subtree of a node contains only nodes with keys less than or equal to the node's key.
	The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
	Both the left and right subtrees must also be binary search trees.

For example:
	Given BST [1,null,2,2],

	   1
	    \
	     2
	    /
	   2
	 

	return [2].

	Note: If a tree has more than one mode, you can return them in any order.

	Follow up: Could you do that without using any extra space? 
			(Assume that the implicit stack space incurred due to recursion does not count).	
*/

public class FindModeInBinarySearchTree501 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int max;
	public int[] findMode(TreeNode root) {
		Map<Integer, Integer> freq = new HashMap<>();
		max =Integer.MIN_VALUE;
		inOrder(root, freq);
		
		int[] res;
		ArrayList<Integer> temp = new ArrayList<>();
		for(int key : freq.keySet())
			if(freq.get(key) == max)
				temp.add(key);
		
		res = new int[temp.size()];
		int ind = 0;
		for(int i : temp)
			res[ind++] = i;
		
		return res;
	}

	private void inOrder(TreeNode root, Map<Integer, Integer> freq) {
		if(root == null)
			return;
		
		inOrder(root.left,freq);
		freq.put(root.val, freq.getOrDefault(root.val, 0) + 1);
		max = Math.max(max, freq.get(root.val));
		
		inOrder(root.right,freq);
	}
}
