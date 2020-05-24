package binarySearch;
/*
35. Search Insert Position
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would 
be if it were inserted in order.
You may assume no duplicates in the array.

Example 1:
	Input: [1,3,5,6], 5
	Output: 2
	
Example 2:
	Input: [1,3,5,6], 2
	Output: 1
	
Example 3:
	Input: [1,3,5,6], 7
	Output: 4
	
Example 4:
	Input: [1,3,5,6], 0
	Output: 0
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SearchInsertPosition35 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		String[] input = br.readLine().split(",");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(input[i]);

		int target = Integer.parseInt(br.readLine());

		System.out.println(searchInsert(arr, target));
	}

	// find index of just greater
	public static int searchInsert(int[] nums, int target) {
		if (nums.length == 0)
			return 0;

		int ind = findGreaterOrEqual(nums, target);
		if (ind == -1)
			return nums.length;

		return ind;
	}

	public static int findGreaterOrEqual(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		int ans = -1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] == target)
				return mid;
			if (nums[mid] > target) {
				ans = mid;
				r = mid - 1;
			} else
				l = mid + 1;
		}

		return ans;
	}

}
