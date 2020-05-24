package binarySearch;
/*
162. Find Peak Element
A peak element is an element that is greater than its neighbors.

Given an input array nums, where nums[i] ¡Ù nums[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that nums[-1] = nums[n] = -¡Þ.

Example 1:

Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.
Example 2:

Input: nums = [1,2,1,3,5,6,4]
Output: 1 or 5 
Explanation: Your function can return either index number 1 where the peak element is 2, 
             or index number 5 where the peak element is 6.
             
Note:
  Your solution should be in logarithmic complexity.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindPeakElement162 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		String[] input;
		input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(br.readLine());

		System.out.println(findPeakElement(a));
	}

	public static int findPeakElement(int[] A) {
		int l = 0, r = A.length - 1;
		int mid = 0;

		while (l <= r) {
			mid = l + (r - l) / 2;
			if ((mid == 0 || A[mid] > A[mid - 1]) && (mid == A.length - 1 || A[mid] > A[mid + 1]))
				return mid;
			else if (mid > 0 && A[mid - 1] >= A[mid])
				r = mid - 1;
			else
				l = mid + 1;
		}

		return mid;
	}

}
