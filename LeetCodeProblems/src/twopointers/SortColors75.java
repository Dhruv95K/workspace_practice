package twopointers;
/*
75. Sort Colors
Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are 
adjacent, with the colors in the order red, white and blue.
Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
Note: You are not suppose to use the library's sort function for this problem.

Example:
	Input: [2,0,2,1,1,0]
	Output: [0,0,1,1,2,2]
			
Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, 
then 1's and followed by 2's.
Could you come up with a one-pass algorithm using only constant space?
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SortColors75 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		String[] input = br.readLine().split(",");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(input[i]);

		sortColors(arr);
		System.out.println(Arrays.toString(arr));

	}

	public static void sortColors(int[] nums) {
		// Arrays.sort(nums);
		int lo = 0, mid = 0, hi = nums.length - 1;

		while (mid <= hi) {
			switch (nums[mid]) {
			case 0:
				swap(nums,lo,mid);
				lo++;mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				swap(nums, mid, hi);
				hi--;
				break;
			}
		}
		
		
	}

	private static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] =nums[j];
		nums[j] = t;
		
	}

}
