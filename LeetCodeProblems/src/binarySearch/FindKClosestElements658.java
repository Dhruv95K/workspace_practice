package binarySearch;
/*
658. Find K Closest Elements
Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result
should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
	Input: [1,2,3,4,5], k=4, x=3
	Output: [1,2,3,4]
			
Example 2:
	Input: [1,2,3,4,5], k=4, x=-1
	Output: [1,2,3,4]

Note:
	1. The value k is positive and will always be smaller than the length of the sorted array.
	2. Length of the given array is positive and will not exceed 104
	3. Absolute value of elements in the array and x will not exceed 104

UPDATE (2017/9/19):
	The arr parameter had been changed to an array of integers (instead of a list of integers). 
	Please reload the code definition to get the latest changes.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindKClosestElements658 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		String[] input;
		input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(br.readLine());

		int k = Integer.parseInt(br.readLine());
		int x = Integer.parseInt(br.readLine());
		
		System.out.println(findClosestElements(a,k,x));
		
	}
	
	public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();
        
        int j = findGreater(arr,x);  
        int i = findSmaller(arr,x);
        
        if( i == -1 && j == -1){
            for(int t = 0;t<k;t++)
                ans.add(arr[t]);
            return ans;
        }
        
        if(j==0 || i == -1){
            for(int t = 0;t<k;t++)
                ans.add(arr[t]);
            return ans;
        }
        if(i==n-1 || j == -1){
            for(int t = n-k;t<n;t++)
                ans.add(arr[t]);
            return ans;
        }
        
        int count = j - i - 1;
        
        for(int c = 0;c<Math.min(count,k);c++){
            ans.add(x);
        }
        
        k -= count;
        
        while(i >= 0 && j < n){
            if(k==0)
                break;
            if(x - arr[i] <= arr[j]-x){
                ans.add(arr[i]);
                i--;
            }
            else{
                ans.add(arr[j]);
                j++;
            }
            k--;
        }
        
        while(k>0 && i>=0){
            ans.add(arr[i]);
            i--;k--;
        }
        
        while(k>0 && j<n){
            ans.add(arr[j]);
            j++;k--;
        }
        
        Collections.sort(ans);
        return ans;
    }
    
    public static int findGreater(int[] arr,int target){
        int l = 0,r = arr.length-1;
        int n = arr.length;
        int ans = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(arr[mid] > target){
                ans = mid;
                r = mid-1;
            }
            else
                l = mid+1;
        }
        
        return ans;
    }
    
    public static int findSmaller(int[] arr,int target){
        int l = 0,r = arr.length-1;
        int n = arr.length;
        int ans = -1;
        
        while(l<=r){
            int mid = l + (r-l)/2;
            if(arr[mid] >= target)
                r = mid-1;
            else{
                ans = mid;
                l = mid+1;
            }
        }
        
        return ans;
    }

}
