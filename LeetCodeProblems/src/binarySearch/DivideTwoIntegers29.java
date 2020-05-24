package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
29. Divide Two Integers
Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.

Return the quotient after dividing dividend by divisor.

The integer division should truncate toward zero.

Example 1:
	Input: dividend = 10, divisor = 3
	Output: 3

Example 2:
	Input: dividend = 7, divisor = -3
	Output: -2

Note:
	1. Both dividend and divisor will be 32-bit signed integers.
	2. The divisor will never be 0.
	3. Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: 
[−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division result overflows.
*/
public class DivideTwoIntegers29 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		System.out.println(divide(a, b));

	}

	public static int divide(int dividend, int divisor) {
		if (dividend == Integer.MIN_VALUE && divisor == -1)
			return Integer.MAX_VALUE;
		int a = Math.abs(dividend);
		int b = Math.abs(divisor);

		int res = 0;
		while (a - b >= 0) {
			int x = 0;
			while (a - (b << 1 << x) >= 0)
				x++;
			res += (1 << x);
			a -= (b << x);
		}

		if ((dividend >= 0 && divisor > 0) || (dividend < 0 && divisor < 0))
			return res;

		return 0 - res;
	}
}
