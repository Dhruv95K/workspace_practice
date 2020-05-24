package contest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubarrayOR {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		String[] input = br.readLine().split(", ");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(input[i]);

		System.out.println(solve(arr));

	}

	public static int solve(int[] A) {
		long n = (long) A.length;
		long total = n * (n + 1) / 2L;
		long mod = 1000000007L;
		long sum = 0L;

		for (int i = 0; i < 32; i++) {
			long currCount = 0L;
			long zeroSumSubarrays = 0L;
			int j = 0;
			while (j < n) {
				if ((A[j] & (1 << i)) == 0)
					currCount++;
				else {
					zeroSumSubarrays += currCount * (currCount + 1) / 2L;
					currCount = 0;
				}
				j++;
			}

			zeroSumSubarrays += currCount * (currCount + 1) / 2L;

			sum += ((long) Math.pow(2, i) * (total - zeroSumSubarrays)) % mod;
		}

		return (int) (sum % mod);
	}

}
