import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
1027. Longest Arithmetic Sequence
Given an array A of integers, return the length of the longest arithmetic subsequence in A.

Recall that a subsequence of A is a list A[i_1], A[i_2], ..., A[i_k] with 0 <= i_1 < i_2 < ... < i_k <= A.length - 1, 
and that a sequence B is arithmetic if B[i+1] - B[i] are all the same value (for 0 <= i < B.length - 1).

Example 1:
	Input: [3,6,9,12]
	Output: 4
	Explanation: 
	The whole array is an arithmetic sequence with steps of length = 3.

Example 2:
	Input: [9,4,7,2,10]
	Output: 3
	Explanation: 
	The longest arithmetic subsequence is [4,7,10].

Example 3:
	Input: [20,1,15,3,10,5,8]
	Output: 4
	Explanation: 
	The longest arithmetic subsequence is [20,15,10,5].
*/
public class LongestArithmeticSequence {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int ans = longestArithSeqLength(arr);
	}

	public static int longestArithSeqLength(int[] A) {
		int n = A.length;
		int res = 0;

		Map<Integer, Integer>[] dp = new HashMap[n];
		for (int i=0;i<n;i++)
			dp[i] = new HashMap<>();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int a = A[i];
				int b = A[j];
				int d = a-b;
				
				int len = 2;
				
				if(dp[j].containsKey(d))
					len = 1 + dp[j].get(d);
				
				int curr = dp[i].getOrDefault(d, 0);
				
				dp[i].put(d, Math.max(curr, len));
				
				res = Math.max(res, dp[i].get(d));
			}			
		}

		return res;
	}

}
