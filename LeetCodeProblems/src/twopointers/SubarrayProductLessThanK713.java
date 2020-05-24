package twopointers;
/*
713. Subarray Product Less Than K
Your are given an array of positive integers nums.

Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.

Example 1:
Input: nums = [10, 5, 2, 6], k = 100
Output: 8
Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.

Note:

	3. 0 < nums.length <= 50000.
	2. 0 < nums[i] < 1000.
	3. 0 <= k < 10^6.

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubarrayProductLessThanK713 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		String[] input = br.readLine().split(",");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int target = Integer.parseInt(br.readLine());

		System.out.println(numSubarrayProductLessThanK(arr, target));
	}

	public static int numSubarrayProductLessThanK(int[] nums, int k) {
		int n = nums.length;
		if (n == 0 || k == 1)
			return 0;
		int prod = 1;
		int ans = 0, start = 0;

		for (int i = 0; i < n; i++) {
			prod *= nums[i];
			while (prod >= k)
				prod = prod / nums[start++];

			ans += i - start + 1;
		}
		
		return ans;

	}

}
