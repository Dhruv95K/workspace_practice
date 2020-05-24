package Trees;
/*
1302. Deepest Leaves Sum
Given a binary tree, return the sum of values of its deepest leaves.
		 
Example 1:
	Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
	Output: 15
 
Constraints:
	1. The number of nodes in the tree is between 1 and 10^4.
	2. The value of nodes is between 1 and 100.
*/

import java.util.LinkedList;
import java.util.Queue;

public class DeepestLeavesSum1302 {

	public static void main(String[] args) {

	}

	public int deepestLeavesSum(TreeNode root) {
		int h = height(root);
		if(h == 0)
			return 0;
		
		return dfs(root,h);
	}
	
	
	private int dfs(TreeNode root, int level) {
		if(root == null)
			return 0;
		
		if(level == 1)
			return root.val;
		
		return dfs(root.left,level-1) + dfs(root.right, level-1);
	}

	private int height(TreeNode root) {
		if(root == null)
			return 0;
		
		return 1 + Math.max(height(root.left), height(root.right));
	}

	public int deepestLeavesSumIterative(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(root);
		int sum;

		while (!q.isEmpty()) {
			int n = q.size();
			sum = 0;
			for (int i = 0; i < n; i++) {
				TreeNode t = q.poll();
				sum += t.val;
				if(t.left != null)
					q.offer(t.left);
				if(t.right != null)
					q.offer(t.right);
			}
			
			if(q.isEmpty())
				return sum;
		}

		return -1;
	}

}
