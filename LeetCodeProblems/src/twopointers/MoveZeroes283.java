package twopointers;
/*
283. Move Zeroes
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the 
non-zero elements.

Example:
	Input: [0,1,0,3,12]
	Output: [1,3,12,0,0]

Note:
	1. You must do this in-place without making a copy of the array.
	2. Minimize the total number of operations.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MoveZeroes283 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];

		String[] input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			A[i] = Integer.parseInt(input[i]);

		moveZeroes(A);
	}

	public static void moveZeroes(int[] nums) {
		int i= 0,j=0;
		
		for(j = 0;j<nums.length;j++) {
			if(nums[j] != 0) {
				swap(nums,i,j);
				i++;
			}
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
		
	}

}
