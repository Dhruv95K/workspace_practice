package twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*532. K-diff Pairs in an Array
Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array. 
Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their 
absolute difference is k.

Example 1:
	Input: [3, 1, 4, 1, 5], k = 2
	Output: 2
	Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
			Although we have two 1s in the input, we should only return the number of unique pairs.
					
Example 2:
	Input:[1, 2, 3, 4, 5], k = 1
	Output: 4
	Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
	
Example 3:
	Input: [1, 3, 1, 5, 4], k = 0
	Output: 1
	Explanation: There is one 0-diff pair in the array, (1, 1).
	
Note:
	1. The pairs (i, j) and (j, i) count as the same pair.
	2. The length of the array won't exceed 10,000.
	3. All the integers in the given input belong to the range: [-1e7, 1e7].
*/

public class KDiffPairsInAnArray532 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];

		String[] input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			A[i] = Integer.parseInt(input[i]);

		int k = Integer.parseInt(br.readLine());

		System.out.println(findPairs(A, k));
	}

	public static int findPairs(int[] nums, int k) {
		if (k < 0)
			return 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i : nums)
			map.put(i, map.getOrDefault(i, 0) + 1);

		int count = 0;

		for (int key : map.keySet()) {
			if (k == 0) {
				if (map.get(key) >= 2)
					count++;
			} else {
				if (map.containsKey(key + k))
					count++;
			}
		}

		return count;
	}

}
