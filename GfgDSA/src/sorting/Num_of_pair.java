package sorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Num_of_pair {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int g = 0; g < t; g++) {
			String[] str = (br.readLine()).trim().split(" ");
			int n = Integer.parseInt(str[0]);
			int m = Integer.parseInt(str[1]);

			int[] x = new int[n];
			str = (br.readLine()).trim().split(" ");
			for (int i = 0; i < n; i++)
				x[i] = Integer.parseInt(str[i]);

			str = (br.readLine()).trim().split(" ");
			int[] y = new int[m];
			for (int i = 0; i < m; i++) {
				y[i] = Integer.parseInt(str[i]);

			}
			System.out.println(new Num_of_pair().countPairs(x, y, n, m));

		}
	}

	static long countPairs(int x[], int y[], int n, int m) {
		// your code here
		Arrays.sort(y);
		long count = 0L;

		int[] fr = new int[5];
		for (int i = 0; i < m; i++) {
			if (y[i] < 5)
				fr[y[i]]++;
		}

		for (int i = 0; i < n; i++) {
			
			if(x[i]==1)
				continue;
			int indx = bSearch(x[i], y, 0, m - 1);

			count += (long) (m - indx) + (long) fr[1];

			if (x[i] == 2)
				count = count - (long) fr[4] - (long) fr[3];
			
			if (x[i] == 3)
				count = count + (long) fr[2] ;
			
		}

		return count;
	}

	private static int bSearch(int x, int[] y, int l, int r) {
		// TODO Auto-generated method stub
		int ans = r+1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (y[mid] > x) {
				ans = mid;
				r = mid - 1;
			} else
				l = mid + 1;
		}
		return ans;
	}
}
