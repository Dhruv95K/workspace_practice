package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
90. Subsets II
Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

Note: The solution set must not contain duplicate subsets.

Example:

Input: [1,2,2]
Output:
[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/
public class SubsetsII {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		SubsetsII list = new SubsetsII();
		list.subsetsWithDup(arr);
		System.out.println(result);
	}

	static List<List<Integer>> result;

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		result = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		List<Integer> temp = new ArrayList<>();

		subsetsWithDup(nums, 0, temp);

		return result;
	}

	private void subsetsWithDup(int[] nums, int ind, List<Integer> temp) {

		if (temp.size()!= 0) {
			result.add(new ArrayList<>(temp));
		}

		for (int i = ind; i < nums.length; i++) {
			if(i > ind && nums[i] == nums[i-1])
				continue;
			temp.add(nums[i]);
			subsetsWithDup(nums, i + 1, temp);
			temp.remove(temp.size() - 1);
		}

		
	}

}
