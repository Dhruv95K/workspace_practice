package twopointers;
/*
26. Remove Duplicates from Sorted Array
Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

Example 1:
	Given nums = [1,1,2],
	Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
	It doesn't matter what you leave beyond the returned length.

Example 2:
	Given nums = [0,0,1,1,1,2,2,3,3,4],
	Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
	It doesn't matter what values are set beyond the returned length.

Clarification:

Confused why the returned value is an integer but your answer is an array?

Note that the input array is passed in by reference, which means modification to the input array will be known to the caller as well.

Internally you can think of this:

// nums is passed in by reference. (i.e., without making a copy)
int len = removeDuplicates(nums);

// any modification to nums in your function would be known by the caller.
// using the length returned by your function, it prints the first len elements.
for (int i = 0; i < len; i++) {
    print(nums[i]);
}
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicatesFromSortedArray26 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];

		String[] input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			A[i] = Integer.parseInt(input[i]);

		System.out.println(removeDuplicates(A));

	}

	public static int removeDuplicates(int[] nums) {
		int n = nums.length;
		int i = 0, j = 1;

		while (j < n) {
			/*while (j != n - 1 && nums[j + 1] == nums[j]) {
				j++;
			}
			swap(nums, i, j);
			i++;
			j++;*/
			if(nums[i] != nums[j]) {
				i++;
				nums[i] = nums[j];
			}
			j++;
		}

		return i+1;
	}

	private static void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
