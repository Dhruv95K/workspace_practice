package binarySearch;
/*
81. Search in Rotated Sorted Array II
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).

You are given a target value to search. If found in the array return true, otherwise return false.

Example 1:
	Input: nums = [2,5,6,0,0,1,2], target = 0
	Output: true

Example 2:
	Input: nums = [2,5,6,0,0,1,2], target = 3
	Output: false

Follow up:
	1. This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
	2. Would this affect the run-time complexity? How and why?		
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchinRotatedSortedArrayII81 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		String[] input;
		input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(input[i]);

		int target = Integer.parseInt(br.readLine());

		System.out.println(search(a, target));
	}

	public static boolean search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target)
				return true;

			if (nums[mid] < nums[r] || nums[l] > nums[mid]) {
				if (target > nums[mid] && target <= nums[r])
					l = mid + 1;
				else
					r = mid - 1;
			} else if (nums[mid] > nums[r] || nums[mid] > nums[l]) {
				if (target < nums[mid] && target >= nums[l])
					r = mid - 1;
				else
					l = mid + 1;
			}
			else
				r--;

		}

		return false;
	}

}
