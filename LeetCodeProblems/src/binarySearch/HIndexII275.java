package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
275. H-Index II
Given an array of citations sorted in ascending order (each citation is a non-negative integer) 
of a researcher, write a function to compute the researcher's h-index.

According to the definition of h-index on Wikipedia: "A scientist has index h if h of his/her "
+ "N papers have at least h citations each, and the other N − h papers have no more than h citations "
+ "each."

Example:
	Input: citations = [0,1,3,5,6]
	Output: 3 
	Explanation: [0,1,3,5,6] means the researcher has 5 papers in total and each of them had 
             received 0, 1, 3, 5, 6 citations respectively. 
             Since the researcher has 3 papers with at least 3 citations each and the remaining 
             two with no more than 3 citations each, her h-index is 3.
             
Note:
	1. If there are several possible values for h, the maximum one is taken as the h-index.

Follow up:
	This is a follow up problem to H-Index, where citations is now guaranteed to be sorted in 
	ascending order.
	Could you solve it in logarithmic time complexity?
*/
public class HIndexII275 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		String[] input;
		input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(br.readLine());

		System.out.println(hIndex(a));
	}

	public static int hIndex(int[] citations) {
		int n = citations.length;
		if (n == 0)
			return 0;
		int ans = -1;
		int l = 0, r = n - 1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (citations[mid] < n - mid)
				l = mid + 1;
			else {
				ans = citations[mid];
				r = mid - 1;
			}
		}

		return n - l;
	}
}
