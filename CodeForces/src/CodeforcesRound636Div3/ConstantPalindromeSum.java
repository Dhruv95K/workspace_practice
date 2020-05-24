package CodeforcesRound636Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class ConstantPalindromeSum {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String[] input = br.readLine().split(" ");

			int n = Integer.parseInt(input[0]);
			int k = Integer.parseInt(input[1]);

			int[] arr = new int[n];

			input = br.readLine().split(" ");

			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(input[i]);

			System.out.println(constantPalSum(arr, k));
		}

	}

	private static int constantPalSum(int[] arr, int k) {
		int n = arr.length;
		Map<Integer, Integer> count = new HashMap<>();
		int[] pref = new int[2 * k + 2];

		for (int i = 0; i < n / 2; i++) {
			int sum = arr[i] + arr[n - i - 1];
			count.put(sum, count.getOrDefault(sum, 0) + 1);
		}

		for (int i = 0; i < n / 2; i++) {
			int min = Math.min(arr[i], arr[n - i - 1]);
			int max = Math.max(arr[i], arr[n - i - 1]);

			int lowerLim = min + 1;
			int upperLim = max + k + 1;

			pref[lowerLim] += 1;
			pref[upperLim] -= 1;
		}

		for (int i = 1; i <= 2 * k; i++)
			pref[i] += pref[i - 1];

		int minChanges = Integer.MAX_VALUE;

		for (int i = 2; i <= 2 * k; i++) {
			minChanges = Math.min(minChanges, pref[i] - count.getOrDefault(i, 0) + 2 * (n / 2 - pref[i]));
		}

		return minChanges;
	}

}
