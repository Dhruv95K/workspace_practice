package Trees;

import java.util.HashSet;
import java.util.Set;

/*
1123. Lowest Common Ancestor of Deepest Leaves
Given a rooted binary tree, return the lowest common ancestor of its deepest leaves.

Recall that:

	1. The node of a binary tree is a leaf if and only if it has no children
	2. The depth of the root of the tree is 0, and if the depth of a node is d, the depth of each of 
		its children is d+1.
	3. The lowest common ancestor of a set S of nodes is the node A with the largest depth such that 
		every node in S is in the subtree with root A.
		
Example 1:
	Input: root = [1,2,3]
	Output: [1,2,3]
	Explanation: 
	The deepest leaves are the nodes with values 2 and 3.
	The lowest common ancestor of these leaves is the node with value 1.
	The answer returned is a TreeNode object (not an array) with serialization "[1,2,3]".
	
Example 2:
	Input: root = [1,2,3,4]
	Output: [4]
			
Example 3:
	Input: root = [1,2,3,4,5]
	Output: [2,4,5]
		 

Constraints:
	1. The given tree will have between 1 and 1000 nodes.
	2. Each node of the tree will have a distinct value between 1 and 1000.
*/

public class LowestCommonAncestorOfDeepestLeaves1123 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	TreeNode lca;
	boolean found;

	public TreeNode lcaDeepestLeaves(TreeNode root) {
		int d = depth(root);
		Set<Integer> set = new HashSet<>();
		getDeepestLeaves(root, d, set);

		int n = set.size();
		found = false;
		findLca(root, n, set);
		
		return lca;
	}

	private int findLca(TreeNode root, int n, Set<Integer> set) {
		int res = 0;
		if (root == null)
			return 0;

		if (set.contains(root.val))
			res++;

		if (root.left != null)
			res += findLca(root.left, n, set);
		if (root.right != null)
			res += findLca(root.right, n, set);
		
		if(res == n && found == false) {
			lca = root;
			found = true;
		}
		
		return res;
	}

	private void getDeepestLeaves(TreeNode root, int d, Set<Integer> set) {
		if (root == null)
			return;

		if (d == 1)
			set.add(root.val);

		getDeepestLeaves(root.left, d - 1, set);
		getDeepestLeaves(root.right, d - 1, set);
	}

	private int depth(TreeNode root) {
		if (root == null)
			return 0;

		return 1 + Math.max(depth(root.left), depth(root.right));
	}
	
	/*
	 class Pair {
        TreeNode node;
        int d;
        Pair(TreeNode node, int d) {
            this.node = node;
            this.d = d;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Pair p = getLca(root, 0);
        return p.node;
    }
    private Pair getLca(TreeNode root, int d) {
        if (root == null) return new Pair(null, d);
        Pair l = getLca(root.left, d + 1);
        Pair r = getLca(root.right, d + 1);
        if (l.d == r.d) {
            return new Pair(root, l.d);
        } else {
            return  l.d > r.d ? l : r;
        }
    }
    */
}
