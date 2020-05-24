package searching;

import java.util.Scanner;

public class SubArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int s = sc.nextInt();
			int[] m = new int[n];
			for (int j = 0; j < n; j++) {
				m[j] = sc.nextInt();
			}

			SubArray obj = new SubArray();
			obj.subarraySum(n, s, m);
			System.out.println();
		}

	}

	static void subarraySum(int n, int s, int[] m) {

		int l = 0, r = 0;
		int sum = 0;

		while (r <= n) {

			while (sum > s && l < r) {
				sum = sum - m[l];
				l += 1;
			}

			if (sum == s) {
				System.out.print((l + 1) + " " + (r));
				return;
			}
						
			sum += m[r];
			r++;
		}

		if (sum == s) {
			System.out.print((l + 1) + " " + (r));
			return;
		}

		System.out.print(-1);

	}
}
