package Trees;

/*
450. Delete Node in a BST
Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:
	1. Search for a node to remove.
	2. If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:
	
	root = [5,3,6,2,4,null,7]
	key = 3
	
	    5
	   / \
	  3   6
	 / \   \
	2   4   7

	Given key to delete is 3. So we find the node with value 3 and delete it.
	One valid answer is [5,4,6,2,null,null,7], shown in the following BST.

	    5
	   / \
	  4   6
	 /     \
	2       7

	Another valid answer is [5,2,6,null,4,null,7].

	    5
	   / \
	  2   6
	   \   \
	    4   7
*/
public class DeleteNodeInABST450 {

	public TreeNode deleteNode(TreeNode root, int key) {
		if(root == null)
			return null;
		
		if(root.val > key) {
			root.left = deleteNode(root.left, key);
		}
		else if(root.val < key)
			root.right = deleteNode(root.right, key);
		else {
			if(root.left == null)
				return root.right;
			if(root.right == null)
				return root.left;
			/*root.val = maxLeftValue(root.left);
			root.left = deleteNode(root.left, root.val);
			*/
			root.val = minRightValue(root.right);
			root.right = deleteNode(root.right, root.val);
		}
		
		return root;
	}

	private int minRightValue(TreeNode root) {
		int minVal = root.val;
		while(root.left != null) {
			root = root.left;
			minVal = root.val;
		}
		
		return minVal;
	}

}
