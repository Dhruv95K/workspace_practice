package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumberOfSquarefulArrays {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			arr.add(Integer.parseInt(input[i]));
		}

		System.out.println(solve(arr));

	}
	
	public static int solve(ArrayList<Integer> A) {

		permute(A, 0, A.size() - 1);

		return count;
	}

	public static int count = 0;

	public static void permute(ArrayList<Integer> a, int l, int r) {
		if (l == r) {
			if(checkSquareFull(a))
				count++;
			return;
		}

		Set<Integer> set = new HashSet<>();

		for (int i = l; i <= r; i++) {
			if (set.contains(a.get(i))) {
				continue;
			}
			set.add(a.get(i));

			swap(a, i, l);
			permute(a, l + 1, r);
			swap(a, i, l);
		}
	}

	public static void swap(ArrayList<Integer> a, int i, int j) {
		int t = a.get(i);
		a.set(i, a.get(j));
		a.set(j, t);
	}

	public static boolean checkSquareFull(ArrayList<Integer> a) {
		for (int i = 0; i < a.size() - 1; i++) {
			double sq = Math.sqrt(a.get(i) + a.get(i + 1));
			if (sq != (int) sq)
				return false;
		}
		return true;
	}
}
