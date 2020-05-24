package backtracking;
/*
996. Number of Squareful Arrays
Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements, 
their sum is a perfect square.

Return the number of permutations of A that are squareful.  Two permutations A1 and A2 differ if and only 
if there is some index i such that A1[i] != A2[i].
 
Example 1:	
	Input: [1,17,8]
	Output: 2
	Explanation: 
	[1,8,17] and [17,8,1] are the valid permutations.

Example 2:
	Input: [2,2,2]
	Output: 1
 
Note:
	1. 1 <= A.length <= 12
	2. 0 <= A[i] <= 1e9
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NumberOfSquarefulArrays996 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(input[i]);

		System.out.println(numSquarefulPerms(arr));

	}

	public static int numSquarefulPerms(int[] A) {
		Map<Integer, Integer> count = new HashMap<>();
		Map<Integer, ArrayList<Integer>> squareSums = new HashMap<>();

		for (int key : A)
			count.put(key, count.getOrDefault(key, 0) + 1);

		for (int key : count.keySet())
			squareSums.put(key, new ArrayList<>());

		for (int a : count.keySet()) {
			for (int b : count.keySet()) {
				if (Math.sqrt(a + b) == (int) Math.sqrt(a + b))
					squareSums.get(a).add(b);
			}
		}
		
		int ans = 0;
		for (int key : count.keySet())
			ans += dfs(key, A.length - 1, count, squareSums);

		return ans;
	}

	private static int dfs(int key, int toDo, Map<Integer, Integer> count,
			Map<Integer, ArrayList<Integer>> squareSums) {
		if (toDo == 0)
			return 1;

		int ans = 0;
		count.put(key, count.get(key) - 1);
		for(int y : squareSums.get(key)) {
			if(count.get(y) > 0)
				ans += dfs(y,toDo-1,count,squareSums);
		}
		
		count.put(key, count.get(key) + 1);
		return ans;
	}

}
