package Trees;
/*
1261. Find Elements in a Contaminated Binary Tree
Given a binary tree with the following rules:
	1. root.val == 0
	2. If treeNode.val == x and treeNode.left != null, then treeNode.left.val == 2 * x + 1
	3. If treeNode.val == x and treeNode.right != null, then treeNode.right.val == 2 * x + 2

Now the binary tree is contaminated, which means all treeNode.val have been changed to -1.

You need to first recover the binary tree and then implement the FindElements class:
	1. FindElements(TreeNode* root) Initializes the object with a contamined binary tree, 
	you need to recover it first.
	2. bool find(int target) Return if the target value exists in the recovered binary tree.
	
Example 1:
	Input
	["FindElements","find","find"]
	[[[-1,null,-1]],[1],[2]]
	Output
	[null,false,true]
	Explanation
	FindElements findElements = new FindElements([-1,null,-1]); 
	findElements.find(1); // return False 
	findElements.find(2); // return True
	 
Example 2:
	Input
	["FindElements","find","find","find"]
	[[[-1,-1,-1,-1,-1]],[1],[3],[5]]
	Output
	[null,true,true,false]
	Explanation
	FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
	findElements.find(1); // return True
	findElements.find(3); // return True
	findElements.find(5); // return False

Example 3:
	Input
	["FindElements","find","find","find","find"]
	[[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
	Output
	[null,true,false,false,true]
	Explanation
	FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
	findElements.find(2); // return True
	findElements.find(3); // return False
	findElements.find(4); // return False
	findElements.find(5); // return True
	 
Constraints:
	1. TreeNode.val == -1
	2. The height of the binary tree is less than or equal to 20
	3. The total number of nodes is between [1, 10^4]
	4. Total calls of find() is between [1, 10^4]
	5. 0 <= target <= 10^6	
*/

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FindElementsInAContaminatedBinaryTree1261 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class FindElements {

	Set<Integer> set;

	public FindElements(TreeNode root) {
		set = new HashSet<>();
		Stack<TreeNode> st = new Stack<>();
		root.val = 0;
		st.push(root);

		while (!st.isEmpty()) {
			TreeNode t = st.pop();
			int x = t.val;
			set.add(x);
			if (t.left != null) {
				t.left.val = 2 * x + 1;
				st.push(t.left);
			}

			if (t.right != null) {
				t.right.val = 2 * x + 2;
				st.push(t.right);
			}
		}
	}

	public boolean find(int target) {
		return set.contains(target);
	}
}
