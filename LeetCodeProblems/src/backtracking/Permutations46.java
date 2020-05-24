package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*46. Permutations
Given a collection of distinct integers, return all possible permutations.

Example:
	Input: [1,2,3]
	Output:
	[
	  [1,2,3],
	  [1,3,2],
	  [2,1,3],
	  [2,3,1],
	  [3,1,2],
	  [3,2,1]
	]
*/
public class Permutations46 {

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

	public List<List<Integer>> permute(int[] nums) {
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
		
		for (int i = l; i <= r; i++) {
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
