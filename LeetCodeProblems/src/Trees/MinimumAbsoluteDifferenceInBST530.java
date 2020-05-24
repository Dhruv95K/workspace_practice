package Trees;

/*
530. Minimum Absolute Difference in BST
Given a binary search tree with non-negative values, find the minimum absolute difference between 
values of any two nodes.

Example:
	
	Input:
	
	   1
	    \
	     3
	    /
	   2
	
	Output:
	1

Explanation:
The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
*/
import java.util.Stack;

public class MinimumAbsoluteDifferenceInBST530 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int min = Integer.MAX_VALUE;
	TreeNode prev;

	public int getMinimumDifference(TreeNode root) {
		if (root == null)
			return 0;

		getMinimumDifference(root.left);
		if (prev != null)
			min = Math.min(min, Math.abs(root.val - prev.val));

		prev = root;

		getMinimumDifference(root.right);

		return min;
	}

	public int getMinimumDifferenceIterative(TreeNode root) {
		if (root == null)
			return 0;

		Stack<TreeNode> st = new Stack<>();
		TreeNode cur = root;
		TreeNode prev = null;
		int min = Integer.MAX_VALUE;
		
		while (!st.isEmpty() || cur != null) {
			while (cur != null) {
				st.push(cur);
				cur = cur.left;
			}
			cur = st.pop();
			if(prev != null)
				min = Math.min(min, Math.abs(cur.val - prev.val));
			
			prev  = cur;
			cur = cur.right;

		}
		
		return min;
	}
}
