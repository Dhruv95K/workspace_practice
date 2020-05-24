package CodeforcesRound636Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class AlternatingSubsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];

			String[] input = br.readLine().split(" ");

			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(input[i]);

			System.out.println(maxSumALtSubsq(arr));
		}
	}

	private static long maxSumALtSubsq(int[] arr) {
		long maxSum = 0L;
		int currMax = Integer.MIN_VALUE;
		boolean sign = arr[0] > 0;
		
		for(int i = 0;i<arr.length;i++) {
			if(check(arr[i],sign)) {
				currMax = Math.max(currMax,arr[i]);
			}
			else {
				maxSum += currMax;
				currMax = arr[i];
				sign = !sign;
			}
		}
		
		maxSum += currMax;
		
		return maxSum;
	}

	private static boolean check(int x, boolean sign) {
		if(sign)
			return x > 0;
			
		return x < 0;
	}

	//inefficient
	private static long maxSumALtSubsq2(int[] arr) {
		int n = arr.length;
		int maxL = 0;
		long maxSum = Long.MIN_VALUE;

		int[] l = new int[n];
		long[] sum = new long[n];
		Arrays.fill(sum, Integer.MIN_VALUE);

		for (int i = 0; i < n; i++) {
			l[i] = 1;
			sum[i] = Math.max(sum[i], arr[i]);
			for (int j = 0; j < i; j++) {
				if ((arr[j] > 0 && arr[i] < 0) || (arr[j] < 0 && arr[i] > 0)) {
					if (1 + l[j] > l[i]) {
						l[i] = 1 + l[j];
						sum[i] = (long) arr[i] + sum[j];
					} else if (1 + l[j] == l[i])
						sum[i] = Math.max(sum[i], (long) arr[i] + sum[j]);
				}
			}
			if (l[i] > maxL) {
				maxL = l[i];
				maxSum = sum[i];
			}

			if (l[i] == maxL)
				maxSum = Math.max(maxSum, sum[i]);
		}

//		for(int i = 0;i<n;i++)
//			if(l[i] == maxL)
//				maxSum = Math.max(sum[i],maxSum);

		return maxSum;
	}

}
