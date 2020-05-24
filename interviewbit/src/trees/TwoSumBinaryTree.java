package trees;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import trees.Main.TreeNode;

public class TwoSumBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int t2Sum(TreeNode A, int B) {
		Set<Integer> set = new HashSet<>();
		Stack<TreeNode> st = new Stack<>();
		st.push(A);
		
		while(!st.isEmpty()) {
			TreeNode t = st.pop();
			if(set.contains(B - t.val))
				return 1;
			
			set.add(t.val);
			if(t.left != null)
				st.push(t.left);
			
			if(t.right != null)
				st.push(t.right);
			
		}
		
		return 0;
	}	

}
