package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
173. Binary Search Tree Iterator
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Example:

BSTIterator iterator = new BSTIterator(root);
iterator.next();    // return 3
iterator.next();    // return 7
iterator.hasNext(); // return true
iterator.next();    // return 9
iterator.hasNext(); // return true
iterator.next();    // return 15
iterator.hasNext(); // return true
iterator.next();    // return 20
iterator.hasNext(); // return false
 

Note:
	1. next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the 
		height of the tree.
	2. You may assume that next() call will always be valid, that is, there will be at least a 
		next smallest number in the BST when next() is called.
		*/

public class BinarySearchTreeIterator173 {
	// do this with arraylist,index and recursive inorder
	TreeNode root;
	Queue<Integer> q;
	public BinarySearchTreeIterator173(TreeNode root) {
		this.root = root;
		q = new LinkedList<>();
		Stack<TreeNode> st = new Stack<>();
		TreeNode cur = root;
		while(!st.isEmpty() || cur != null) {
			while(cur != null) {
				st.push(cur);
				cur = cur.left;
			}
			cur =st.pop();
			q.offer(cur.val);
			cur = cur.right;
		}
		
	}

	
	public int next() {
		if(hasNext()) {
			return q.poll();
		}
		return -1;
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		return !q.isEmpty();
	}

}
