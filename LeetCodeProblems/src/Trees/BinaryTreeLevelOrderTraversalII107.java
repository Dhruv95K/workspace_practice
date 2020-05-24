package Trees;
/*
107. Binary Tree Level Order Traversal II
Given a binary tree, return the bottom-up level order traversal of its nodes' 
values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
	[
	  [15,7],
	  [9,20],
	  [3]
	]
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversalII107 {

	public static void main(String[] args) {

	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> ans = new ArrayList<>();
		if(root == null)
            return ans;
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		List<Integer> temp = new ArrayList<>();
		
		while(!q.isEmpty()) {
			int n = q.size();	
			for(int i = 0;i<n;i++) {
				TreeNode t = q.poll();
				temp.add(t.val);
				if(t.left != null)
					q.offer(t.left);
				if(t.right != null)
					q.offer(t.right);
			}
			
			ans.add(new ArrayList<>(temp));
			temp.clear();
		}
			
		
		Collections.reverse(ans);
		return ans;
	}

}
