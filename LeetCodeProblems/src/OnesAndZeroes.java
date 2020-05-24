import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*474. Ones and Zeroes
In the computer world, use restricted resource you have to generate maximum benefit is what we always want to pursue.
For now, suppose you are a dominator of m 0s and n 1s respectively. On the other hand, there is an array with strings 
consisting of only 0s and 1s.
Now your task is to find the maximum number of strings that you can form with given m 0s and n 1s. Each 0 and 1 can 
be used at most once.

Note:

	1. The given numbers of 0s and 1s will both not exceed 100
	2. The size of given string array won't exceed 600.

Example 1:													4,2
	Input: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
	Output: 4	
	Explanation: This are totally 4 strings can be formed by the using of 5 0s and 3 1s, which are ¡°10,¡±0001¡±,¡±1¡±,¡±0¡±
		 

Example 2:

	Input: Array = {"10", "0", "1"}, m = 1, n = 1
	Output: 2
	Explanation: You could form "10", but then you'd have nothing left. Better form "0" and "1".
*/
public class OnesAndZeroes {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] st = new String[n];
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < n; i++)
			st[i] = input[i];

		int m1 = Integer.parseInt(br.readLine());
		int m2 = Integer.parseInt(br.readLine());

		int ans = findMaxForm(st, m1, m2);

		System.out.println(ans);

	}

	static int[] count1;
	static int[] count0;
	static int res;
	static int[][][] dp;
	
	
	public static int findMaxForm(String[] strs, int m, int n) {
		int l = strs.length;
		count1 = new int[l];
		count0 = new int[l];
		dp = new int[l][m+1][n+1];
		res = 0;

		for (int i = 0; i < l; i++) {
			for (int j = 0; j < strs[i].length(); j++) {
				if (strs[i].charAt(j) == '1')
					count1[i]++;
				else
					count0[i]++;
			}
		}

		return findMaxFormBackTrack(strs, 0, m, n);

		// return res;
	}

	public static int findMaxFormBackTrack(String[] strs, int ind, int m, int n) {
		if (ind == strs.length)
			return 0;

		if (m < 0 || n < 0)
			return 0;

		if (m == 0 && n == 0)
			return 0;
		
		if(dp[ind][m][n] > 0)
			return dp[ind][m][n];
		
		int incl = 0, excl = 0;

		if (m >= count0[ind] && n >= count1[ind])
			incl = 1 + findMaxFormBackTrack(strs, ind + 1, m - count0[ind], n - count1[ind]);

		excl = findMaxFormBackTrack(strs, ind + 1, m, n);

		dp[ind][m][n] = Math.max(incl, excl);
		
		return dp[ind][m][n];

	}

}
