package twopointers;
/*
350. Intersection of Two Arrays II
Given two arrays, write a function to compute their intersection.

Example 1:
	Input: nums1 = [1,2,2,1], nums2 = [2,2]
	Output: [2,2]

Example 2:
	Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
	Output: [4,9]

Note:
	1. Each element in the result should appear as many times as it shows in both arrays.
	2. The result can be in any order.

Follow up:
	1. What if the given array is already sorted? How would you optimize your algorithm?
	2. What if nums1's size is small compared to nums2's size? Which algorithm is better?
	3, What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all 
	elements into the memory at once?
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArraysII350 {

	public static void main(String[] args) throws IOException {
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

		int[] ans = intersect(A, B);

	}

	public static int[] intersect(int[] nums1, int[] nums2) {
		HashMap<Integer, Integer> map1 = new HashMap<>();
		for (Integer n : nums1)
			map1.put(n, map1.getOrDefault(n, 0) + 1);

		List<Integer> list = new ArrayList<>();

		for (int i : nums2)
			if (map1.get(i) != null && map1.get(i) > 0) {
				list.add(i);
				map1.put(i, map1.get(i) - 1);
			}

		int[] ans = new int[list.size()];
		int idx = 0;
		for (int i : list)
			ans[idx++] = i;

		return ans;
	}

	public static int[] intersect2(int[] nums1, int[] nums2) {
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<Integer> list = new ArrayList<Integer>();

		int i = 0, j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j])
				i++;
			else if (nums1[i] > nums2[j])
				j++;
			else {
				list.add(nums1[i]);
				i++;
				j++;
			}
		}

		int[] ans = new int[list.size()];
		int ind = 0;
		for (int e : list)
			ans[ind++] = e;

		return ans;
	}
}
