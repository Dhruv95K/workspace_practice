package twopointers;
/*
209. Minimum Size Subarray Sum
Given an array of n positive integers and a positive integer s, 
find the minimal length of a contiguous subarray of which the sum ¡Ý s. If there isn't one, return 0 instead.

Example: 
	Input: s = 7, nums = [2,3,1,2,4,3]
	Output: 2
	Explanation: the subarray [4,3] has the minimal length under the problem constraint.
	Follow up:
	If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
*/

public class MinimumSizeSubarraySum209 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
		int start = 0;
		int ans = Integer.MAX_VALUE;
		int sum = 0;

		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (sum < s)
				continue;

			while (sum >= s && start <= i) {
				ans = Math.min(ans, i - start + 1);
				sum -= nums[start];
				start++;
			}
		}

		return ans == Integer.MAX_VALUE ? 0 : ans;
	}

}
