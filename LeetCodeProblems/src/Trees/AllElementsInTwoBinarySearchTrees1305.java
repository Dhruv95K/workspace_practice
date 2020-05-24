package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
1305. All Elements in Two Binary Search Trees
Given two binary search trees root1 and root2.

Return a list containing all the integers from both trees sorted in ascending order.

Example 1:
	Input: root1 = [2,1,4], root2 = [1,0,3]
	Output: [0,1,1,2,3,4]
			
Example 2:
	Input: root1 = [0,-10,10], root2 = [5,1,7,0,2]
	Output: [-10,0,0,1,2,5,7,10]
			
Example 3:
	Input: root1 = [], root2 = [5,1,7,0,2]
	Output: [0,1,2,5,7]
			
Example 4:
	Input: root1 = [0,-10,10], root2 = []
	Output: [-10,0,10]
			
Example 5:
	Input: root1 = [1,null,8], root2 = [8,1]
	Output: [1,1,8,8]
 
Constraints:
	1. Each tree has at most 5000 nodes.
	2. Each node's value is between [-10^5, 10^5].
*/

public class AllElementsInTwoBinarySearchTrees1305 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
		List<Integer> ans = new ArrayList<Integer>();

		Stack<TreeNode> st1 = new Stack<>();
		Stack<TreeNode> st2 = new Stack<>();

		TreeNode cur1 = root1;
		TreeNode cur2 = root2;

		while (cur1 != null || !st1.isEmpty() || cur2 != null || !st2.isEmpty()) {
			while (cur1 != null) {
				st1.push(cur1);
				cur1 = cur1.left;
			}

			while (cur2 != null) {
				st2.push(cur2);
				cur2 = cur2.left;
			}

			if (st2.isEmpty() || (!st1.isEmpty() && st1.peek().val <= st2.peek().val)) {
				cur1 = st1.pop();
				ans.add(cur1.val);
				cur1 = cur1.right;
			} else {
				cur2 = st2.pop();
				ans.add(cur2.val);
				cur2 = cur2.right;
			}
		}

		return ans;
	}

}
