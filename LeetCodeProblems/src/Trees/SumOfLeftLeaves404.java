package Trees;

import java.util.Stack;

/*
404. Sum of Left Leaves
Find the sum of all left leaves in a given binary tree.
Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
*/
public class SumOfLeftLeaves404 {

	public static void main(String[] args) {

	}

	public int sumOfLeftLeaves(TreeNode root) {
		int sum = 0;
		if (root == null)
			return 0;

		if (root.left != null) {
			if (root.left.left == null && root.left.right == null) {
				sum += root.left.val;
				return sum;
			}
			else
				sum += sumOfLeftLeaves(root.left);
		}

		sum += sumOfLeftLeaves(root.right);

		return sum;
	}
	
	public int sumOfLeftLeavesIterative(TreeNode root) {
		int sum = 0;
		Stack<TreeNode> st = new Stack<>();
		st.push(root);
		
		while(!st.isEmpty()) {
			TreeNode t = st.pop();
			if(t.left!=null) {
				if (t.left.left == null && t.left.right == null) 
					sum += t.left.val;
				else
					st.push(t.left);
			}
			
			if(t.right != null)
				if(t.right.left != null || t.right.right != null)
					st.push(t.right);
		}
		
		return sum;
	}

}
