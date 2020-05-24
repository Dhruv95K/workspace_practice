import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
1218. Longest Arithmetic Subsequence of Given Difference
Given an integer array arr and an integer difference, return the length of the longest subsequence in arr 
which is an arithmetic sequence such that the difference between adjacent elements in the subsequence equals difference.

Example 1:
	Input: arr = [1,2,3,4], difference = 1
	Output: 4
	Explanation: The longest arithmetic subsequence is [1,2,3,4].
	
Example 2:	
	Input: arr = [1,3,5,7], difference = 1
	Output: 1
	Explanation: The longest arithmetic subsequence is any single element.

Example 3:
	Input: arr = [1,5,7,8,5,3,4,2,1], difference = -2
	Output: 4
	Explanation: The longest arithmetic subsequence is [7,5,3,1].
 
Constraints:
	1. 1 <= arr.length <= 10^5
	2. -10^4 <= arr[i], difference <= 10^4
*/
public class LongestArithmeticSubsequenceOfGivenDifference {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int d = Integer.parseInt(br.readLine());

		int ans = longestSubsequence(arr, d);

		System.out.println(ans);
	}

	public static int longestSubsequence(int[] arr, int difference) {
		int n = arr.length;
		int res = 0;
		int[] dp = new int[n];

		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] + difference == arr[i])
					dp[i] = Math.max(dp[i], 1 + dp[j]);
			}
			res = Math.max(res, dp[i]);
		}

		return res;
	}

	public static int longestSubsequenceUsingMap(int[] arr, int difference) {
		int longest = 0;
		int n = arr.length;

		Map<Integer, Integer> dp = new HashMap<>();

		for (int i = 0; i < n; i++) {
			dp.put(arr[i], dp.getOrDefault(arr[i] - difference, 0) + 1);
			longest = Math.max(longest, dp.get(arr[i]));
		}

		return longest;
	}

}
