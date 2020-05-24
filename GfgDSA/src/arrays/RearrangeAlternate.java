package arrays;

import java.util.Scanner;

public class RearrangeAlternate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);

		int t = in.nextInt();

		while (t-- > 0) {
			int n = in.nextInt();
			int[] temp = new int[n];

			for (int i = 0; i < n; i++)
				temp[i] = in.nextInt();

			// StringBuffer sb = new StringBuffer();

			RearrangeAlternate obj = new RearrangeAlternate();

			obj.rearrange(temp, n);
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < n; i++)
				sb.append(temp[i] + " ");
			System.out.println(sb);
		}

	}

	public static void rearrange(int arr[], int n) {
		// Your code here
		for(int i=0;i<n-1;i+=2) {
			rotate(arr,i);
		}
		
	}

	private static void rotate(int[] arr,int i) {
		// TODO Auto-generated method stub
		int temp = arr[arr.length-1];
		for(int j=arr.length-1;j>i;j--) {
			arr[j]=arr[j-1];
		}
		arr[i]=temp;	
	}
}
