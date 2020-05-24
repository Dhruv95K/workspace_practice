package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
704. Binary Search
Given a sorted (in ascending order) integer array nums of n elements and a target value, write a function to search 
target in nums. If target exists, then return its index, otherwise return -1.

Example 1:
	Input: nums = [-1,0,3,5,9,12], target = 9
	Output: 4
	Explanation: 9 exists in nums and its index is 4

Example 2:
	Input: nums = [-1,0,3,5,9,12], target = 2
	Output: -1
	Explanation: 2 does not exist in nums so return -1
 
Note:

	1. You may assume that all elements in nums are unique.
	2. n will be in the range [1, 10000].
	3. The value of each element in nums will be in the range [-9999, 9999].
*/

public class BinarySearch704 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		String[] input = br.readLine().split(","); 
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(input[i]);
		
		int target = Integer.parseInt(br.readLine());
		
		System.out.println(search(arr,target));
		
	}

	public static int search(int[] nums, int target) {

		int l = 0, r = nums.length - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] > target)
				r = mid - 1;
			else
				l = mid + 1;

		}

		return -1;
	}

}
