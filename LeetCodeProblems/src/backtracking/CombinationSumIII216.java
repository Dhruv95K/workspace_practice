package backtracking;
/*
216. Combination Sum III
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 
1 to 9 can be used and each combination should be a unique set of numbers.

Note:
1. All numbers will be positive integers.
2. The solution set must not contain duplicate combinations.

Example 1:
	Input: k = 3, n = 7
	Output: [[1,2,4]]
		
Example 2:
	Input: k = 3, n = 9
	Output: [[1,2,6], [1,3,5], [2,3,4]]
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII216 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int k = Integer.parseInt(read.readLine());
		int n = Integer.parseInt(read.readLine());

		combinationSum3(k, n);

		System.out.println(ans);
	}

	static List<List<Integer>> ans;

	public static List<List<Integer>> combinationSum3(int k, int n) {
		ans = new ArrayList<List<Integer>>();
		List<Integer> temp = new ArrayList<>();
		combinationSum3(k, n, 1, temp);
		return ans;
	}

	private static void combinationSum3(int k, int sum, int num, List<Integer> temp) {
		if (k == 0) {
			if (sum == 0)
				ans.add(new ArrayList<Integer>(temp));
			return;
		}

		if (sum <= 0 || k < 0 || num > 9)
			return;

		/*for (int i = num; i <= 9; i++) {
			temp.add(i);
			combinationSum3(k - 1, n - i, i + 1, temp);
			temp.remove(temp.size() - 1);
		}*/
		temp.add(num);
		combinationSum3(k-1, sum-num, num+1, temp);
		temp.remove(temp.size() - 1);
		
		combinationSum3(k, sum, num+1, temp);
	}
	
	
}
