package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
33. Search in Rotated Sorted Array
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of O(log n).

Example 1:
	Input: nums = [4,5,6,7,0,1,2], target = 0
	Output: 4

Example 2:
	Input: nums = [4,5,6,7,0,1,2], target = 3
	Output: -1
*/

public class SearchInRotatedSortedArray33 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] arr = new int[n];
		String[] input = br.readLine().split(","); 
		for(int i=0;i<n;i++)
			arr[i] = Integer.parseInt(input[i]);
		
		int target = Integer.parseInt(br.readLine());
		
		System.out.println(search(arr,target));

	}
	
	public static int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        if(pivot == -1)
            return binarySearch(nums,0,nums.length-1,target);
        
        if(nums[pivot] == target)
            return pivot;
        
        if(target >= nums[0])
            return binarySearch(nums,0,pivot,target);
        else 
            return binarySearch(nums,pivot+1,nums.length-1,target);
        
    //    return -1;
        
    }
    
    public static int findPivot(int[] nums){
        int l = 0,r = nums.length-1;
        
        while(l <= r){
            int mid = l + (r-l)/2;
            if(mid > 0 && nums[mid-1] > nums[mid])
                return mid-1;
            if(mid < nums.length-1 && nums[mid] > nums[mid+1])
                return mid;
            if(nums[l] > nums[mid])
                r = mid-1;
            else
                l = mid+1;
        }
        
        return -1;
    }
    
    public static int binarySearch(int[] nums,int a,int b,int key){
	    
	    if(a>b)
	        return -1;
	        
	    int mid = a + (b-a)/2;
	    if(nums[mid] == key)
	        return mid;
	    else if(nums[mid]<key)
	        return binarySearch(nums,mid+1,b,key);
	    else
	        return binarySearch(nums,a,mid-1,key);
	    
	}

}
