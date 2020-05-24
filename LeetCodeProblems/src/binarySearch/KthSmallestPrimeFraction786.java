package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
786. K-th Smallest Prime Fraction
A sorted list A contains 1, plus some number of primes.  Then, for every p < q in the list, we consider the fraction p/q.
What is the K-th smallest fraction considered?  Return your answer as an array of ints, where answer[0] = p and answer[1] = q.

Examples:
	Input: A = [1, 2, 3, 5], K = 3
	Output: [2, 5]
	Explanation:
	The fractions to be considered in sorted order are:
	1/5, 1/3, 2/5, 1/2, 3/5, 2/3.
	The third fraction is 2/5.

	Input: A = [1, 7], K = 1
	Output: [1, 7]
			
Note:
	1. A will have length between 2 and 2000.
	2. Each A[i] will be between 1 and 30000.
	3. K will be between 1 and A.length * (A.length - 1) / 2.
*/

public class KthSmallestPrimeFraction786 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		String[] input = br.readLine().split(",");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(input[i]);

		int k = Integer.parseInt(br.readLine());

		System.out.println(Arrays.toString(kthSmallestPrimeFractionWithHeap(arr, k)));

	}

	private static int[] countPairs(int[] A, double x) {
		int count = 0, n = A.length, p = 0, q = 0;
		double max = 0.0;
		for (int i = 0, j = 0; i < n; i++) {
			while (j < i && A[j] < A[i] * x)
				j++;
			if (j > 0) {
				double fraction = (double) A[j - 1] / (double) A[i];
				if (max < fraction) {
					max = fraction;
					p = A[j - 1];
					q = A[i];
				}
			}
			count += j;
		}
		return new int[] { count, p, q };
	}

	public int[] kthSmallestPrimeFraction(int[] A, int K) {
		int n = A.length, min = A[0], max = A[n - 1], p = 0, q = 0;
		double lo = (double) min / (double) max, hi = 1.0;
		while (lo < hi) {
			double mid = (lo + hi) / 2.0;
			int[] count = countPairs(A, mid);
			if (count[0] == K) {
				p = count[1];
				q = count[2];
				break;
			}
			if (count[0] < K)
				lo = mid;
			else
				hi = mid;
		}
		return new int[] { p, q };
	}

	// time limit exceeded
	public static int[] kthSmallestPrimeFractionWithHeap(int[] A, int K) {
		int n = A.length;
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				int s1 = A[o1[0]] * A[o2[1]];
				int s2 = A[o1[1]] * A[o2[0]];
				return s1 - s2;
			}
		});

		for (int i = 0; i < n - 1; i++) {
			pq.add(new int[] { i, n - 1 });
		}

		while (!pq.isEmpty()) {
			K--;
			if (K == 0)
				break;
			int[] t = pq.poll();
			t[1]--;
			if (t[1] > t[0])
				pq.add(t);
		}

		int[] ans = new int[2];
		ans[0] = A[pq.peek()[0]];
		ans[1] = A[pq.peek()[1]];
		return ans;
	}
}
