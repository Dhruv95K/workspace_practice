package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trap {

	public static void main(String[] args) throws IOException {
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

			Trap obj = new Trap();

			System.out.println(obj.trappingWater(arr, n));
		}
	}

	static int trappingWater(int arr[], int n) {

		// Your code here
		int leftMax[] = new int[n];
		int rightMax[] = new int[n];
		int rain = 0;
		
		int lmax = arr[0];
		int rmax = arr[n-1];
		for(int i=1;i<=n-2;i++) {
			if(arr[i]>lmax)
				lmax=arr[i];
			
			leftMax[i]=lmax;
			
			if(arr[n-i-1]>rmax)
				rmax=arr[n-i-1];	
			
			rightMax[n-i-1]=rmax;
		}
		
		for(int i=1;i<=n-2;i++) {
			rain+=Math.min(rightMax[i], leftMax[i])-arr[i];
		}
		
		return rain;
	}

}
