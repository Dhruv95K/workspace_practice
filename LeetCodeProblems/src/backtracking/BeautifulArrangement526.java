package backtracking;
/*
526. Beautiful Arrangement
Suppose you have N integers from 1 to N. We define a beautiful arrangement as an array that is 
constructed by these N numbers successfully if one of the following is true for the ith position (1 <= i <= N) 
in this array:

The number at the ith position is divisible by i.
i is divisible by the number at the ith position.
 

Now given N, how many beautiful arrangements can you construct?

Example 1:
	Input: 2
	Output: 2
	Explanation: 
	
	The first beautiful arrangement is [1, 2]:	
	Number at the 1st position (i=1) is 1, and 1 is divisible by i (i=1).
	Number at the 2nd position (i=2) is 2, and 2 is divisible by i (i=2).
	The second beautiful arrangement is [2, 1]:
	Number at the 1st position (i=1) is 2, and 2 is divisible by i (i=1).
	Number at the 2nd position (i=2) is 1, and i (i=2) is divisible by 1.

Note:
 1. N is a positive integer and will not exceed 15.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BeautifulArrangement526 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(read.readLine());

		int ans = countArrangement(n);
		System.out.println(ans);
	}

	static int count;

	public static int countArrangement(int N) {
		count = 0;
		boolean[] visited = new boolean[N + 1];
		countArrangementBT(N, 1, visited);

		count = 0;
		int[] arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = i + 1;
		permute(arr, 0);
		return count;
	}
	
	//using permutations
	private static void permute(int[] arr, int l) {
		if (l == arr.length) {
			count++;
			return;
		}

		for (int i = l; i < arr.length; i++) {
			swap(arr, l, i);
			if (arr[l] % (l + 1) == 0 || (l + 1) % arr[l] == 0)
				permute(arr, l + 1);
			swap(arr, l, i);
		}

	}

	private static void swap(int[] arr, int l, int i) {
		int t = arr[l];
		arr[l] = arr[i];
		arr[i] = t;
	}

	// using Backtracking
	private static void countArrangementBT(int n, int pos, boolean[] visited) {
		if (pos > n) {
			count++;
			return;
		}

		for (int i = 1; i <= n; i++) {
			if (!visited[i] && (pos % i == 0 || i % pos == 0)) {
				visited[i] = true;
				countArrangementBT(n, pos + 1, visited);
				visited[i] = false;
			}
		}

	}

}
