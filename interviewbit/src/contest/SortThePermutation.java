package contest;
/*
Sort the permutation

Problem Description
Given a permutation of size N. Each number has some color associated to it.
Find the maximum number of colors that can be used such that you are able to sort the permutation 
by swapping the elements having same color.


Problem Constraints
1 <= N <= 100000


Input Format
First argument is an array of size N consisting of all elements from 1 to N.


Output Format
Return an integer denoting the maximum number of colors that can be used.

Example Input
	Input 1:
	A = [1,4,2,3]


Example Output
	Output 1:
	2


Example Explanation
Explanation 1:
	We can color 4, 2, 3 with same color and 1 with different color.
	Given A = [1,4,2,3].
	After swapping 4 and 2,  A => [1,2,4,3].
	Now swap 4 and 3 to get the sorted permutation A => [1,2,3,4].
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SortThePermutation {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		String[] input = br.readLine().split(", ");
		for(int i =0;i<n;i++)
			arr[i] = Integer.parseInt(input[i]);

		System.out.println(solve(arr));
	}

	public static int solve(int[] A) {
		int n = A.length;
		boolean[] visited = new boolean[n];
		int colors = 0;

		for (int i = 0; i < n; i++) {
			if (A[i] == i + 1) {
				if (!visited[i]) {
					visited[i] = true;
					colors++;
				}
				continue;
			}

			while (A[i] != i + 1 && !visited[i]) {
				int curr = A[i];
				swap(A, i, curr - 1);
				visited[curr - 1] = true;
			}
			colors++;
			visited[i] = true;
		}

		return colors;
	}

	public static void swap(int[] arr, int i, int j) {
		int t = arr[i];
		arr[i] = arr[j];
		arr[j] = t;
	}

}
