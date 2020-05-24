package Trees;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
865. Smallest Subtree with all the Deepest Nodes
Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
A node is deepest if it has the largest depth possible among any node in the entire tree.
The subtree of a node is that node, plus the set of all descendants of that node.
Return the node with the largest depth such that it contains all the deepest nodes in its subtree.

Example 1:
	Input: [3,5,1,6,2,0,8,null,null,7,4]
	Output: [2,7,4]
	Explanation:

	We return the node with value 2, colored in yellow in the diagram.
	The nodes colored in blue are the deepest nodes of the tree.
	The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
	The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
	Both the input and output have TreeNode type.
 
Note:
	1. The number of nodes in the tree will be between 1 and 500.
	2. The values of each node are unique.
*/
public class SmallestSubtreeWithAllTheDeepestNodes865 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	Map<TreeNode,Integer> depth;
	int maxDepth;

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
    	depth = new HashMap<>();
        dfs(root,0);	
        
        for(int i : depth.values())
        	maxDepth = Math.max(maxDepth, i);
        
        TreeNode lca = findLca(root);
        
        return lca;
    }
    
    private void dfs(TreeNode root, int level) {
		if(root == null)
			return;
		
		depth.put(root, level);
		dfs(root.left,level + 1);
		dfs(root.right,level + 1);
	}

	private TreeNode findLca(TreeNode root) {
		if (root == null)
			return null;
		
		if(depth.get(root) == maxDepth)
			return root;
		
		TreeNode left = findLca(root.left);
		TreeNode right = findLca(root.right);
		
		if(left != null && right != null)
			return root;
		
		if(left != null)
			return left;
		else if (right != null)
			return right;
		
		return null;
	}


	private int depth(TreeNode root) {
		if (root == null)
			return 0;
		
		return 1 + Math.max(depth(root.left), depth(root.right));
	}

}

/*Approach 2: Recursion
Intuition

We can combine both depth first searches in Approach #1 into an approach that does both steps in one pass. We will have some function dfs(node) that returns both the answer for this subtree, and the distance from node to the deepest nodes in this subtree.

Algorithm

The Result (on some subtree) returned by our (depth-first search) recursion will have two parts:

Result.node: the largest depth node that is equal to or an ancestor of all the deepest nodes of this subtree.
Result.dist: the number of nodes in the path from the root of this subtree, to the deepest node in this subtree.
We can calculate these answers disjointly for dfs(node):

To calculate the Result.node of our answer:

If one childResult has deeper nodes, then childResult.node will be the answer.

If they both have the same depth nodes, then node will be the answer.

The Result.dist of our answer is always 1 more than the largest childResult.dist we have.

class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return dfs(root).node;
    }

    // Return the result of the subtree at this node.
    public Result dfs(TreeNode node) {
        if (node == null) return new Result(null, 0);
        Result L = dfs(node.left),
               R = dfs(node.right);
        if (L.dist > R.dist) return new Result(L.node, L.dist + 1);
        if (L.dist < R.dist) return new Result(R.node, R.dist + 1);
        return new Result(node, L.dist + 1);
    }
}

*//**
 * The result of a subtree is:
 *       Result.node: the largest depth node that is equal to or
 *                    an ancestor of all the deepest nodes of this subtree.
 *       Result.dist: the number of nodes in the path from the root
 *                    of this subtree, to the deepest node in this subtree.
 *//*
class Result {
    TreeNode node;
    int dist;
    Result(TreeNode n, int d) {
        node = n;
        dist = d;
    }
}

Complexity Analysis

Time Complexity: O(N)O(N), where NN is the number of nodes in the tree.

Space Complexity: O(N)O(N).
*/