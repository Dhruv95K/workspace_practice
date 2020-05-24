import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
845. Longest Mountain in Array
Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

B.length >= 3
There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
(Note that B could be any subarray of A, including the entire array A.)

Given an array A of integers, return the length of the longest mountain. 

Return 0 if there is no mountain.

Example 1:
	Input: [2,1,4,7,3,2,5]
	Output: 5
	Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
	
Example 2:
	Input: [2,2,2]
	Output: 0
	Explanation: There is no mountain.
	
Note:

1. 0 <= A.length <= 10000
2. 0 <= A[i] <= 10000

Follow up:

Can you solve it using only one pass?
Can you solve it in O(1) space?
*/
public class LongestMountainInArray {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		String[] input = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int ans = longestMountain(arr);
		System.out.println(ans);
	}

	public static int longestMountain(int[] A) {
		int n = A.length;
		int base = 0;
		int ans = 0;
		int end = 0;

		while (base < n) {
			end = base;

			if (end + 1 < n && A[end] < A[end + 1]) {
				while (end + 1 < n && A[end] < A[end + 1])
					end++;
				if (end + 1 < n && A[end] > A[end + 1]) {
					while (end + 1 < n && A[end] > A[end + 1])
						end++;
					ans = Math.max(ans, end - base + 1);
				}
			}
			
			base = Math.max(end, base+1);
		}
		
		return ans;
	}

}
