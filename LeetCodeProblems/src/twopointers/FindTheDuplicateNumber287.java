package twopointers;
/*
287. Find the Duplicate Number
Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least
one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Example 1:
	Input: [1,3,4,2,2]
	Output: 2

Example 2:
	Input: [3,1,3,4,2]
	Output: 3

Note:
	1. You must not modify the array (assume the array is read only).
	2. You must use only constant, O(1) extra space.
	3. Your runtime complexity should be less than O(n2).
	4. There is only one duplicate number in the array, but it could be repeated more than once.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindTheDuplicateNumber287 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];

		String[] input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			A[i] = Integer.parseInt(input[i]);

		System.out.println(findDuplicate(A));
	}

	public static int findDuplicate(int[] nums) {
		int n = nums.length;

		for (int i = 0; i < n; i++) {
			int index = Math.abs(nums[i]);
			if (nums[index - 1] < 0)
				return i + 1;

			nums[index - 1] = 0 - nums[index - 1];
		}
		
		return -1;
	}

}
