package Trees;
/*
988. Smallest String Starting From Leaf Given the root of a binary tree,each node has a value 
from 0 to 25 representing the letters'a'to'z':a value of 0 represents'a',a value of 1 
represents'b',and so on.

Find the lexicographically smallest string that starts at a leaf of this tree and ends at the root.

(As a reminder,any shorter prefix of a string is lexicographically smaller:for example,"ab"is 
lexicographically smaller than"aba".A leaf of a node is a node that has no children.)

Note:
	1. The number of nodes in the given tree will be between 1 and 8500.
	2. Each node in the tree will have a value between 0 and 25.
*/

public class SmallestStringStartingFromLeaf988 {
	String ans;

	public String smallestFromLeaf(TreeNode root) {
		ans = "";

		smallestFromLeaf(root, "");

		return ans;
	}

	private void smallestFromLeaf(TreeNode root, String cur) {
		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			if (ans.equals("") || ans.compareTo((char) (root.val + 'a') + cur) > 0)
				ans = (char) (root.val + 'a') + cur;
			return;
		}

		smallestFromLeaf(root.left, (char) (root.val + 'a') + cur);
		smallestFromLeaf(root.right, (char) (root.val + 'a') + cur);
	}

}
