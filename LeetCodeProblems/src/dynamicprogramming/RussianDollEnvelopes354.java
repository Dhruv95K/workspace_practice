package dynamicprogramming;
/*
354. Russian Doll Envelopes
You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another 
if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
What is the maximum number of envelopes can you Russian doll? (put one inside other)

Note:
	Rotation is not allowed.

Example:
	Input: [[5,4],[6,4],[6,7],[2,3]]
	Output: 3 
	Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class RussianDollEnvelopes354 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[][] a = new int[n][2];
		String[] input;

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(",");
			for (int j = 0; j < 2; j++)
				a[i][j] = Integer.parseInt(input[j]);
		}

		System.out.println(maxEnvelopes(a));
	}

	public static int maxEnvelopes(int[][] envelopes) {
		Arrays.sort(envelopes, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				long area1 = (long) o1[0] * (long) o1[1];
				long area2 = (long) o2[0] * (long) o2[1];

				return Long.compare(area2, area1);
			}
		});

		int n = envelopes.length;
		int[] maxEnvelopes = new int[n];
		int ans = 1;
		
		for (int i = 0; i < n; i++) {
			maxEnvelopes[i] = 1;
			for (int j = 0; j < i; j++) {
				if(envelopes[j][0] > envelopes[i][0] && envelopes[j][1] > envelopes[i][1])
					maxEnvelopes[i] = Math.max(maxEnvelopes[i], 1 + maxEnvelopes[j]);
			}
			ans = Math.max(ans, maxEnvelopes[i]);
		}

		return ans;
	}

}
