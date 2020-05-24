package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
429. N-ary Tree Level Order Traversal
Given an n-ary tree, return the level order traversal of its nodes' values.
Nary-Tree input serialization is represented in their level order traversal, each group of 
children is separated by the null value (See examples).

Example 1:
	Input: root = [1,null,3,2,4,null,5,6]
	Output: [[1],[3,2,4],[5,6]]
			
Example 2:
	Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
	Output: [[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
 
Constraints:
	1. The height of the n-ary tree is less than or equal to 1000
	2. The total number of nodes is between [0, 10^4]
*/

public class NaryTreeLevelOrderTraversal429 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<List<Integer>> levelOrder(NaryNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if(root == null)
            return res;
		
		Queue<NaryNode> q = new LinkedList<>();
		q.offer(root);
		List<Integer> temp ;

		while (!q.isEmpty()) {
			int n = q.size();
			temp = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				NaryNode t = q.poll();
				temp.add(t.val);
				
				for(int j = 0 ; j < t.children.size();j++) {
					q.offer(t.children.get(j));
				}
			}
			
			res.add(temp);
		}

		return res;
	}

}
