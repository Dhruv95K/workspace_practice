package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Kadane {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[n];
			String inputLine[] = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(inputLine[i]);
			}

			Kadane obj = new Kadane();

			System.out.println(obj.maxSubarraySum(arr, n));
		}
	}

	int maxSubarraySum(int arr[], int n) {

		// Your code here
		int curr_max = arr[0];
		int maxSoFar = arr[0];
		
		for(int i = 1;i<n;i++) {
			curr_max = Math.max(arr[i], curr_max+arr[i]);
			maxSoFar = Math.max(curr_max, maxSoFar);
		}
		return maxSoFar;
	}
}
