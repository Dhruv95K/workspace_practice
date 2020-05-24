import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
594. Longest Harmonious Subsequence
We define a harmounious array as an array where the difference between its maximum value and its minimum value is exactly 1.
Now, given an integer array, you need to find the length of its longest harmonious subsequence among all its possible 
subsequences.

Example 1:
	Input: [1,3,2,2,5,2,3,7]
	Output: 5
	Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 

Note: The length of the input array will not exceed 20,000.

*/

public class LongestHarmoniousSubsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
		int ans = findLHS(arr);
		
	}

	public static int findLHS(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		int res = 0;
		
		for(int i=0;i<nums.length;i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
			
			if(map.containsKey(nums[i] + 1))
				res = Math.max(res, map.get(nums[i]) + map.get(nums[i] + 1));
			
			/*if(map.containsKey(nums[i] - 1))
				res = Math.max(res, map.get(nums[i]) + map.get(nums[i] - 1));*/
		}
		
		return res;
	}
	
	public static int findLHSTwoLoops(int[] nums) {
		Map<Integer,Integer> map = new HashMap<>();
		int res = 0;
		
		for(int i : nums)
			map.put(i, map.getOrDefault(i, 0) + 1);
		
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i] + 1))
				res = Math.max(res, map.get(nums[i]) + map.get(nums[i] + 1));
		}
		
		return res;
	}

}
