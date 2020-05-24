package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FloorSearch {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {
			String a[] = read.readLine().trim().split("\\s+");
			int n = Integer.parseInt(a[0]);
			long x = Long.parseLong(a[(int) 1]);
			String st[] = read.readLine().trim().split("\\s+");

			long arr[] = new long[n];
			for (int i = 0; i < n; i++) {
				arr[i] = Long.parseLong(st[i]);
			}

			System.out.println(new FloorSearch().findFloor(arr, 0, n - 1, x));

		}
	}

	static int findFloor(long arr[], int left, int right, long x) {
		int mid = 0;
		int ans = 0;
		while (left <= right) {

			mid = (left + right) / 2;
			if (arr[mid] == x)
				return mid;
			else if (arr[mid] < x) {
				ans = mid;
				left = mid + 1;
			} else
				right = mid - 1;
		}
		
		if(arr[ans]>x)
			return -1;
		else
			return ans;
	}

}
