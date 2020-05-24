package backtracking;
/*
47. Permutations II
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

Example:
	Input: [1,1,2]
	Output:
	[
	  [1,1,2],
	  [1,2,1],
	  [2,1,1]
	]
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PermutationsII {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

	}
	
	static List<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<List<Integer>>();

		permute(nums, 0, nums.length - 1);
		return result;
    }
    
    private void permute(int[] nums, int l, int r) {
		if (l == r) {
			List<Integer> temp = new ArrayList<Integer>();
			for(int i : nums)
				temp.add(i);
			result.add(temp);
			return;
		}
		
		Set<Integer> set = new HashSet<>();
		
		for (int i = l; i <= r; i++) {
			if(set.contains(nums[i]))
				continue;
			set.add(nums[i]);
			swap(nums, i, l);
			permute(nums, l + 1, r);
			swap(nums, i, l);
		}
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;
	}

}
