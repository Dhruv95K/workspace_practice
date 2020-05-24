package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/*
515. Find Largest Value in Each Tree Row
You need to find the largest value in each row of a binary tree.

Example:
Input: 

          1
         / \
        3   2
       / \   \  
      5   3   9 

Output: [1, 3, 9]
*/

public class FindLargestValueInEachTreeRow515 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

		public List<Integer> largestValues(TreeNode root) {
			List<Integer> list = new ArrayList<>();
			Queue<TreeNode> q = new LinkedList<>();
			if(root !=null)
				q.add(root);
			
			while(!q.isEmpty()) {
				int n = q.size();
				int max = Integer.MIN_VALUE;
				
				for(int i = 0 ;i < n; i++) {
					TreeNode t = q.poll();
					max = Math.max(max, t.val);
					
					if(t.left != null)
						q.offer(t.left);
					
					if(t.right != null)
						q.offer(t.right);
				}
				
				list.add(max);
			}
			
			return list;
		}
	
	public List<Integer> largestValuesRecursive(TreeNode root) {
		List<Integer> list = new ArrayList<>();
		Map<Integer, TreeNode> map = new TreeMap<>();

		dfs(root, 0, map);
		
		for(int key : map.keySet()){
			list.add(map.get(key).val);
		}
		return list;
	}

	private void dfs(TreeNode root, int level, Map<Integer, TreeNode> map) {
		if (root == null)
			return;

		if (map.get(level) == null)
			map.put(level, root);
		else {
			if (root.val > map.get(level).val)
				map.put(level, root);
		}

		dfs(root.left, level + 1, map);
		dfs(root.right, level + 1, map);

	}

}
