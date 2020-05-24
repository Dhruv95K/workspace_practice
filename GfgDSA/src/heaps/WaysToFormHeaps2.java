package heaps;

import java.util.Arrays;

public class WaysToFormHeaps2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	long[] dp;
	/*
	 * dp[i] = number of max heaps for i integers with minimum repeated exactly 2
	 * times
	 */
	long[] dp1; /* dp[i] = number of max heaps for i distinct integers */
	long[][] nck; /* nck[i][j] = i choose j if i>=j else 0 */
	int[] log2; /* log2[i] = int(log base 2 of i) */
	final long MOD = 1000000007;

	public long choose(int n, int k) {
		if (k > n)
			return 0;
		if (n <= 1)
			return 1;
		if (k == 0)
			return 1;
		if (nck[n][k] != -1)
			return nck[n][k];
		long answer = choose(n - 1, k - 1) + choose(n - 1, k);
		answer %= MOD;
		nck[n][k] = answer;
		return answer;
	}

	public int getL(int n) {
		if (n == 1)
			return 0;
		int h = log2[n];
		int p = n - ((1 << (h)) - 1);
		int m = (1 << h);
		if (p >= (m / 2))
			return (1 << (h)) - 1;
		else
			return (1 << (h)) - 1 - ((m / 2) - p);
	}

	public int solve(int[] arr) {
		int n = arr.length;
		dp = new long[n + 1];
		dp1 = new long[n + 1];
		for (int i = 0; i <= n; i++) {
			dp[i] = -1;
			dp1[i] = -1;
		}
		nck = new long[n + 1][n + 1];
		for (int i = 0; i <= n; i++)
			for (int j = 0; j <= n; j++)
				nck[i][j] = -1;
		log2 = new int[n + 1];
		int currLogAnswer = -1;
		int currPower2 = 1;
		for (int i = 1; i <= n; i++) {
			if (currPower2 == i) {
				currLogAnswer++;
				currPower2 *= 2;
			}
			log2[i] = currLogAnswer;
		}
		Arrays.sort(arr);
		if (arr[n - 1] == arr[n - 2])
			return (int) getNumberOfMaxHeaps2(n);
		else
			return (int) getNumberOfMaxHeaps(n);
	}

	/* number of max heaps for i integers with minimum repeated exactly 2 times */
	public long getNumberOfMaxHeaps(int n) {
		if (n <= 2)
			return 1;
		if (dp[n] != -1)
			return dp[n];
		int L = getL(n);
		int R = n - 1 - L;
		long ans = 0;
		// If both side of the tree has the repeated number
		ans += ((choose(n - 3, L - 1) * getNumberOfMaxHeaps2(L)) % MOD * (getNumberOfMaxHeaps2(R))) % MOD;
		ans %= MOD;
		// If only left side has the repeated number
		ans += ((choose(n - 3, R) * getNumberOfMaxHeaps(L)) % MOD * (getNumberOfMaxHeaps2(R))) % MOD;
		ans %= MOD;
		// If only right side has the repeated number
		ans += ((choose(n - 3, L) * getNumberOfMaxHeaps2(L)) % MOD * (getNumberOfMaxHeaps(R))) % MOD;
		ans %= MOD;
		dp[n] = ans;
		return ans;
	}

	/* number of max heaps for n distinct integers */
	public long getNumberOfMaxHeaps2(int n) {
		if (n <= 1)
			return 1;
		if (dp1[n] != -1)
			return dp1[n];
		int L = getL(n);
		long ans = (choose(n - 1, L) * getNumberOfMaxHeaps2(L)) % MOD * (getNumberOfMaxHeaps2(n - 1 - L));
		ans %= MOD;
		dp1[n] = ans;
		return ans;
	}
}
