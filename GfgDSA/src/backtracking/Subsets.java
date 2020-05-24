package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Subsets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCases = sc.nextInt();
		for (int t = 0; t < testCases; t++) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			System.out.print("()");
			new solve().printAllSubsets(arr, n);
			System.out.println();
		}
	}

}

class solve {
	static ArrayList<String> res;
	static ArrayList<Integer> temp;

	public static void printAllSubsets(int arr[], int n) {
		res = new ArrayList<>();
		temp = new ArrayList<>();
		findAllSubsets(arr, 0);
		// Collections.sort(res);

		for (String s : res)
			System.out.print(s);
	}

	public static void findAllSubsets(int arr[], int ind) {

		if (temp.size() != 0)
			printSubset(temp);

		for (int i = ind; i < arr.length; i++) {
			if (i > ind && arr[i] == arr[i - 1])
				continue;
			temp.add(arr[i]);
			findAllSubsets(arr, i + 1);
			temp.remove(temp.size() - 1);
		}
	}

	private static void printSubset(ArrayList<Integer> temp) {
		String s = "(";
		for (int i : temp)
			s = s.concat(i + " ");

		s = s.trim();
		s = s.concat(")");

		res.add(s);
		// System.out.print(s);
	}
}