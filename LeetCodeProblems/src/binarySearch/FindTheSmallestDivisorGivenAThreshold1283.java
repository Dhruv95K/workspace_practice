package binarySearch;
/*
1283. Find the Smallest Divisor Given a Threshold
Given an array of integers nums and an integer threshold, we will choose a positive integer divisor and divide all the 
array by it and sum the result of the division. Find the smallest divisor such that the result mentioned above is less than 
or equal to threshold.

Each result of division is rounded to the nearest integer greater than or equal to that element. (For example: 7/3 = 3 and 
10/2 = 5).

It is guaranteed that there will be an answer.

Example 1:
	Input: nums = [1,2,5,9], threshold = 6
	Output: 5
	Explanation: We can get a sum to 17 (1+2+5+9) if the divisor is 1. 
	If the divisor is 4 we can get a sum to 7 (1+1+2+3) and if the divisor is 5 the sum will be 5 (1+1+1+2).
	
Example 2:
	Input: nums = [2,3,5,7,11], threshold = 11
	Output: 3
	
Example 3:
	Input: nums = [19], threshold = 5
	Output: 4
 
Constraints:
	1. 1 <= nums.length <= 5 * 10^4
	2. 1 <= nums[i] <= 10^6
	3. nums.length <= threshold <= 10^6
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindTheSmallestDivisorGivenAThreshold1283 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		String[] input = br.readLine().split(",");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(input[i]);

		int threshold = Integer.parseInt(br.readLine());

		System.out.println(smallestDivisor(arr, threshold));
	}

	public static int smallestDivisor(int[] nums, int threshold) {
		int max = 1000000, min = 1;

		int l = min, r = max;
		int ans = -1, sum = 0;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			sum = 0;
			for (int j = 0; j < nums.length; j++) {
				int d = (nums[j]+mid-1)/mid;
				sum += d;
			}
			if (sum <= threshold) {
				ans = mid;
				r = mid - 1;
			}
			else
				l = mid + 1;
		}
		
		return ans;
	}

}
