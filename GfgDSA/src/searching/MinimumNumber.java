package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumNumber {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {
			long n = Long.parseLong(read.readLine());
			String st[] = read.readLine().trim().split("\\s+");

			int arr[] = new int[(int) n];

			for (long i = 0; i < n; i++)
				arr[(int) i] = Integer.parseInt(st[(int) i]);

			System.out.println(new MinimumNumber().minNumber(arr, 0, n - 1));

		}
	}

	static long minNumber(int arr[], long low, long high) {

		// Your code here
		int mid = 0;
		while (low <= high) {
			mid = (int) (low + high) / 2;

			if((mid==0||arr[mid]<arr[mid-1])&&(mid==high||arr[mid]<arr[mid+1]))
				return arr[mid];
			
			if(arr[mid]<arr[mid-1])
				high=mid-1;
			else 
				low=mid+1;
				
		}
		return -1L;
	}

}
