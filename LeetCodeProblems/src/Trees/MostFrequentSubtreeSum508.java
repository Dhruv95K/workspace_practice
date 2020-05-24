package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
508. Most Frequent Subtree Sum
Given the root of a tree, you are asked to find the most frequent subtree sum. The subtree sum of a node is defined as 
the sum of all the node values formed by the subtree rooted at that node (including the node itself). So what is the most 
frequent subtree sum value? If there is a tie, return all the values with the highest frequency in any order.
	
Examples 1
	Input:
	
	  5
	 /  \
	2   -3
	return [2, -3, 4], since all the values happen only once, return all of them in any order.
			
Examples 2
	Input:
	
	  5
	 /  \
	2   -5
	return [2], since 2 happens twice, however -5 only occur once.
			
Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.		
*/

public class MostFrequentSubtreeSum508 {

	Map<Integer,Integer> map;
	int maxFreq;
	public int[] findFrequentTreeSum(TreeNode root) {
		map = new HashMap<>();
		sum(root);
		
		List<Integer> list = new ArrayList<>();
		for(int key : map.keySet())
			if(map.get(key) == maxFreq)
				list.add(key);
		
		int[] ans = new int[list.size()];
		int ind = 0;
		for(int sum : list)
			ans[ind++] = sum;
		
		return ans;
	}
	
	private int sum(TreeNode root) {
		if(root == null)
			return 0;
		
		int lsum = sum(root.left);
		int rsum = sum(root.right);
		
		int s = lsum + rsum + root.val;
		map.put(s, map.getOrDefault(s, 0) + 1);
		maxFreq = Math.max(maxFreq, map.get(s));
		
		return s;
	}

}
