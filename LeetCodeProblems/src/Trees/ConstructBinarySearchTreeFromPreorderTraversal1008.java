package Trees;
/*
1008. Construct Binary Search Tree from Preorder Traversal
Return the root node of a binary search tree that matches the given preorder traversal.

(Recall that a binary search tree is a binary tree where for every node, any descendant of node.left 
has a value < node.val, and any descendant of node.right has a value > node.val.  
Also recall that a preorder traversal displays the value of the node first, then traverses node.left, 
then traverses node.right.)

Example 1:
	Input: [8,5,1,7,10,12]
	Output: [8,5,10,1,7,null,12] 

Note: 
	1. 1 <= preorder.length <= 100
	2. The values of preorder are distinct.
*/

public class ConstructBinarySearchTreeFromPreorderTraversal1008 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	int index = 0;

	public TreeNode bstFromPreorder(int[] preorder) {
		return bstFromPreorder(preorder, Integer.MAX_VALUE);

	}

	private TreeNode bstFromPreorder(int[] preorder, int bound) {
		if (index == preorder.length || preorder[index] > bound)
			return null;

		TreeNode root = new TreeNode(preorder[index++]);
		root.left = bstFromPreorder(preorder, root.val);
		root.right = bstFromPreorder(preorder, bound);

		return root;
	}

}
