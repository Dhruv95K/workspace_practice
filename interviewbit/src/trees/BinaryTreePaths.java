package trees;

import java.util.ArrayList;

import trees.Main.TreeNode;

public class BinaryTreePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	ArrayList<ArrayList<Integer>> res;

	public ArrayList<ArrayList<Integer>> solve(TreeNode A) {
		res = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		dfs(A, temp);

		return res;
	}

	private void dfs(TreeNode node, ArrayList<Integer> temp) {
		if (node == null) {
			return;
		}

		if (node.left == null && node.right == null) {
			temp.add(node.val);
			res.add(new ArrayList<>(temp));
			temp.remove(temp.size() - 1);
			return;
		}

		temp.add(node.val);
		if (node.left != null)
			dfs(node.left, temp);

		if (node.right != null)
			dfs(node.right, temp);

		temp.remove(temp.size() - 1);

	}

}
