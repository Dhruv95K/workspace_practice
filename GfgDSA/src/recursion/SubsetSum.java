package recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SubsetSum {

	static boolean[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
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
					dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
				}

			}
		}
		set = new HashSet<>();
		printAllSubsets(arr, n, sum, new ArrayList<Integer>());
		System.out.println(set);
	}

	static Set<ArrayList<Integer>> set ;
	
	
	private static void printAllSubsets(int[] arr, int ind, int sum, ArrayList<Integer> ans) {
		if (sum == 0) {
		//	System.out.println(ans);
			ArrayList<Integer> temp = new ArrayList<Integer>(ans);
			Collections.sort(temp);
			set.add(temp);
			return;
		}
		
		if(sum < 0 || dp[ind][sum] == false)
			return;
		
		if (ind == 0) {
			return;
		}
		
		if(sum >= arr[ind-1] && dp[ind-1][sum-arr[ind-1]]) {
			ans.add(arr[ind-1]);
			printAllSubsets(arr, ind-1, sum-arr[ind-1], ans);
			ans.remove(ans.size()-1);
		}
		
		if(dp[ind-1][sum]) {
			printAllSubsets(arr, ind-1, sum, ans);
		}
	}

	private static void printAllSubsetsRecursive(int[] arr, int ind, int sum, ArrayList<Integer> ans) {
		// TODO Auto-generated method stub
		if (sum == 0) {
			System.out.println(ans);
			return;
		}
		
		if (ind == arr.length || sum < 0) {
			return;
		}

		ans.add(arr[ind]);
		printAllSubsetsRecursive(arr, ind + 1, -arr[ind] + sum, ans);
		ans.remove(ans.size() - 1);
		
		printAllSubsetsRecursive(arr, ind + 1, sum, ans);
		
	}

}
