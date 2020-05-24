package twopointers;
/*
15. 3Sum
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
	[
	  [-1, 0, 1],
	  [-1, -1, 2]
	]
*/
			
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		String[] input = br.readLine().split(",");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int target = Integer.parseInt(br.readLine());

		System.out.println(threeSum(arr));

	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length == 0 || nums.length == 1 || nums.length == 2)
			return result;
		List<Integer> temp;
		Arrays.sort(nums);
		int ans = nums[0] + nums[1] + nums[nums.length - 1];
		for (int i = 0; i < nums.length - 2; i++) {
			if (i == 0 || nums[i] != nums[i - 1]) {
				int start = i + 1, end = nums.length - 1;
				while (start < end) {
					int sum = nums[i] + nums[start] + nums[end];
					if (sum == 0) {
						temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[start]);
						temp.add(nums[end]);
						result.add(temp);
						while (start < end && nums[start] == nums[start + 1])
							start++;
						while (start < end && nums[end] == nums[end - 1])
							end--;
					}
					if (sum <= 0)
						start++;
					else
						end--;
				}
			}

		}

		return result;
	}
}
