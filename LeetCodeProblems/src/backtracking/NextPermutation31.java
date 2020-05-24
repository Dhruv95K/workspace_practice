package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 31. Next Permutation	
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 ¡ú 1,3,2
3,2,1 ¡ú 1,2,3
1,1,5 ¡ú 1,5,1
*/
public class NextPermutation31 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

	}

	public void nextPermutation(int[] nums) {
		int n = nums.length;
		int i = n - 2;

		while (i >= 0 && nums[i] >= nums[i + 1]) {
			i--;
		}

		if (i >= 0) {
			int j = findNextGreatest(nums, nums[i], i + 1);
			swap(nums, i, j);
		}

		reverse(nums, i + 1);
	}

	private int findNextGreatest(int[] nums, int key, int start) {
		int l = start,h = nums.length-1;
		int ans = -1;
		
		while(l<=h) {
			int mid = l + (h-l)/2;
			if(nums[mid] <= key)
				h--;
			else {
				ans = mid;
				l++;
			}
		}
		
		return ans;
	}

	private void reverse(int[] nums, int start) {	
		int l = start, h = nums.length-1;
		while(l<h) {
			swap(nums,l,h);
			l++;h--;
		}
	}

	private void swap(int[] nums, int i, int j) {
		int t = nums[i];
		nums[i] = nums[j];
		nums[j] = t;

	}

}
