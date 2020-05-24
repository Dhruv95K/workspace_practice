package twopointers;
/*
42. Trapping Rain Water
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water 
it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water
(blue section) are being trapped. Thanks Marcos for contributing this image!

Example:
	Input: [0,1,0,2,1,0,1,3,2,1,2,1]
	Output: 6
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TrappingRainWater42 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		String[] input = br.readLine().split(",");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		System.out.println(trap(arr));

	}

	public static int trap(int[] height) {
		int n = height.length;
		if(n == 0 || n == 1)
            return 0;
		int[] lmax = new int[n];
		int[] rmax = new int[n];

		lmax[0] = height[0];
		rmax[n - 1] = height[n - 1];

		for (int i = 1; i < n; i++) {
			lmax[i] = Math.max(lmax[i - 1], height[i]);
			rmax[n - 1 - i] = Math.max(rmax[n - i], height[n - 1 - i]);
		}
		
		int ans = 0;
		
		for(int i = 0;i<n;i++)
			ans += Math.min(lmax[i], rmax[i]) - height[i];
		
		return ans;
	}
}
