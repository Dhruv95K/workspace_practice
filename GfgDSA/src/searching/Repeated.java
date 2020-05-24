package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Repeated {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String l = br.readLine();
			String[] sarr = l.split(" ");
			int[] arr = new int[sarr.length];
			for (int i1 = 0; i1 < arr.length; i1++) {
				arr[i1] = Integer.parseInt(sarr[i1]);
			}

			Repeated obj = new Repeated();

			obj.twoRepeated(arr, n);
			System.out.println();

		}
	}

	static void twoRepeated(int arr[], int n) {

		// Your code here
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n + 2; i++) {
			if (arr[Math.abs(arr[i]) - 1] < 0)
				sb.append(Math.abs(arr[i]) + " ");
			else
				arr[Math.abs(arr[i]) - 1] = -arr[Math.abs(arr[i]) - 1];
		}
		// System.out.println(Arrays.toString(arr));
		System.out.print(sb);
	}

}
