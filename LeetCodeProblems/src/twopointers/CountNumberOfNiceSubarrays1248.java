package twopointers;
/*
1248. Count Number of Nice Subarrays
Given an array of integers nums and an integer k. A subarray is called nice if there are k odd numbers on it.

Return the number of nice sub-arrays.

Example 1:
	Input: nums = [1,1,2,1,1], k = 3
	Output: 2
	Explanation: The only sub-arrays with 3 odd numbers are [1,1,2,1] and [1,2,1,1].

Example 2:
	Input: nums = [2,4,6], k = 1
	Output: 0
	Explanation: There is no odd numbers in the array.
	
Example 3:
	Input: nums = [2,2,2,1,2,2,1,2,2,2], k = 2
	Output: 16
 
Constraints:
	1. 1 <= nums.length <= 50000
	2. 1 <= nums[i] <= 10^5
	3. 1 <= k <= nums.length
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class CountNumberOfNiceSubarrays1248 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		String[] input = br.readLine().split(",");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int k = Integer.parseInt(br.readLine());

		System.out.println(numberOfSubarrays(arr, k));

	}

	public static int numberOfSubarrays(int[] nums, int k) {
		int count = 0;
	//	Map<Integer, Integer> map = new HashMap<>();
		int[] prefix = new int[nums.length+1];
		int currOdd = 0;
		prefix[0] = 1; 
		for (int i = 0; i < nums.length; i++) {
			if(nums[i]%2 == 1)
				currOdd++;
			
			if(currOdd >= k)
				count += prefix[currOdd - k];
			
			prefix[currOdd]++;
		//	count += map.getOrDefault(currOdd - k, 0);
		//	map.put(currOdd, map.getOrDefault(currOdd, 0) + 1);
			
		}

		return count;
		// return atMostKOdd(nums, k) - atMostKOdd(nums, k - 1);
	}

	
	// using two pointers is longer
	public static int atMostKOdd(int[] nums, int k) {
		int start = 0, n = nums.length;
		int countOdd = 0;
		int ans = 0;

		for (int i = 0; i < n; i++) {
			if (nums[i] % 2 == 1)
				countOdd++;

			while (countOdd > k) {
				if (nums[start] % 2 == 1)
					countOdd--;
				start++;
			}

			ans += i - start + 1;
		}

		return ans;
	}

}
