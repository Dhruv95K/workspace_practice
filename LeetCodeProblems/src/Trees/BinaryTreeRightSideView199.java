package Trees;

import java.util.ArrayList;
import java.util.List;

/*
199. Binary Tree Right Side View
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example:

	Input: [1,2,3,null,5,null,4]
	Output: [1, 3, 4]
	Explanation:
	
	   1            <---
	 /   \
	2     3         <---
	 \     \
	  5     4       <---
*/

public class BinaryTreeRightSideView199 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int maxLevel;

	public List<Integer> rightSideView(TreeNode root) {
		maxLevel = -1;
		List<Integer> list = new ArrayList<>();
		dfs(root, 0, list);
		
		return list;
	}

	private void dfs(TreeNode root, int level, List<Integer> list) {
		if(root == null)
			return ;
		
		if(level > maxLevel) {
			maxLevel = level;
			list.add(root.val);
		}
		
		dfs(root.right, level+1, list);
		dfs(root.left, level+1, list);
		
	}

}
