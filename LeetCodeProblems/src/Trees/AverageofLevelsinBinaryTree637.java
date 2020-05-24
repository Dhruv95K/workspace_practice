package Trees;
/*
637. Average of Levels in Binary Tree
Given a non-empty binary tree, return the average value of the nodes on each level in the form 
of an array.
Example 1:
	Input:
	    3
	   / \
	  9  20
	    /  \
	   15   7
	Output: [3, 14.5, 11]
	Explanation:
	The average value of nodes on level 0 is 3,  on level 1 is 14.5, and on level 2 is 11. Hence return [3, 14.5, 11].

Note:
	1. The range of node's value is in the range of 32-bit signed integer.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree637 {

	public static void main(String[] args) {
		

	}
	
	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> ans = new ArrayList<Double>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		
		while(!q.isEmpty()) {
			double n = q.size();
			double sum = 0;
			
			for(int i = 0;i<n;i++) {
				TreeNode t = q.poll();
				sum += t.val;
				
				if(t.left != null)
					q.offer(t.left);
				
				if(t.right!=null)
					q.offer(t.right);
				
			}
			
			if(n != 0)
				ans.add(sum/n);
			
		}
		
		return ans;
    }

}
