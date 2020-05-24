package dynamicprogramming;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int p = sc.nextInt(); // Take size of both the strings as input
			int q = sc.nextInt();

			String s1 = sc.next(); // Take both the string as input
			String s2 = sc.next();

			LCS obj = new LCS();

			System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}

class LCS {

	// function to find LCS
	static int lcs(int p, int q, String s1, String s2) {
		int[][] lcs = new int[p + 1][q + 1];

		for (int i = 0; i <= p; i++) {
			for (int j = 0; j <= q; j++) {
				if (j == 0 || i == 0)
					continue;
				if (s1.charAt(i - 1) == s2.charAt(j - 1))
					lcs[i][j] = 1 + lcs[i - 1][j - 1];
				else {
					lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j - 1]);
				}
			}
		}

		ans = printLCS(lcs, s1, p, s2, q);
		System.out.println(ans);

		return lcs[p][q];
	}

	static Set<String> ans;

	private static HashSet<String> printLCS(int[][] lcs, String s1, int p, String s2, int q) {
		HashSet<String> curr = new HashSet<>();

		if (p <= 0 || q <= 0) {
			curr.add("");
		}

		else if (s1.charAt(p - 1) == s2.charAt(q - 1)) {
			for (String s : printLCS(lcs, s1, p - 1, s2, q - 1))
				curr.add(s + s1.charAt(p - 1));

		} else {
			if (lcs[p - 1][q] >= lcs[p][q - 1])
				curr.addAll(printLCS(lcs, s1, p - 1, s2, q));

			if (lcs[p][q - 1] >= lcs[p - 1][q])
				curr.addAll(printLCS(lcs, s1, p, s2, q - 1));
		}

		return curr;
	}

}
