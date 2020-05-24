package trees;

import trees.Main.TreeNode;

public class ChildrenSumProperty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public TreeNode solve(TreeNode root) {
		if (root == null)
			return null;
		if (root.left == null && root.right == null)
			return root;

		root.left = solve(root.left);
		root.right = solve(root.right);

		int ldata = 0, rdata = 0;
		if (root.left != null)
			ldata = root.left.val;
		if (root.right != null)
			rdata = root.right.val;
		
		int diff = root.val - (ldata + rdata);
		
		if(diff < 0)
			root.val = ldata + rdata;
		
		if(diff > 0)
			increment(root,diff);

		return root;
	}

	private void increment(TreeNode root, int diff) {
		if(root.left != null) {
			root.left.val += diff;
			increment(root.left,diff);
		}
		
		else if(root.right != null) {
			root.right.val += diff;
			increment(root.right,diff);
		}
	}

}
