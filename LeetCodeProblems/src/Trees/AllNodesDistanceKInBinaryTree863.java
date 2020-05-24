package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
863. All Nodes Distance K in Binary Tree
We are given a binary tree (with root node root), a target node, and an integer value K.

Return a list of the values of all nodes that have a distance K from the target node.  
The answer can be returned in any order.


Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]

Explanation: 
The nodes that are a distance 2 from the target node (with value 5)
have values 7, 4, and 1.

Note that the inputs "root" and "target" are actually TreeNodes.
The descriptions of the inputs above are just serializations of these objects.

Note:

	1. The given tree is non-empty.
	2. Each node in the tree has unique values 0 <= node.val <= 500.
	3. The target node is a node in the tree.
	4. 0 <= K <= 1000.
*/
public class AllNodesDistanceKInBinaryTree863 {
	Map<TreeNode, TreeNode> parent;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		parent = new HashMap();
		dfs(root, null);

		Queue<TreeNode> queue = new LinkedList();
		Set<TreeNode> seen = new HashSet();
		queue.add(target);
		seen.add(target);
		List<Integer> ans = new ArrayList<Integer>();

		while (K >= 0 && !queue.isEmpty()) {
			int n = queue.size();

			for (int i = 0; i < n; i++) {
				TreeNode t = queue.poll();
				if (K == 0)
					ans.add(t.val);
				if (t.left != null) {
					if (!seen.contains(t.left)) {
						queue.offer(t.left);
						seen.add(t.left);
					}
				}
				if (t.right != null && !seen.contains(t.right)) {
					if (!seen.contains(t.right)) {
						queue.offer(t.right);
						seen.add(t.right);
					}
				}
				if (parent.get(t) != null) {
					if (!seen.contains(parent.get(t))) {
						queue.offer(parent.get(t));
						seen.add(parent.get(t));
					}
				}
			}
			K--;
		}

		return ans;
	}

	public void dfs(TreeNode node, TreeNode par) {
		if (node != null) {
			parent.put(node, par);
			dfs(node.left, node);
			dfs(node.right, node);
		}
	}
}
