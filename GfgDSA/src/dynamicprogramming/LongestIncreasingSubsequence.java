package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
	    int t=in.nextInt();
	    while(t-- > 0)
	    {
	        int n=in.nextInt();
	        int arr[]=new int[n];
	        for(int i = 0;i<n;i++){
	            arr[i] = in.nextInt();
	        }
	        
	        LongestSubsequence obj = new LongestSubsequence();
	        
	        System.out.println(obj.longestSubsequenceNlogN(n, arr));
	                
	    }	
	}

}

class LongestSubsequence{
    
    long longestSubsequence(int n, int arr[]){
        
        int[] lis = new int[n];
        int max = Integer.MIN_VALUE;
        lis[0] = 1;
        
        for(int i=1;i<n;i++) {
        	lis[i] = 1;
        	for(int j=0;j<i;j++) {
        		if(arr[i]>arr[j])
        			lis[i] = Math.max(lis[i], 1+lis[j]);
        	}
        	max = Math.max(max, lis[i]);
        }
        
        return max;
    }
    
    long longestSubsequenceNlogN(int n, int arr[]){
        
        int[] lis = new int[n];
        int max = Integer.MIN_VALUE;
        int l =0;
        lis[0] = arr[0];
        l++;
        
        for(int i=1;i<n;i++) {
        	if(arr[i] <= lis[0])
        		lis[0] = arr[i];
        	else if(arr[i] > lis[l-1])
        		lis[l++] = arr[i];
        	else {
        		int ind = bsearch(lis,0,l-1,arr[i]);
        		lis[ind] = arr[i];
        	}
        }
        
        return l;
    }

	private int bsearch(int[] lis, int l, int r, int key) {
		int ans = -1;
		int mid = 0;
		
		while(l<=r) {
			mid = l + (r-l)/2;
			if(lis[mid] < key)
				l = mid + 1;
			else {
				ans = mid;
				r = mid - 1;
			}
		}
		return ans;
	}
    
}

