package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
1337. The K Weakest Rows in a Matrix
Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians),
return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.

A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers 
in row j, or they have the same number of soldiers but i is less than j. Soldiers are always stand 
in the frontier of a row, that is, always ones may appear first and then zeros.

Example 1:
	Input: mat = 
	[[1,1,0,0,0],
	 [1,1,1,1,0],
	 [1,0,0,0,0],
	 [1,1,0,0,0],
	 [1,1,1,1,1]], 
	k = 3
	Output: [2,0,3]
	Explanation: 
	The number of soldiers for each row is: 
	row 0 -> 2 
	row 1 -> 4 
	row 2 -> 1 
	row 3 -> 2 
	row 4 -> 5 
	Rows ordered from the weakest to the strongest are [2,0,3,1,4]
			
Example 2:
	Input: mat = 
	[[1,0,0,0],
	 [1,1,1,1],
	 [1,0,0,0],
	 [1,0,0,0]], 
	k = 2
	Output: [0,2]
	Explanation: 
	The number of soldiers for each row is: 
	row 0 -> 1 
	row 1 -> 4 
	row 2 -> 1 
	row 3 -> 1 
	Rows ordered from the weakest to the strongest are [0,2,3,1]
 
Constraints:
	1. m == mat.length
	2. n == mat[i].length
	3. 2 <= n, m <= 100
	4. 1 <= k <= m
	5.matrix[i][j] is either 0 or 1.
*/
public class TheKWeakestRowsinaMatrix1337 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][m];
		String[] input;

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(",");
			for (int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(input[i]);
		}

		int k = Integer.parseInt(br.readLine());

		System.out.println(kWeakestRows(arr, k));
	}

	public static int[] kWeakestRows(int[][] mat, int k) {
		int[] ans = new int[k];
		pair[] rows = new pair[mat.length];
		
		for(int i = 0;i<mat.length;i++) {
			rows[i] = new pair(i, countOnes(mat[i]));
		}
		
		Arrays.sort(rows, new Comparator<pair>() {
			@Override
			public int compare(pair o1, pair o2) {
				return o1.count - o2.count;
			}
			
		});
		
		for(int i = 0;i<k;i++)
			ans[i] = rows[i].index;
		
		return ans;
	}

	public static int countOnes(int[] arr) {
		int l = 0, r = arr.length - 1;
		int ans = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (arr[mid] == 1 && (mid == arr.length - 1 || arr[mid + 1] == 0)) {
				ans = mid;
				break;
			}
			else if (arr[mid] == 1)
				l = mid + 1;
			else
				r = mid - 1;
		}

		if (ans == -1)
			return 0;

		return ans + 1;
	}

}

class pair {
	int index;
	int count;
	
	public pair(int index, int count) {
		this.index = index;
		this.count = count;
	}
	
	
}