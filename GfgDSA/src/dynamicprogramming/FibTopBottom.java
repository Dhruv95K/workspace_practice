package dynamicprogramming;

import java.util.Scanner;

public class FibTopBottom {
	static long dp[] = new long[100];;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 1;
		while (testcases-- > 0) {
			int number = sc.nextInt();

			Geeks obj = new Geeks();
			System.out.println(obj.findNthFibonacci(number));

		}

	}

	// Complete this function
	public long findNthFibonacci(int number) {

		if (dp[number] > 0)
			return dp[number];

		if (number <= 1)
			return number;

		dp[number] = findNthFibonacci(number - 1) + findNthFibonacci(number - 2);

		return dp[number];
	}

}
