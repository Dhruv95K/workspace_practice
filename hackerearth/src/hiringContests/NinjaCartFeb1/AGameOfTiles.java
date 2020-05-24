package hiringContests.NinjaCartFeb1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AGameOfTiles {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[][] arr = new int[n][3];
			String[] input;
			for (int i = 0; i < n; i++) {
				input = br.readLine().split(" ");
				for (int j = 0; j < 3; j++)
					arr[i][j] = Integer.parseInt(input[j]);
			}
			cache = new int[n];
			// Arrays.fill(cache, -1);
			System.out.println(maxScore(arr));
		}
	}

	private static int maxScore(int[][] arr) {
		int n = arr.length;
		cache[n-1] = Math.max(arr[n-1][0], Math.max(arr[n-1][1], arr[n-1][2]));
		if(n > 1)
			cache[n-2] = Math.max(arr[n-2][0] + cache[n-1], Math.max(arr[n-2][1], arr[n-2][2]));
		if(n>3)
			cache[n-3] = Math.max(arr[n-3][0] + cache[n-2], Math.max(arr[n-3][1] + cache[n-1], arr[n-3][2]));
		
		for(int i = n-4;i>=0;i--) {
			int first = arr[i][0] + cache[i+1];
			int second = arr[i][1] + cache[i+2];
			int third = arr[i][2] + cache[i+3];
			
			cache[i] = Math.max(first, Math.max(second, third));
		}
		
		return cache[0];
	}

	private static int[] cache;

	private static int maxScoreRecursive(int[][] arr, int index) {
		if (index >= arr.length)
			return 0;
		if (cache[index] != -1)
			return cache[index];
		cache[index] = Math.max(arr[index][0] + maxScoreRecursive(arr, index + 1), Math.max(
				arr[index][1] + maxScoreRecursive(arr, index + 2), arr[index][2] + maxScoreRecursive(arr, index + 2)));

		return cache[index];
	}

}
