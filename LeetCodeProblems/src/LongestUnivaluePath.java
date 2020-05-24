/*
687. Longest Univalue Path
Given a binary tree, find the length of the longest path where each node in the path has the 
same value. This path may or may not pass through the root.
The length of path between two nodes is represented by the number of edges between them.

Example 1:

	Input:
	
	              5
	             / \
	            4   5
	           / \   \
	          1   1   5
	Output: 2

 

	Example 2:
	
	Input:
	
	              1
	             / \
	            4   5
	           / \   \
	          4   4   5
	Output: 2	
*/

public class LongestUnivaluePath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	static int len = 0;

	public int longestUnivaluePath(Tnode root) {
		len = 0;
		dfs(root);
		
		return len;
	}

	private int dfs(Tnode root) {
		if (root == null)
			return 0;

		int maxLeft = dfs(root.left);
		int maxRight = dfs(root.right);
		
		int maxLeftSoFar = 0,maxRightSoFar = 0;
		
		if(root.left!=null && root.left.val == root.val)
			maxLeftSoFar = maxLeft+1;
		
		if(root.right!=null && root.right.val == root.val)
			maxRightSoFar = maxRight+1;
			
		len = Math.max(len, maxLeftSoFar + maxRightSoFar);

		return Math.max(maxLeftSoFar,maxRightSoFar);
	}

}

class Tnode {
	int val;
	Tnode left;
	Tnode right;

	Tnode(int x) {
		val = x;
	}
}
