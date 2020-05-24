package heaps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class WaysToFormHeaps {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		System.out.println(solve(t));
	}

	static long[][] nCl = new long[200][200];
	static long[] waysHeap = new long[200];
	static long mod = 1000000007L;
	static int[] log2;

	public static int solve(int A) {
		Arrays.fill(waysHeap, -1L);
		for(long[] arr : nCl)
			Arrays.fill(arr, -1L);
		
		log2 = new int[A + 1];
		int currLogAnswer = -1;
		int currPower2 = 1;
		for (int i = 1; i <= A; i++) {
			if (currPower2 == i) {
				currLogAnswer++;
				currPower2 *= 2;
			}
			log2[i] = currLogAnswer;
		}

		return (int) numberOfMaxHeaps(A);
	}

	public static int getLeftNodeCount(int n) {
		if (n == 1)
			return 0;

		int h = log2[n];

		int MaxLeftSubtreeCount = (1 << h) - 1;
		int lastLevelNodeCount = n - ((1 << h) - 1);
		int maxLastLevel = (1 << h);

		if (lastLevelNodeCount >= (maxLastLevel / 2))
			return MaxLeftSubtreeCount;
		else
			return MaxLeftSubtreeCount - ((maxLastLevel / 2) - lastLevelNodeCount);
	}

	public static long chooseLeft(int n, int l) {
		if (l > n)
			return 0;
		if (n <= 1)
			return 1;
		if (l == 0)
			return 1;

		if (nCl[n][l] != -1)
			return nCl[n][l];

		long answer = chooseLeft(n - 1, l - 1) + chooseLeft(n - 1, l);
		answer %= mod;
		nCl[n][l] = answer;

		return answer;
	}

	public static long numberOfMaxHeaps(int n) {
		if (n <= 1)
			return 1;

		if (waysHeap[n] != -1)
			return waysHeap[n];

		int left = getLeftNodeCount(n);
		long choose = chooseLeft(n - 1, left);

		long ans = (choose * numberOfMaxHeaps(left)) % mod * (numberOfMaxHeaps(n - 1 - left));
		ans %= mod;
		waysHeap[n] = ans;
		return ans;
	}

}
