package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {
			int sizeOfArray = Integer.parseInt(read.readLine());
			int arr[] = new int[sizeOfArray];

			String st[] = read.readLine().trim().split("\\s+");
			for (int i = 0; i < sizeOfArray; i++)
				arr[i] = Integer.parseInt(st[i]);

			int x = Integer.parseInt(read.readLine());

			BinarySearch obj = new BinarySearch();

			System.out.println(obj.search(arr, sizeOfArray, x));
		}
	}
	
	static int search(int arr[], int n, int x)
    {
        
        // Your code here
	
        return binarySearch(arr,0,n-1,x);
        
    }
    
    public static int binarySearch(int[] arr,int l,int r,int key){
        int mid = -1;
        while(l<=r){
            
            mid = (l+r)/2;
            if(arr[mid]==key)
                return mid;
            
            if(key>arr[mid])
                l=mid+1;
            else 
                r=mid-1;
            
        }
        
        return -1;
    }

}
