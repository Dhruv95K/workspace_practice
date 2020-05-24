package twopointers;
/*
167. Two Sum II - Input array is sorted
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up 
to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must 
be less than index2.

Note:
	1. Your returned answers (both index1 and index2) are not zero-based.
	2. You may assume that each input would have exactly one solution and you may not use the same element twice.
	
Example:
	Input: numbers = [2,7,11,15], target = 9
	Output: [1,2]
	Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TwoSumIIInputArrayIsSorted167 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];

		String[] input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			A[i] = Integer.parseInt(input[i]);

		int k = Integer.parseInt(br.readLine());
		
		int[] ans = twoSum(A,k);

	}

	public static int[] twoSum(int[] numbers, int target) {
		int[] ans = new int[2];
		int i =0,j = numbers.length-1;
		
		while(i < j) {
			if(numbers[i] + numbers[j] < target)
				i++;
			else if(numbers[i] + numbers[j] > target)
				j--;
			else {
				ans[0] = i +1;
				ans[1] = j+1;
				return ans;
			}
		}
		
		return ans;
		
	}

}
