package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
153. Find Minimum in Rotated Sorted Array
Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
Find the minimum element.
You may assume no duplicate exists in the array.

Example 1:
	Input: [3,4,5,1,2] 
	Output: 1

Example 2:
	Input: [4,5,6,7,0,1,2]
	Output: 0
*/
public class FindMinimumInRotatedSortedArray153 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] a = new int[n];
		String[] input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			a[i] = Integer.parseInt(input[i]);

		
		System.out.println(findMin(a));
	}
	
	public static int findMin(int[] nums) {
        int pivot = findPivot(nums);
        if(pivot == -1)
            return nums[0];
        
        
        return nums[pivot+1];
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

}
