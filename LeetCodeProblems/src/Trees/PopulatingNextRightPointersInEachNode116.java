package Trees;
/*
116. Populating Next Right Pointers in Each Node
You are given a perfect binary tree where all leaves are on the same level, and every parent 
has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}

Populate each next pointer to point to its next right node. If there is no next right node, 
the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Follow up:
	1. You may only use constant extra space.
	2. Recursive approach is fine, you may assume implicit stack space does not count as 
		extra space for this problem.
 
Example 1:
	Input: root = [1,2,3,4,5,6,7]
	Output: [1,#,2,3,#,4,5,6,7,#]
	Explanation: Given the above perfect binary tree (Figure A), your function should 
		populate each next pointer to point to its next right node, just like in Figure B. 
		The serialized output is in level order as connected by the next pointers, with '#' 
		signifying the end of each level.
 
Constraints:
	1. The number of nodes in the given tree is less than 4096.
	2. -1000 <= node.val <= 1000
*/

import java.util.LinkedList;
import java.util.Queue;

class NextTreeNode {
    public int val;
    public NextTreeNode left;
    public NextTreeNode right;
    public NextTreeNode next;

    public NextTreeNode() {}
    
    public NextTreeNode(int _val) {
        val = _val;
    }

    public NextTreeNode(int _val, NextTreeNode _left, NextTreeNode _right, NextTreeNode _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class PopulatingNextRightPointersInEachNode116 {
	public NextTreeNode connectBFS(NextTreeNode root) {

		Queue<NextTreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			int s = q.size();

			for (int i = 0; i < s; i++) {
				NextTreeNode temp = q.poll();
				if (temp != null) {
					temp.next = q.peek();
					if (temp.left != null)
						q.offer(temp.left);
					if (temp.right != null)
						q.offer(temp.right);
				}
			}
			if (!q.isEmpty())
				q.add(null);
		}

		return root;
	}
	
	
	public NextTreeNode connect(NextTreeNode root) {
		NextTreeNode p = root;
		
		if(p == null)
			return null;
		
		p.next = null;
		
		while(p !=null) {
			NextTreeNode q = p;
			while(q!=null) {
				
				if(q.left != null) {
					if(q.right != null)
						q.left.next = q.right;
					else
						q.left.next = getNextRight(q);
				}
				
				if(q.right != null)
					q.right.next = getNextRight(q);
				
				q = q.next;
			}
			
			if(p.left != null)
				p = p.left;
			else if(p.right != null)
				p = p.right;
			else 
				p = getNextRight(p);
		}
	       
		return root;
    }


	private NextTreeNode getNextRight(NextTreeNode q) {
		NextTreeNode temp = q.next;
		while(temp != null) {
			if(temp.left != null)
				return temp.left;
			if(temp.right != null)
				return temp.right;
			temp = temp.next;
		}
		return temp;
	}
}
