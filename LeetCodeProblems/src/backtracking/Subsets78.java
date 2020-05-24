package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
78. Subsets
Given a set of distinct integers, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:
	Input: nums = [1,2,3]
	Output:
	[
	  [3],
	  [1],
	  [2],
	  [1,2,3],
	  [1,3],
	  [2,3],
	  [1,2],
	  []
	]
*/
public class Subsets78 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		
	}
	
	static List<List<Integer>> result;
	public List<List<Integer>> subsets(int[] nums) {
		result = new ArrayList<List<Integer>>();
		
		List<Integer> temp = new ArrayList<>();
		
		subsets(nums,0,temp);
		
		return result;
	}
	private void subsets(int[] nums, int ind, List<Integer> temp) {
		
		if(ind == nums.length) {
			result.add(new ArrayList<>(temp));
			return;
		}
		
		temp.add(nums[ind]);
		subsets(nums,ind+1,temp);
		temp.remove(temp.size()-1);
		
		subsets(nums,ind+1,temp);
	}

}
