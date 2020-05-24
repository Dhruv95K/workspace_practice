package bitmanipulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AND {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			String inputLine[] = br.readLine().trim().split(" ");
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(inputLine[i]);
			}

			AND obj = new AND();

			System.out.println(obj.maxAND(arr, n));
		}
	}

	public static int maxAND(int arr[], int n) {
		int res = 0, count = 0;

		for (int i = 31; i >= 0; i--) {

			count = checkBit((res | (1 << i)), arr, n);
			if (count >= 2)
				res = res | (1 << i);
		}
		return res;
	}

	private static int checkBit(int pattern, int[] arr, int n) {
		int c = 0;
		for (int i = 0; i < n; i++) {
			if ((arr[i] & pattern) == pattern)
				c++;
		}
		return c;
	}
}
