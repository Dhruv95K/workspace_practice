package twopointers;
/*
992. Subarrays with K Different Integers
Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good if the number 
of different integers in that subarray is exactly K.

(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)

Return the number of good subarrays of A.

Example 1:
	Input: A = [1,2,1,2,3], K = 2
	Output: 7
	Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].

Example 2:
	Input: A = [1,2,1,3,4], K = 3
	Output: 3
	Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 
Note:
	1. 1 <= A.length <= 20000
	2. 1 <= A[i] <= A.length
	3. 1 <= K <= A.length
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SubarraysWithKDifferentIntegers992 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		String[] input = br.readLine().split(",");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int k = Integer.parseInt(br.readLine());

		System.out.println(subarraysWithKDistinct(arr, k));

	}

	public static int subarraysWithKDistinct(int[] A, int K) {
		return subarraysWithAtMostKDistinct(A, K) - subarraysWithAtMostKDistinct(A, K-1);
	}

	public static int subarraysWithAtMostKDistinct(int[] A, int K) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = A.length;
		int distinct = 0, start = 0;
		int ans = 0;

		for (int i = 0; i < n; i++) {
			map.put(A[i], map.getOrDefault(A[i], 0) + 1);
			if (map.get(A[i]) == 1)
				distinct++;

			while (distinct > K && start <= i) {
				map.put(A[start], map.get(A[start]) - 1);
				if (map.get(A[start]) == 0)
					distinct--;
				start++;
			}

			ans += i - start + 1;
		}
		
		return ans;
	}

}
