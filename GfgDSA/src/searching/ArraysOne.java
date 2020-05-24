package searching;

import java.util.Scanner;

public class ArraysOne {

	static int arr[] = new int[5000001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();

		while (t > 0) {

			int n = sc.nextInt();

			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			Ones obj = new Ones();
			System.out.println(obj.countOnes(n));
			t--;
		}
	}

}

class Ones {

	// Object of Arrays class to access array declared in Arrays class
	static ArraysOne obj = new ArraysOne();

	// Function to count number of ones in the binary array
	// n: size of array
	public static int countOnes(int n) {

		// Your code here
		int[] arr = obj.arr;
		int ind = findLastIndex(arr, 0, n - 1, n);
		return ind+1;
	}

	private static int findLastIndex(int[] arr, int l, int r, int n) {
		// TODO Auto-generated method stub
		int mid = 0;

		while (l <= r) {
			mid = (l + r) / 2;

			if (arr[mid] == 1 && (mid == n - 1 || arr[mid + 1] == 0))
				return mid;
			else if (arr[mid] == 1)
				l = mid + 1;
			else
				r = mid - 1;
		}
		return 0;
	}

}