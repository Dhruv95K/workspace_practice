package binarySearch;
/*
483. Smallest Good Base
For an integer n, we call k>=2 a good base of n, if all digits of n base k are 1.

Now given a string representing n, you should return the smallest good base of n in string format.

Example 1:
	Input: "13"
	Output: "3"
	Explanation: 13 base 3 is 111.
 

Example 2:
	Input: "4681"
	Output: "8"
	Explanation: 4681 base 8 is 11111.


Example 3:

	Input: "1000000000000000000"
	Output: "999999999999999999"
	Explanation: 1000000000000000000 base 999999999999999999 is 11.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestGoodBase483 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		System.out.println(smallestGoodBase(s));
	}

	public static String smallestGoodBase(String n) {
		long num = Long.parseLong(n);

		// calculate lower and upper bounds of number of 1s -> m
		// https://leetcode.com/problems/smallest-good-base/discuss/96591/Java-O((logn)2)-binary-search-solution

		for (int m = (int) (Math.log(num + 1) / Math.log(2)); m > 2; m--) {
			// calculate lower and upper bounds good base -> k
			long l = (long) (Math.pow(num + 1, 1.0 / m));
			long r = (long) (Math.pow(num, 1.0 / (m - 1)));

			while (l <= r) {
				long k = l + (r - l) / 2;
				long f = 0L;
				for (int i = 0; i < m; i++)
					f = f * k + 1;
				if (f == num)
					return "" + k;
				else if (f > num)
					r = k - 1;
				else
					l = k + 1;
			}

		}

		return "" + (num - 1);

	}

}
