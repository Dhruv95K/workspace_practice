package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EquilibriumPoint {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			long arr[] = new long[n];
			String inputLine[] = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(inputLine[i]);
			}

			EquilibriumPoint obj = new EquilibriumPoint();

			System.out.println(obj.equilibriumPoint(arr, n));
		}
	}

	public static int equilibriumPoint(long arr[], int n) {

		// Your code here

		if (n == 1 || n == 2)
			return 1;

		long[] prefixSumFront = new long[n];
		long[] prefixSumBack = new long[n];
		prefixSumFront[0] = arr[0];
		prefixSumBack[n - 1] = arr[n - 1];
		for (int i = 1; i < n; i++) {
			prefixSumFront[i] = arr[i] + prefixSumFront[i - 1];
			prefixSumBack[n - i - 1] = arr[n - i - 1] + prefixSumBack[n - i];
		}

		for (int i = 1; i < n - 1; i++) {
			if (prefixSumFront[i - 1] == prefixSumBack[i + 1])
				return i + 1;
		}

		return -1;
	}

}
