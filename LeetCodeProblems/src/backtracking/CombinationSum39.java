package backtracking;

/*39. Combination Sum
Give	n a set of candidate numbers (candidates) (without duplicates) and a target 
number (target), find all unique combinations in candidates where the candidate numbers sums to 
target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:
	1. All numbers (including target) will be positive integers.
	2. The solution set must not contain duplicate combinations.

Example 1:	
	Input: candidates = [2,3,6,7], target = 7,
	A solution set is:
	[
	  [7],
	  [2,2,3]
	]
		
Example 2:
	Input: candidates = [2,3,5], target = 8,
	A solution set is:
	[
	  [2,2,2,2],
	  [2,3,3],
	  [3,5]
	]	
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum39 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		int sum = Integer.parseInt(br.readLine());
		dp = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (j == 0) {
					dp[i][j] = true;
					continue;
				}
				if (i == 0) {
					dp[i][j] = false;
					continue;
				}
				if (arr[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
				else {
					dp[i][j] = dp[i - 1][j] || dp[i][j - arr[i - 1]];
				}

			}
		}
		
		combinationSum(arr,sum);
		System.out.println(result);
	}

	static List<List<Integer>> result;
	static boolean[][] dp;
	
	/*public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		result = new ArrayList<>();
		ArrayList<Integer> temp = new ArrayList<>();
		
		combinationSum(candidates, target,0,temp);
		
		return result;
	}
	private static void combinationSum(int[] candidates, int target, int ind, ArrayList<Integer> temp) {
		if(target == 0) {
			ArrayList<Integer> a = new ArrayList<>(temp);
			result.add(a);
			return;
		}
		
		if(target < 0 || ind == candidates.length)
			return;
		
		for(int i = ind;i<candidates.length;i++) {
			temp.add(candidates[i]);
			combinationSum(candidates, target - candidates[i], i, temp);
			temp.remove(temp.size() - 1);
		}
		
		
	}
*/
	
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		result = new ArrayList<>();
		ArrayList<Integer> ans = new ArrayList<>();
		int n = candidates.length;
        dp = new boolean[n + 1][target + 1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= target; j++) {
				if (j == 0) {
					dp[i][j] = true;
					continue;
				}
				if (i == 0) {
					dp[i][j] = false;
					continue;
				}
				if (candidates[i - 1] > j)
					dp[i][j] = dp[i - 1][j];
				else {
					dp[i][j] = dp[i - 1][j] || dp[i][j - candidates[i - 1]];
				}

			}
		}
        
        
		combinationSum(candidates, target,n,ans);
		
		return result;
	}
	private static void combinationSum(int[] candidates, int target, int ind, ArrayList<Integer> ans) {
		if (target == 0) {
			ArrayList<Integer> temp = new ArrayList<Integer>(ans);
			Collections.reverse(temp);
			result.add(temp);
			return;
		}
        
		if(ind == 0 || target < 0 || dp[ind][target] == false)
			return;
		
		if(target >= candidates[ind-1] && dp[ind][target-candidates[ind-1]]) {
			ans.add(candidates[ind-1]);
			combinationSum(candidates, ind, target-candidates[ind-1], ans);
			ans.remove(ans.size()-1);
		}
		
		if(dp[ind-1][target]) {
			combinationSum(candidates, ind-1, target, ans);
		}
		
	}
}
