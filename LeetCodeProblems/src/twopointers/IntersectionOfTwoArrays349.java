package twopointers;
/*
349. Intersection of Two Arrays
Given two arrays, write a function to compute their intersection.

Example 1:
	Input: nums1 = [1,2,2,1], nums2 = [2,2]
	Output: [2]

Example 2:
	Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	Output: [9,4]

Note:
	1. Each element in the result must be unique.
	2. The result can be in any order.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays349 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];

		int m = Integer.parseInt(br.readLine());
		int[] B = new int[m];

		String[] input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			A[i] = Integer.parseInt(input[i]);

		input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			B[i] = Integer.parseInt(input[i]);

		int[] ans = intersection(A, B);

	}

	public static int[] intersection(int[] nums1, int[] nums2) {
		HashSet<Integer> set1 = new HashSet<Integer>();
		for (Integer n : nums1)
			set1.add(n);
		
		HashSet<Integer> set2 = new HashSet<Integer>();
		
		for(int i : nums2)
			if(set1.contains(i))
				set2.add(i);
		
		int[] ans = new int[set2.size()];
		int idx = 0;
		for(int i : set2)
			ans[idx++] = i;
		
		return ans;
	}
	 
     public static int[] intersectionIterative(int[] nums1, int[] nums2) {
    	 Set<Integer> set = new HashSet<>();
         Arrays.sort(nums1);
         Arrays.sort(nums2);
         int i = 0;
         int j = 0;
         while (i < nums1.length && j < nums2.length) {
             if (nums1[i] < nums2[j]) {
                 i++;
             } else if (nums1[i] > nums2[j]) {
                 j++;
             } else {
                 set.add(nums1[i]);
                 i++;
                 j++;
             }
         }
         int[] result = new int[set.size()];
         int k = 0;
         for (Integer num : set) {
             result[k++] = num;
         }
         return result;
 	}
}
