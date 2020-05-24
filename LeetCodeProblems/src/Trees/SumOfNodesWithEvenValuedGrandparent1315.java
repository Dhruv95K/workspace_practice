package Trees;
/*
1315. Sum of Nodes with Even-Valued Grandparent
Given a binary tree, return the sum of values of nodes with even-valued grandparent.
(A grandparent of a node is the parent of its parent, if it exists.)

If there are no nodes with an even-valued grandparent, return 0.
Example 1:
	Input: root = [6,7,8,2,7,1,3,9,null,1,4,null,null,null,5]
	Output: 18
	Explanation: The red nodes are the nodes with even-value grandparent while the blue nodes are the even-value grandparents.
	 

Constraints:

	1. The number of nodes in the tree is between 1 and 10^4.
	2. The value of nodes is between 1 and 100.
*/

import java.util.HashMap;
import java.util.Map;

public class SumOfNodesWithEvenValuedGrandparent1315 {

	public static void main(String[] args) {

	}

	int sum;
	public int sumEvenGrandparent(TreeNode root) {
		Map<TreeNode, TreeNode> par = new HashMap<>();

	//	dfs(root, null, par);
		
		dfs(root,null,null);

		sum = 0;
		/*for (TreeNode key : parent.keySet()) {
			if (par.get(key) != null)
				if (par.get(par.get(key)) != null)
					if (par.get(par.get(key)).val % 2 == 0)
						sum += key.val;
		}*/
		
		
		return sum;

	}

	private void dfs(TreeNode root, TreeNode parent, TreeNode grandParent) {
		 if(root == null)
			 return;
		 
		if(grandParent != null && grandParent.val % 2 == 0)
			sum += root.val;
		
		dfs(root.left,root,parent);
		dfs(root.right,root,parent);
	}

	private void dfsUsingMap(TreeNode root, TreeNode par, Map<TreeNode, TreeNode> parent) {
		if (root == null)
			return;

		parent.put(root, par);
		dfsUsingMap(root.left, root, parent);
		dfsUsingMap(root.right, root, parent);

	}

}
