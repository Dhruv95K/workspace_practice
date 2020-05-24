package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class PainterPartition {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		String inputLine[] = br.readLine().trim().split(", ");
		ArrayList<Integer> A = new ArrayList<>();
		int n = 7;
		for (int i = 0; i < n; i++) {
			// arr[i] = Integer.parseInt(inputLine[i]);
			A.add(Integer.parseInt(inputLine[i]));
		}

		System.out.println(paint(5,10, A));

	}

	public static int paint(int A, int B, ArrayList<Integer> C) {

		long lo = getMax(C);
		long hi = getSum(C);

		while (lo < hi) {
			long mid = lo + (hi - lo) / 2;

			if (getMaxPainters(C, mid) <= A)
				hi = mid;
			else
				lo = mid + 1;
		}
		long ans = ((lo % 10000003) * (B % 10000003)) % 10000003;
		return (int) ans;
	}

	public static long getMaxPainters(ArrayList<Integer> C, long mid) {
		long num = 1;
		long total = 0;

		for (int i : C) {
			total += i;

			if (total > mid) {
				num++;
				total = i;
			}
		}

		return num;
	}

	public static long getSum(ArrayList<Integer> C) {
		long sum = 0;
		for (int i : C)
			sum += i;

		return sum;
	}

	public static long getMax(ArrayList<Integer> C) {
		long max = 0;
		for (int i : C) {
			if (i > max)
				max = i;
		}

		return max;
	}

}
