package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumDifference {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(read.readLine());
		int m = Integer.parseInt(read.readLine());
		List<ArrayList<Integer>> C = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < n; i++) {
			String inputLine[] = read.readLine().trim().split(", ");
			for (int j = 0; j < m; j++) {
				C.get(i).add(Integer.parseInt(inputLine[j]));
			}
		}

		System.out.println(solve(C, n, m));

	}

	private static int solve(List<ArrayList<Integer>> C, int n, int m) {
		// TODO Auto-generated method stub
		for (ArrayList<Integer> a : C)
			Collections.sort(a);
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < n - 1; i++) {

			for (int j = 0; j < m; j++) {
				int n1 = bSearchGreaterThanEqualTo(C.get(i + 1), C.get(i).get(j));
				ans = Math.min(Math.abs(C.get(i+1).get(n1) - C.get(i).get(j)), ans);
				
				if(n1>0) {
					ans = Math.min(Math.abs(C.get(i+1).get(n1-1) - C.get(i).get(j)), ans);
				}
			}

		}
		return ans;
	}

	private static int bSearchGreaterThanEqualTo(ArrayList<Integer> arrayList, Integer integer) {
		// TODO Auto-generated method stub
		int lo = 0, hi = arrayList.size() - 1;
		int ans = 0;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (arrayList.get(mid) == integer)
				return mid;
			if (arrayList.get(mid) > integer) {
				hi = mid - 1;
				ans = mid;
			} else
				lo = mid + 1;

		}
		return ans;
	}

}
