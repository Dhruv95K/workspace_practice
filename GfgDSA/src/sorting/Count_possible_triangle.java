package sorting;

import java.util.Scanner;

public class Count_possible_triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			System.out.println(new Count_possible_triangle().findNumberOfTriangles(arr, n));
		}
	}
	
	static long findNumberOfTriangles(int arr[], int n)
    {
        // add your code here
		int l=0,r=0,count=0;
		for(int i=n-1;i>=1;i--) {
			l=0;
			r=i-1;
			while(l<r) {
				if(arr[l]+arr[r]>arr[i]) {
					count+=r-l;
					r--;
				}
				else {
					l++;
				}
			}
		}
		
		return count;
    }
}
