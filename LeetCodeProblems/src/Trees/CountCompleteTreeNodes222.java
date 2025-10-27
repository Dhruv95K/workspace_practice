package Trees;
/*
222. Count Complete Tree Nodes
Given a complete binary tree, count the number of nodes.

Note:

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all
nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive
at the last level h.

Example:	
	Input: 
	    1
	   / \
	  2   3
	 / \  /
	4  5 6
	
	Output: 6
	
Example 2:

	Input: root = []
	Output: 0
	
Example 3:
	
	Input: root = [1]
	Output: 1
 

Constraints:

	1. The number of nodes in the tree is in the range [0, 5 * 10^4].
	2. 0 <= Node.val <= 5 * 10^4
	3. The tree is guaranteed to be complete.
 

Follow up: Traversing the tree to count the number of nodes in the tree is an easy solution but with O(n) complexity. Could you find a faster algorithm?
*/

public class CountCompleteTreeNodes222 {

	public int countNodesBSearch(TreeNode root) {
		if(root == null)
            return 0;
		int lo = 1;
		int hi = 50000;
		int ans = -1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			boolean check = checkForNumberInBST(root,mid);
			if (check) {
				ans = mid;
				lo = mid + 1;
			} else
				hi = mid - 1;
		}

		return ans;
	}

	private boolean checkForNumberInBST(TreeNode root, int mid) {
		boolean startSearch = false;
		
		for(int i = 17 ; i >= 0; i--) {
			int bit = mid & (1 << i);
			if(!startSearch) {
				if(bit > 0)
					startSearch = true;
			}
			else {
				if(bit == 0)
					root = root.left;
				else 
					root = root.right;
				
				if(root == null)
					return false;
			}
		}
		return true;
	}

	public int countNodes(TreeNode root) {
		if (root == null)
			return 0;

		int left = leftHeight(root);
		int right = rightHeight(root);

		if (left == right)
			return 1 << left - 1;

		return 1 + countNodes(root.left) + countNodes(root.right);
	}

	private int leftHeight(TreeNode node) {
		int d = 0;
		while (node != null) {
			d++;
			node = node.left;
		}
		return d;
	}

	private int rightHeight(TreeNode node) {
		int d = 0;
		while (node != null) {
			d++;
			node = node.right;
		}
		return d;
	}

}
