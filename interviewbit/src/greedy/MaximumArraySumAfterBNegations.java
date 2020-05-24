package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MaximumArraySumAfterBNegations {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] inputLine = br.readLine().split(", ");
		ArrayList<Integer> arr = new ArrayList<>();

		for (int i = 0; i < 9; i++) {
			arr.add(Integer.parseInt(inputLine[i]));
		}

		int b = Integer.parseInt(br.readLine());

		int sum = maxArraySum(arr, b);
	}

	private static int maxArraySum(ArrayList<Integer> arr, int b) {
		int n = arr.size();
		ArrayList<Integer> neg = new ArrayList<Integer>();
		int min = Integer.MAX_VALUE;
		int sum = 0;
		for (int i = 0; i < n; i++) {
			if (arr.get(i) < 0)
				neg.add(arr.get(i));
			else {
				sum += arr.get(i);
				min = Math.min(min, arr.get(i));
			}
		}
		Collections.sort(neg);
		int m = neg.size();

		if (m == 0) {
			if (b % 2 == 1)
				sum -= 2 * min;
		} else {
			if (b > m) {
				b = b - m;
				for (int num : neg)
					sum += 0 - num;

				int t = 0 - neg.get(m - 1);
				if (t < min)
					min = t;

				if (b % 2 == 1)
					sum -= 2 * min;
			} else {
				for (int i = 0; i < b; i++) {
					sum += 0 - neg.get(i);
				}
				for (int i = b; i < m; i++) {
					sum +=  neg.get(i);
				}
			}
		}

		return sum;
	}

}
