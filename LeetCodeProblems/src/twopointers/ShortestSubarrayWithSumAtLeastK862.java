package twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
862. Shortest Subarray with Sum at Least K
Return the length of the shortest, non-empty, contiguous subarray of A with sum at least K.

If there is no non-empty subarray with sum at least K, return -1.
Example 1:
	Input: A = [1], K = 1
	Output: 1
	
Example 2:
	Input: A = [1,2], K = 4
	Output: -1
	
Example 3:
	Input: A = [2,-1,2], K = 3
	Output: 3
	 
Note:
	1. 1 <= A.length <= 50000
	2. -10 ^ 5 <= A[i] <= 10 ^ 5
	3. 1 <= K <= 10 ^ 9
*/

public class ShortestSubarrayWithSumAtLeastK862 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int K = Integer.parseInt(br.readLine());
		
		int[] A = new int[n];
		String[] input = br.readLine().split(",");
		
		for(int i =0;i<n;i++)
			A[i] = Integer.parseInt(input[i]);
		
		
		int ans = shortestSubarray(A,K);
		
	}

	public static int shortestSubarray(int[] A, int K) {
		
		int start = 0;
		int length = Integer.MAX_VALUE;
		int curSum = 0;
		
		for(int i = 0;i<A.length;i++) {
			curSum += A[i];
			
			if(curSum < K)
				continue;
			
			while(curSum >= K && start <= i) {
				length = Math.min(length, i - start +1);
				curSum = curSum - A[start];
				start++;
			}
		}
		
		return length == Integer.MAX_VALUE ? -1 : length;
	}

}
