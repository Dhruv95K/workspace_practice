package twopointers;
/*
11. Container With Most Water
Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical 
lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis 
forms a container, such that the container contains the most water.

Note: You may not slant the container and n is at least 2.
Example:
	Input: [1,8,6,2,5,4,8,3,7]
	Output: 49
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ContainerWithMostWater11 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] A = new int[n];

		String[] input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			A[i] = Integer.parseInt(input[i]);

		System.out.println(maxArea(A));

	}

	public static int maxArea(int[] height) {
		int i = 0, j = height.length - 1;
		int ans = -1;

		while (i < j) {
			int breadth = j - i;
			int length ;
			if(height[i] < height[j]) {
				length = height[i];
				i++;
			}
			else {
				length = height[j];
				j--;
			}
			
			ans = Math.max(ans, length*breadth);
		}
		
		return ans;
	}

}
