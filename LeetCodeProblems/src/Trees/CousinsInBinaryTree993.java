package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
993. Cousins in Binary Tree
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different 
nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.

Example 1:
	Input: root = [1,2,3,4], x = 4, y = 3
	Output: false

Example 2:
	Input: root = [1,2,3,null,4,null,5], x = 5, y = 4
	Output: true

Example 3:
	Input: root = [1,2,3,null,4], x = 2, y = 3
	Output: false
 

Note:
	1. The number of nodes in the tree will be between 2 and 100.
	2. Each node has a unique integer value from 1 to 100.
*/
public class CousinsInBinaryTree993 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Map<Integer, Integer> depth;
	Map<Integer, TreeNode> parent;

	public boolean isCousins(TreeNode root, int x, int y) {
		depth = new HashMap<>();
		parent = new HashMap<>();

		dfs(root, null);

		return depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y);
	}

	private void dfs(TreeNode cur, TreeNode par) {
		if (cur == null)
			return;

		depth.put(cur.val, (par == null) ? 0 : (depth.get(par.val) + 1));
		parent.put(cur.val, par);
		
		dfs(cur.left,cur);
		dfs(cur.right,cur);
		
	}
	
	//does not work
	public boolean isCousinsIterative(TreeNode root, int x, int y) {
		depth = new HashMap<>();
		parent = new HashMap<>();

		Queue<TreeNode> q = new LinkedList<>();
		TreeNode cur = root;
		q.offer(cur);

		depth.put(cur.val, 0);
		parent.put(cur.val, null);
		
		while(!q.isEmpty()) {
			TreeNode t = q.poll();
			if(t.left!=null) {
				depth.put(t.left.val, depth.get(t.val) + 1);
				parent.put(t.left.val, t);
			}
			if(t.right!=null) {
				depth.put(t.right.val, depth.get(t.val) + 1);
				parent.put(t.right.val, t);
			}
		}
		
		return depth.get(x) == depth.get(y) && parent.get(x) != parent.get(y);
	}

}
