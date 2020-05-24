package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wave {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());// taking size of array
			int arr[] = new int[n]; // declaring array of size n
			String inputLine[] = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(inputLine[i]); // input elements of array
			}

			Wave obj = new Wave();

			obj.convertToWave(arr, n);

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < n; i++)
				sb.append(arr[i] + " ");

			System.out.println(sb); // print array
		}
	}

	public static void convertToWave(int arr[], int n) {

		// Your code here
		for(int i=0;i<n-1;i+=2) {
			if(arr[i]<arr[i+1])
				swap(arr,i,i+1);
		}
		
		for(int i=1;i<n-1;i+=2) {
			if(arr[i]>arr[i+1])
				swap(arr,i,i+1);
		}
	}

	private static void swap(int[] arr,int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}

}
