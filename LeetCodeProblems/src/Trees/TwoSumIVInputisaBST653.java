package Trees;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
653. Two Sum IV - Input is a BST
Given a Binary Search Tree and a target number, return true if there exist two elements in the 
BST such that their sum is equal to the given target.

Example 1:
	Input: 
	    5
	   / \
	  3   6
	 / \   \
	2   4   7
	
	Target = 9
	
	Output: True
 
Example 2:
	Input: 
	    5
	   / \
	  3   6
	 / \   \
	2   4   7
	
	Target = 28
	
	Output: False
*/
public class TwoSumIVInputisaBST653 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	public boolean findTarget(TreeNode root, int k) {
		if(root == null)
			return false;
		
		Set<Integer> set = new HashSet<>();
		
		return find(root,k,set);

	}

	private boolean find(TreeNode root, int k, Set<Integer> set) {
		if(root == null)
			return false;
		
		if(set.contains(k - root.val))
			return true;
		set.add(root.val);
		
		return find(root.left, k, set) || find(root.right, k, set);
	}
	
	public boolean findTargetBFS(TreeNode root, int k) {
		Set < Integer > set = new HashSet();
        Queue < TreeNode > queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            if (queue.peek() != null) {
                TreeNode node = queue.remove();
                if (set.contains(k - node.val))
                    return true;
                set.add(node.val);
                queue.add(node.right);
                queue.add(node.left);
            } else
                queue.remove();
        }
        return false;

	}

}
