package binarySearch;
/*
1300. Sum of Mutated Array Closest to Target
Given an integer array arr and a target value target, return the integer value such that when we 
change all the integers larger than value in the given array to be equal to value, the sum of the 
array gets as close as possible (in absolute difference) to target.

In case of a tie, return the minimum such integer.

Notice that the answer is not neccesarilly a number from arr.

Example 1:
	Input: arr = [4,9,3], target = 10
	Output: 3
	Explanation: When using 3 arr converts to [3, 3, 3] which sums 9 and that's the optimal answer.
	
Example 2:
	Input: arr = [2,3,5], target = 10
	Output: 5
	
Example 3:
	Input: arr = [60864,25176,27249,21296,20204], target = 56803
	Output: 11361
 
Constraints:
	1. 1 <= arr.length <= 10^4
	2. 1 <= arr[i], target <= 10^5
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SumOfMutatedArrayClosestToTarget1300 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		String[] input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(input[i]);

		int target = Integer.parseInt(br.readLine());

		System.out.println(findBestValue(a, target));
	}

	public static int findBestValue(int[] arr, int target) {
		int l = 1, r = getMax(arr);
		int ans = Integer.MAX_VALUE, ansSum = Integer.MAX_VALUE;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			int sum = getSum(arr, mid);
			if (sum == target)
				return mid;
			else if (sum < target) {
				l = mid + 1;
			} else
				r = mid - 1;
			int diff = Math.abs(sum - target);
			int prevDiff = Math.abs(ansSum - target);
			if(diff < prevDiff) {
				ans =  mid;
				ansSum = sum;
			}
			else if(diff == prevDiff)
				ans = Math.min(ans, mid);
		}
		return ans;
	}

	private static int getMax(int[] arr) {
		int max = -1;
		for(int i : arr)
			max = Math.max(max, i);
		
		return max;
	}

	private static int getSum(int[] arr, int mid) {
		int sum = 0;
		for(int i: arr) {
			if( i < mid)
				sum += i;
			else
				sum += mid;
		}
		return sum;
	}

}
