package Trees;

import java.util.ArrayList;
import java.util.List;

/*
113. Path Sum II
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals 
the given sum.

Note: A leaf is a node with no children.
Example:
	Given the below binary tree and sum = 22,
	
	      5
	     / \
	    4   8
	   /   / \
	  11  13  4
	 /  \    / \
	7    2  5   1
	Return:
	
	[
	   [5,4,11,2],
	   [5,8,4,5]
	]
*/

public class PathSumII113 {
	List<List<Integer>> result;
	
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		pathSum(root, sum, temp);

		return result;
	}

	private void pathSum(TreeNode root, int sum, List<Integer> temp) {
		if (root == null || sum < 0)
			return;

		if (root.left == null && root.right == null) {
			if (sum == root.val) {
				temp.add(root.val);
				result.add(new ArrayList<>(temp));
				temp.remove(temp.size() - 1);
			}
			return;
		}

		temp.add(root.val);
		pathSum(root.left, sum - root.val, temp);
		pathSum(root.right, sum - root.val, temp);
		temp.remove(temp.size() - 1);

	}
}
