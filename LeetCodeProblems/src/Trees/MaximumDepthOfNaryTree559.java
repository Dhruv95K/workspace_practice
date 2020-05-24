package Trees;
/*
Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the 
farthest leaf node.

Nary-Tree input serialization is represented in their level order traversal, each group of 
children is separated by the null value (See examples).
*/

public class MaximumDepthOfNaryTree559 {

	public static void main(String[] args) {

	}

	public int maxDepth(NaryNode root) {
		if(root == null)
			return 0;
		
		int d = 1;
		
		for(int i = 0;i<root.children.size();i++)
			d = Math.max(d,	1 + maxDepth(root.children.get(i)));
		
		return d;
	}

}
