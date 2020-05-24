package Trees;
/*
437. Path Sum III

You are given a binary tree in which each node contains an integer value.
Find the number of paths that sum to a given value.
The path does not need to start or end at the root or a leaf, but it must go downwards 
(traveling only from parent nodes to child nodes).

The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
*/

import java.util.HashMap;
import java.util.Map;

public class PathSumIII437 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int pathSum(TreeNode root, int sum) {
		Map<Integer,Integer> prefixSum = new HashMap<>();
		prefixSum.put(0, 1);
		
		return pathSum(root,sum,0,prefixSum);
	}

	private int pathSum(TreeNode root, int sum, int curSum, Map<Integer, Integer> prefixSum) {
		int count = 0;
		if(root == null)
			return 0;
		
		curSum += root.val;
		if(prefixSum.containsKey(curSum - sum))
			count += prefixSum.get(curSum - sum);
		
		prefixSum.put(curSum,prefixSum.getOrDefault(curSum, 0) + 1);
		
		count += pathSum(root.left, sum, curSum, prefixSum) + pathSum(root.right, sum, curSum, prefixSum);
		prefixSum.put(curSum, prefixSum.get(curSum) - 1);
		
		return count;
	}

}
