package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sort012 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    new Sort012().segragate012(arr, n);
		    StringBuffer str = new StringBuffer();
		    for(int i=0; i<n; i++){
		        str.append(arr[i]+" ");
		    }
		    System.out.println(str);
		}
	}
	
	public static void segragate012(int A[], int n){
        // your code here
		int lo=0,mid=0,high=n-1;
		
		for(mid=0;mid<=high;) {
			if(A[mid]==0) {
				swap(A,lo,mid);
				lo++;
				mid++;
			}
			else if(A[mid]==2) {
				swap(A,mid,high);
				high--;
			}
			else
				mid++;
		}
    }

	private static void swap(int[] a, int i, int j) {
		// TODO Auto-generated method stub
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}

}
