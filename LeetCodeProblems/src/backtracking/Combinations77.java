package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
77. Combinations
Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

Example:
	Input: n = 4, k = 2
	Output:
	[
	  [2,4],
	  [3,4],
	  [2,3],
	  [1,2],
	  [1,3],
	  [1,4],
	]
*/
public class Combinations77 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());

		combine(n, k);

		System.out.println(result);
	}

	static List<List<Integer>> result;

	public static List<List<Integer>> combine(int n, int k) {
		result = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<Integer>();

		combine(n, 1, k, temp);
		return result;
	}

	private static void combine(int n, int curr, int k, List<Integer> temp) {
		if (k == 0) {
			result.add(new ArrayList<>(temp));
			return;
		}

		if (curr > n)
			return;

		/*temp.add(curr);
		combine(n, curr + 1, k - 1, temp);
		temp.remove(temp.size() - 1);

		combine(n, curr + 1, k, temp);*/
		
		for(int i = curr;i<=n;i++) {
			temp.add(i);
			combine(n, i + 1, k - 1, temp);
			temp.remove(temp.size() - 1);
		}
	}

}
