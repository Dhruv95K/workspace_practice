package Trees;
/*
449. Serialize and Deserialize BST
Serialization is the process of converting a data structure or object into a sequence of 
bits so that it can be stored in a file or memory buffer, or transmitted across a network 
connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary search tree. There is no restriction 
on how your serialization/deserialization algorithm should work. You just need to ensure that a 
binary search tree can be serialized to a string and this string can be deserialized to the original 
tree structure.

The encoded string should be as compact as possible.

Note: Do not use class member/global/static variables to store states. Your serialize and 
deserialize algorithms should be stateless.
*/

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST449 {

	public String serialize(TreeNode root) {
		ArrayList<Integer> temp = new ArrayList<>();
		preOrder(root, temp);

		String s = "";
		for (int i : temp)
			s += i + ",";

		return s;
	}

	private void preOrder(TreeNode root, ArrayList<Integer> temp) {
		if (root == null) {
			temp.add(-1);
			return;
		}

		temp.add(root.val);
		preOrder(root.left, temp);
		preOrder(root.right, temp);
	}

	
	public TreeNode deserialize(String data) {
		Queue<String> q = new LinkedList<>();
		String[] st = data.split(",");
		for(String s : st)
			q.offer(s);
		
		return deserialize(q);
	}

	private TreeNode deserialize(Queue<String> q) {
		String cur = q.poll();
		if(cur == null || cur.equals("-1"))
			return null;
		
		TreeNode root = new TreeNode(Integer.parseInt(cur));
		root.left = deserialize(q);
		root.right = deserialize(q);
		
		return root;
	}
}
