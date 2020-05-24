package CodeforcesRound634Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreeBlocksPalindrome {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			int[] arr = new int[n];
			String[] input = br.readLine().split(" ");
			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(input[i]);

			System.out.println(maxLength3Block(arr));
		}

	}

	private static int maxLength3Block(int[] arr) {
		int n = arr.length;
		int[][] prefix = new int[26][n + 1];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 26; j++)
				prefix[j][i + 1] = prefix[j][i];
			prefix[arr[i] - 1][i + 1] += 1;
		}

		int ans = 0;
		for (int i = 0; i < 26; i++)
			ans = Math.max(ans, prefix[i][n]);

		for (int l = 0; l < n; l++) {
			for (int r = l; r < n; r++) {
				int cntin = 0, cntout = 0;
				for (int c = 0; c < 26; c++) {
					cntin = Math.max(cntin, prefix[c][r + 1] - prefix[c][l]);
					cntout = Math.max(cntout, Math.min(prefix[c][l], prefix[c][n] - prefix[c][r + 1]));
				}
				ans = Math.max(ans, cntin + 2 * cntout);
			}
		}
		
		return ans;
	}

}
