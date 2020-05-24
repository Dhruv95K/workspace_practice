package dynamicprogramming;

import java.util.Scanner;

public class MaxSumWithoutNeighbours {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcases=sc.nextInt();
		while(testcases-->0)
		{
		    int sizeOfArray=sc.nextInt();
		    int arr[]=new int[sizeOfArray];
		    
		    for(int i=0;i<sizeOfArray;i++)
		    {
		        int x=sc.nextInt();
		        arr[i]=x;
		    }
		  
		    System.out.println(maximumSum(arr,sizeOfArray));
		    
		}
	}
	
		public static long maximumSum(int arr[], int n)
	    {
			int[] maxSum = new int[n];
			maxSum[0] = arr[0];
			maxSum[1] = Math.max(arr[0], arr[1]);
			for(int i=2;i<n;i++) {
				maxSum[i] = Math.max(arr[i],Math.max(maxSum[i-1], arr[i] + maxSum[i-2]));
			}
			
			return maxSum[n-1];
	    }

}
