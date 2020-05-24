package twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
41. First Missing Positive
Given an unsorted integer array, find the smallest missing positive integer.

Example 1:
	Input: [1,2,0]
	Output: 3

Example 2:	
	Input: [3,4,-1,1]
	Output: 2

Example 3:
	Input: [7,8,9,11,12]
	Output: 1

Note:
	1. Your algorithm should run in O(n) time and uses constant extra space.
*/

public class FirstMissingPositive41 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];

		String[] input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			A[i] = Integer.parseInt(input[i]);

		System.out.println(firstMissingPositive(A));
	}

	public static int firstMissingPositive(int[] nums) {
		int ans = -1;
		int index = partition(nums);
		if (index == -1)
			return 1;

		for (int i = 0; i <= index; i++) {
			int ind = Math.abs(nums[i]);
			if(ind - 1 <= index && nums[ind - 1] > 0)
				nums[ind - 1] = 0 - nums[ind - 1];
		}
		
		for(int i = 0;i<=index;i++) {
			if(nums[i] > 0)
				return i+1;
		}
		
		return ans;
	}

	private static int partition(int[] nums) {
		int i = 0, j = 0;

		for (i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				swap(nums, i, j);
				j++;
			}
		}
		return j - 1;
	}

	private static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
