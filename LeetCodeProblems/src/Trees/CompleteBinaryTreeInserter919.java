package Trees;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/*
919. Complete Binary Tree Inserter
A complete binary tree is a binary tree in which every level, except possibly the last, is completely filled, and all 
nodes are as far left as possible.

Write a data structure CBTInserter that is initialized with a complete binary tree and supports the following operations:

	1. CBTInserter(TreeNode root) initializes the data structure on a given tree with head node root;
	2. CBTInserter.insert(int v) will insert a TreeNode into the tree with value node.val = v so that the tree remains complete, 
			and returns the value of the parent of the inserted TreeNode;
	3. CBTInserter.get_root() will return the head node of the tree.
 

Example 1:
	Input: inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
	Output: [null,1,[1,2]]
			
Example 2:
	Input: inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
	Output: [null,3,4,[1,2,3,4,5,6,7,8]]
 
Note:

	1. The initial given tree is complete and contains between 1 and 1000 nodes.
	2. CBTInserter.insert is called at most 10000 times per test case.
	3. Every value of a given or inserted node is between 0 and 5000.
*/

public class CompleteBinaryTreeInserter919 {

	TreeNode root;
	Deque<TreeNode> deque;
	public CompleteBinaryTreeInserter919(TreeNode root) {
		this.root = root;
		deque = new LinkedList<>();
		Queue<TreeNode> q = new LinkedList<>();
		q.offer(this.root);
		
		while(!q.isEmpty()) {
			TreeNode t = q.poll();
			if(t.left == null || t.right == null)
				deque.add(t);
			if(t.left != null) 
				q.offer(t.left);
			
			if(t.right != null) 
				q.offer(t.right);
		}
	}

	public int insert(int v) {
		TreeNode node = deque.peekFirst();
		deque.offerLast(new TreeNode(v));
		
		if(node.left == null)
			node.left = deque.peekLast();
		else {
			node.right = deque.peekLast();
			deque.pollFirst();
		}
		
		return node.val;
	}

	public TreeNode get_root() {
		return this.root;
	}

}
/*                                        didnt understand
List<TreeNode> tree;
public CBTInserter(TreeNode root) {
    tree = new ArrayList<>();
    tree.add(root);
    for (int i = 0; i < tree.size(); ++i) {
        if (tree.get(i).left != null) tree.add(tree.get(i).left);
        if (tree.get(i).right != null) tree.add(tree.get(i).right);
    }
}

public int insert(int v) {
    int N = tree.size();
    TreeNode node = new TreeNode(v);
    tree.add(node);
    if (N % 2 == 1)
        tree.get((N - 1) / 2).left = node;
    else
        tree.get((N - 1) / 2).right = node;
    return tree.get((N - 1) / 2).val;
}

public TreeNode get_root() {
    return tree.get(0);
}
*/
