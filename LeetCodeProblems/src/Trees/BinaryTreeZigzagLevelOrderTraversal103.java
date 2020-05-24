package Trees;
/*
103. Binary Tree Zigzag Level Order Traversal
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
	Given binary tree [3,9,20,null,null,15,7],
	    3
	   / \
	  9  20
	    /  \
	   15   7
	return its zigzag level order traversal as:
	[
	  [3],
	  [20,9],
	  [15,7]
	]
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> result = new ArrayList<>();
		Queue<TreeNode> q = new LinkedList<>();
		ArrayList<Integer> temp;
		q.offer(root);
		boolean reverse = false;
		
		while(!q.isEmpty()) {
			int n = q.size();
			temp = new ArrayList<>();
			
			for(int i = 0;i<n;i++) {
				TreeNode cur = q.poll();
				temp.add(cur.val);
				if(cur.left !=null)
					q.offer(cur.left);
				if(cur.right !=null)
					q.offer(cur.right);
			}
			
			if(reverse)
				Collections.reverse(temp);
			result.add(temp);
			
			reverse = !reverse;
		}
		
		return result;
	}
}
