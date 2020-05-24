package twopointers;
/*
977. Squares of a Sorted Array
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also 
in sorted non-decreasing order.
		 
Example 1:
	Input: [-4,-1,0,3,10]
	Output: [0,1,9,16,100]

Example 2:
	Input: [-7,-3,2,3,11]
	Output: [4,9,9,49,121]
 
Note:

	1. 1 <= A.length <= 10000
	2. -10000 <= A[i] <= 10000
	3. A is sorted in non-decreasing order.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SquaresOfASortedArray977 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] A = new int[n];
		String[] input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			A[i] = Integer.parseInt(input[i]);

		int[] ans = sortedSquares(A);
	}

	public static int[] sortedSquares(int[] A) {
		int[] ans = new int[A.length];
		int ind = A.length - 1; 
				
		int l = 0,r = ind;
		
		while(l <= r) {
			if(Math.abs(A[l]) > Math.abs(A[r])) {
				ans[ind--] = A[l] * A[l];
				l++;
			}
			else {
				ans[ind--] = A[r] * A[r];
				r--;
			}
		}
		
		return ans;
	}

}
