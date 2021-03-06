package Trees;
/*
1110. Delete Nodes And Return Forest
Given the root of a binary tree, each node in the tree has a distinct value.

After deleting all nodes with a value in to_delete, we are left with a forest 
(a disjoint union of trees).

Return the roots of the trees in the remaining forest.  You may return the result in any order.
Example 1:
	Input: root = [1,2,3,4,5,6,7], to_delete = [3,5]
	Output: [[1,2,null,4],[6],[7]]
			 

Constraints:
	The number of nodes in the given tree is at most 1000.
	Each node has a distinct value between 1 and 1000.
	to_delete.length <= 1000
	to_delete contains distinct values between 1 and 1000.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DeleteNodesAndReturnForest1110 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<TreeNode> res;
	Set<Integer> set;
	public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
		res = new ArrayList<>();
		set = new HashSet<>();
		for (int i : to_delete)
			set.add(i);
		if(!set.contains(root.val))
			res.add(root);
		dfs(root);
		return res;
	}

	private TreeNode dfs(TreeNode root) {
		if (root == null)
			return null;

		root.left = dfs(root.left);
		root.right = dfs(root.right);

		if (set.contains(root.val)) {
			if (root.left != null)
				res.add(root.left);
			if (root.right != null)
				res.add(root.right);
			
			return null;
		}
		
		return root;
	}

}
