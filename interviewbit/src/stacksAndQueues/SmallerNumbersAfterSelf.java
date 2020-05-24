package stacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class TreeNode {
	TreeNode left;
	TreeNode right;
	int val, count = 1;

	public TreeNode(int val) {
		this.val = val;
	}
}

public class SmallerNumbersAfterSelf {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		ArrayList<Integer> arr = new ArrayList<>();
		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(input[i]));
		}

		System.out.println(countOfSmallerNumbersAfterSelf(arr, n).toString());
	}

	private static ArrayList<Integer> countOfSmallerNumbersAfterSelf(ArrayList<Integer> arr, int n) {
		ArrayList<Integer> res = new ArrayList<>();
		TreeNode root = new TreeNode(arr.get(n - 1));
		res.add(0);
		for (int i = n - 2; i >= 0; i--) {
			int count = insert(root, arr.get(i));
			res.add(count);
		}
		
		Collections.reverse(res);
		return res;
	}

	private static int insert(TreeNode root, int val) {
		int thisCount = 0;

		while (true) {
			if (val <= root.val) {
				root.count++;
				if (root.left == null) {
					root.left = new TreeNode(val);
					break;
				} else
					root = root.left;
			} else {
				thisCount += root.count;
				if (root.right == null) {
					root.right = new TreeNode(val);
					break;
				} else
					root = root.right;
			}
		}

		return thisCount;
	}

}
