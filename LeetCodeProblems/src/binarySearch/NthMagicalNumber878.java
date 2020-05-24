package binarySearch;
/*
878. Nth Magical Number
A positive integer is magical if it is divisible by either A or B.

Return the N-th magical number.  Since the answer may be very large, return it modulo 10^9 + 7.
 

Example 1:
	Input: N = 1, A = 2, B = 3
	Output: 2
	
Example 2:
	Input: N = 4, A = 2, B = 3
	Output: 6
	
Example 3:
	Input: N = 5, A = 2, B = 4
	Output: 10
	
Example 4:
	Input: N = 3, A = 6, B = 4
	Output: 8
 
Note:
	1. 1 <= N <= 10^9
	2. 2 <= A <= 40000
	3. 2 <= B <= 40000
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NthMagicalNumber878 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		System.out.println(nthMagicalNumber(n, a, b));
	}

	public static int nthMagicalNumber(int N, int A, int B) {
		long mod = 1000000007L;
		long l = 1, r = Long.MAX_VALUE;
		long ans = -1;

		while (l <= r) {
			long mid = l + (r - l) / 2;
			long count = divTermCount(mid, A, B);
			if (count >= N) {
				ans = mid;
				r = mid - 1;
			} else
				l = mid + 1;
		}

		return (int) (ans % mod);
	}

	private static long divTermCount(long mid, long a, long b) {

		return (mid / a + mid / b - mid / lcm(a, b));
	}

	private static long lcm(long a, long b) {

		return (a * b) / gcd(a, b);
	}

	private static long gcd(long a, long b) {
		if (b > a)
			return gcd(b, a);
		if (b == 0)
			return a;

		return gcd(b, a % b);
	}

}
