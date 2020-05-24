package dynamicprogramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class OptimalGameStrategy {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			System.out.println(new solve().countMaximum(arr, n));
		}
	}
}

class solve {
	static long countMaximum(int arr[], int n) {
	//	cache = new HashMap<>();
		int[][] opt = new int[n][n];
		for(int l=1;l<=n;l++) {
			for(int i=0;i<=n-l;i++) {
				int j = i + l - 1;
				if(j==i)
					opt[i][j] = arr[i];
				else if(j==i+1)
					opt[i][j] = Math.max(arr[i],arr[j]);
				else {
					opt[i][j] = Math.max(arr[i] + Math.min(opt[i+2][j],opt[i+1][j-1]),
									arr[j] + Math.min(opt[i+1][j-1],opt[i][j-2]));
				}
			}
		}
		return opt[0][n-1];
	//	return maxcoinRecursive(arr, 0, n - 1);
		
	}

	static Map<String, Integer> cache;

	public static int maxcoinRecursive(int arr[], int l, int r) {

		if (l == r)
			return arr[l];
		if (r == l + 1)
			return Math.max(arr[l], arr[r]);

		String key = l + "|" + r;
		if (cache.get(key) != null)
			return cache.get(key);

		cache.put(key, Math.max(arr[l] + Math.min(maxcoinRecursive(arr, l + 1, r - 1), maxcoinRecursive(arr, l + 2, r)),
				arr[r] + Math.min(maxcoinRecursive(arr, l, r - 2), maxcoinRecursive(arr, l + 1, r - 1))));

		return cache.get(key);
	}
}