package Trees;
/*
958. Check Completeness of a Binary Tree
Given a binary tree, determine if it is a complete binary tree.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and 
all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes 
inclusive at the last level h.

Example 1:
	Input: [1,2,3,4,5,6]
	Output: true
	Explanation: Every level before the last is full (ie. levels with node-values {1} and {2, 3}), and all nodes in the last level ({4, 5, 6}) are as far left as possible.

Example 2:
	Input: [1,2,3,4,5,null,7]
	Output: false
	Explanation: The node with value 7 isn't as far left as possible.
 
Note:
	1. The tree will have between 1 and 100 nodes.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CheckCompletenessOfABinaryTree958 {

	public boolean isCompleteTree(TreeNode root) {
		if(root == null)
			return true;
		List<Anode> list = new ArrayList<>();
		Queue<Anode> q = new LinkedList<>();
		q.offer(new Anode(root, 1));

		while (!q.isEmpty()) {
			int n = q.size();

			for (int i = 0; i < n; i++) {
				Anode t = q.poll();
				list.add(t);

				if (t.node.left != null)
					q.offer(new Anode(t.node.left, 2 * t.pos));

				if (t.node.right != null)
					q.offer(new Anode(t.node.right, 2 * t.pos + 1));

			}

		}
		
		if(list.get(list.size() - 1).pos == list.size()) 
			return true;
		
		return false;
			
	}

}

class Anode {
	TreeNode node;
	int pos;

	public Anode(TreeNode node, int pos) {
		this.node = node;
		this.pos = pos;
	}

}
