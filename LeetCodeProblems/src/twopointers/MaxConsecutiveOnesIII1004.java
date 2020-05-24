package twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1004. Max Consecutive Ones III
Given an array A of 0s and 1s, we may change up to K values from 0 to 1.

Return the length of the longest (contiguous) subarray that contains only 1s. 

Example 1:	
	Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
	Output: 6
	Explanation: 
	[1,1,1,0,0,1,1,1,1,1,1]
	Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.

Example 2:	
	Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
	Output: 10
	Explanation: 
	[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
	Bolded numbers were flipped from 0 to 1.  The longest subarray is underlined.
 

Note:
	1. 1 <= A.length <= 20000
	2. 0 <= K <= A.length
	3. A[i] is 0 or 1
*/

public class MaxConsecutiveOnesIII1004 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		String[] input = br.readLine().split(",");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int k = Integer.parseInt(br.readLine());

		System.out.println(longestOnes(arr, k));

	}

	public static int longestOnes(int[] A, int K) {
		int start = 0;
		int i = 0;
		int n = A.length;

		int countZeroes = 0, ans = Integer.MIN_VALUE;

		while (i < n) {
			if (A[i] == 0)
				countZeroes++;

			while (countZeroes > K) {
				if (A[start] == 0)
					countZeroes--;
				start++;
			}

			ans = Math.max(ans, i - start + 1);
			i++;
		}

		return ans;
	}

}
