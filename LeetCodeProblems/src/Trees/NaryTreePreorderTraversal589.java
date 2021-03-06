package Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
589. N-ary Tree Preorder Traversal

Given an n-ary tree, return the preorder traversal of its nodes' values.

Nary-Tree input serialization is represented in their level order traversal, each group of 
children is separated by the null value (See examples).

Follow up:

Recursive solution is trivial, could you do it iteratively?

Example 1:
Input: root = [1,null,3,2,4,null,5,6]
Output: [1,3,5,6,2,4]
		
Example 2:
Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 
Constraints:
	1. The height of the n-ary tree is less than or equal to 1000
	2. The total number of nodes is between [0, 10^4]
*/

class NaryNode {
	public int val;
	public List<NaryNode> children;

	public NaryNode() {
	}

	public NaryNode(int _val) {
		val = _val;
	}

	public NaryNode(int _val, List<NaryNode> _children) {
		val = _val;
		children = _children;
	}
}

public class NaryTreePreorderTraversal589 {

	public List<Integer> preorder(NaryNode root) {
		List<Integer> list = new ArrayList<>();

		Stack<NaryNode> st = new Stack<>();
		st.push(root);

		while (!st.isEmpty()) {
			NaryNode t = st.pop();
			if(t == null)
                continue;
			list.add(t.val);
			for (int i = t.children.size() - 1; i >= 0; i--)
				st.push(t.children.get(i));
		}

		return list;
	}

	public List<Integer> preorderRecursive(NaryNode root) {
		List<Integer> list = new ArrayList<>();

		preorderRecursive(root, list);
		return list;
	}

	private void preorderRecursive(NaryNode root, List<Integer> list) {
		if (root == null)
			return;

		list.add(root.val);
		for (int i = 0; i < root.children.size(); i++)
			preorderRecursive(root.children.get(i), list);

	}
}
