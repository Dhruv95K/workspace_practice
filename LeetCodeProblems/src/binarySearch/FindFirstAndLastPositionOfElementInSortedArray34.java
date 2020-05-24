package binarySearch;
/*
34. Find First and Last Position of Element in Sorted Array
Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:
	Input: nums = [5,7,7,8,8,10], target = 8
	Output: [3,4]
			
Example 2:
	Input: nums = [5,7,7,8,8,10], target = 6
	Output: [-1,-1]
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray34 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		String[] input = br.readLine().split(",");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(input[i]);

		int target = Integer.parseInt(br.readLine());
		
		System.out.println(Arrays.toString(searchRange(arr,target)));
	}

	public static int[] searchRange(int[] nums, int target) {

		int a = findStartingIndex(nums, target);
		int b = findEndingIndex(nums, target);

		int[] ans = new int[2];
		ans[0] = a;
		ans[1] = b;

		return ans;
	}

	public static int findStartingIndex(int[] nums, int target) {
		int l = 0, r = nums.length - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target && (mid == 0 || nums[mid - 1] < target))
				return mid;
			if (nums[mid] >= target)
				r = mid - 1;
			else
				l = mid + 1;
		}

		return -1;

	}

	public static int findEndingIndex(int[] nums, int target) {
		int l = 0, r = nums.length - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target && (mid == nums.length - 1 || nums[mid + 1] > target))
				return mid;
			if (nums[mid] <= target)
				l = mid + 1;
			else
				r = mid - 1;
		}

		return -1;
	}

}
