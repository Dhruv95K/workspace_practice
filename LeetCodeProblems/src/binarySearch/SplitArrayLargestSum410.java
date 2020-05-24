package binarySearch;
/*
410. Split Array Largest Sum
Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty 
continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

Note:
If n is the length of array, assume the following constraints are satisfied:
	1. 1 ¡Ü n ¡Ü 1000
	2. 1 ¡Ü m ¡Ü min(50, n)
	
Examples:
	Input:
	nums = [7,2,5,10,8]
	m = 2

	Output:
	18

Explanation:
	There are four ways to split nums into two subarrays.
	The best way is to split it into [7,2,5] and [10,8],
	where the largest sum among the two subarrays is only 18.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SplitArrayLargestSum410 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		String[] input;
		input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(input[i]);

		int m = Integer.parseInt(br.readLine());

		System.out.println(splitArray(a, m));
	}

	public static int splitArray(int[] nums, int m) {
		int n = nums.length;
		long[] bounds = getSumAndMax(nums);

		long l = bounds[0], r = bounds[1];
		long ans = -1;

		while (l <= r) {
			long mid = l + (r - l) / 2;
			int splits = countSplits(nums, mid);

			if (splits <= m) {
				r = mid - 1;
				ans = mid;
			} else
				l = mid + 1;
			
			// this is for max largest sum
			/*
			 * if (splits >= m) { ans = mid; l = mid + 1; } else r = mid - 1;
			 */
		}

		return (int) ans;
	}

	private static int countSplits(int[] nums, long sum) {
		int splits = 1;
		long total = 0;
		for (int i = 0; i < nums.length; i++) {
			total += nums[i];
			if (total > sum) {
				splits++;
				total = nums[i];
			}
		}
		return splits;
	}

	private static long[] getSumAndMax(int[] nums) {
		long sum = 0, max = Long.MIN_VALUE;
		for (int i : nums) {
			sum += i;
			max = Math.max(max, i);
		}
		return new long[] { max, sum };
	}

}
