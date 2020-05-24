package binarySearch;
/*
718. Maximum Length of Repeated Subarray
Given two integer arrays A and B, return the maximum length of an subarray that appears in both 
arrays.

Example 1:
	Input:
	A: [1,2,3,2,1]
	B: [3,2,1,4,7]
	Output: 3
	Explanation: 
	The repeated subarray with maximum length is [3, 2, 1].
 
Note:	
	1. 1 <= len(A), len(B) <= 1000
	2. 0 <= A[i], B[i] < 100
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumLengthOfRepeatedSubarray718 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		int[] b = new int[m];
		String[] input;
		input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(input[i]);

		for (int i = 0; i < m; i++)
			b[i] = Integer.parseInt(input[i]);

		System.out.println(findLength(a, b));
	}

	public static int findLength(int[] A, int[] B) {
		int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        for (int i = 1; i <= A.length; i++) {
        	for (int j = 1; j <= B.length; j++) {
                if (A[i-1] == B[j-1]) {
                    memo[i][j] = memo[i-1][j-1] + 1;
                    if (ans < memo[i][j]) ans = memo[i][j];
                }
            }
        }
        return ans;
	}

	
}
