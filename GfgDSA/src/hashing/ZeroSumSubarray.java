package hashing;

import java.util.HashMap;
import java.util.Scanner;

public class ZeroSumSubarray {

	public static void main(String[] args) {
		// code
		// code
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		while (t > 0) {
			int n = scan.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scan.nextInt();
			}

			t--;
			System.out.println(findsum(arr, n) == true ? "Yes" : "No");
		}
	}

	static boolean findsum(int arr[], int n) {
		// Your code here

		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

		int sum = 0;

		for (int i = 0; i < arr.length; i++) {

			sum += arr[i];

			if (arr[i] == 0 || sum == 0 || hM.get(sum) != null)
				return true;

			hM.put(sum, i);
		}

		return false;

		
	}
}
