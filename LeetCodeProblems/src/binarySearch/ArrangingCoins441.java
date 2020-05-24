package binarySearch;
/*
441. Arranging Coins
You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

Given n, find the total number of full staircase rows that can be formed.

n is a non-negative integer and fits within the range of a 32-bit signed integer.

Example 1:
	n = 5
	
	The coins can form the following rows:
	ก่
	ก่ ก่
	ก่ ก่

	Because the 3rd row is incomplete, we return 2.
			
Example 2:	
	n = 8
	
	The coins can form the following rows:
	ก่
	ก่ ก่
	ก่ ก่ ก่
	ก่ ก่
	
	Because the 4th row is incomplete, we return 3.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrangingCoins441 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		System.out.println(arrangeCoins(n));
	}

	private static int arrangeCoins(int n) {
		if (n == 0)
			return 0;

		long l = 1, r = n;
		long ans = -1;
		while (l <= r) {
			long mid = l + (r - l) / 2;
			long sum = mid * (mid + 1) / 2;

			if (sum <= n) {
				ans = mid;
				l = mid + 1;
			} else
				r = mid - 1;
		}

		return (int) ans;
	}

	public static int arrangeCoinsInEfficient(int n) {
		int steps = 0;
		int i = 1;
		int stairs = 0;

		while (stairs < n) {
			stairs += i;
			i++;
			steps++;
		}

		if (stairs == n)
			return steps;

		return steps - 1;
	}

}
