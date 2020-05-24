package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1201. Ugly Number III
Write a program to find the n-th ugly number.
Ugly numbers are positive integers which are divisible by a or b or c.
 
Example 1:
	Input: n = 3, a = 2, b = 3, c = 5
	Output: 4
	Explanation: The ugly numbers are 2, 3, 4, 5, 6, 8, 9, 10... The 3rd is 4.
	
Example 2:
	Input: n = 4, a = 2, b = 3, c = 4
	Output: 6
	Explanation: The ugly numbers are 2, 3, 4, 6, 8, 9, 10, 12... The 4th is 6.
	
Example 3:
	Input: n = 5, a = 2, b = 11, c = 13
	Output: 10
	Explanation: The ugly numbers are 2, 4, 6, 8, 10, 11, 12, 13... The 5th is 10.
	
Example 4:
	Input: n = 1000000000, a = 2, b = 217983653, c = 336916467
	Output: 1999999984
 
Constraints:
	1. 1 <= n, a, b, c <= 10^9
	2. 1 <= a * b * c <= 10^18
	3. It's guaranteed that the result will be in range [1, 2 * 10^9]
*/
public class UglyNumberIII1201 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());

		System.out.println(nthUglyNumber(n, a, b, c));
	}

	public static int nthUglyNumber(int n, int a, int b, int c) {
		int l = 1, r = 2000000000;
		int ans = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			int count = divTermCount((long) mid, a, b, c);
			if (count >= n) {
				ans = mid;
				r = mid - 1;
			} else
				l = mid + 1;
		}
		
		return ans;
	}

	private static int divTermCount(long mid, long a, long b, long c) {

		return (int) (mid / a + mid / b + mid / c - mid / lcm(a, b) - mid / lcm(b, c) - mid / lcm(a, c)
				+ mid / lcm(a, lcm(b, c)));
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
