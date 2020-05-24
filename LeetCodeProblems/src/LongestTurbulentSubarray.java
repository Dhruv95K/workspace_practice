import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 978. Longest Turbulent Subarray
A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:

For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

Return the length of a maximum size turbulent subarray of A.

Example 1:
	Input: [9,4,2,10,7,8,8,1,9]
	Output: 5
	Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])
	
Example 2:
	Input: [4,8,12,16]
	Output: 2
	
Example 3:	
	Input: [100]
	Output: 1
 

Note:

1. 1 <= A.length <= 40000
2. 0 <= A[i] <= 10^9
*/

public class LongestTurbulentSubarray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		String[] input = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}
		

		int ans = maxTurbulenceSize(arr);
		System.out.println(ans);
	}

	private static int maxTurbulenceSize(int[] arr) {
		boolean flip = true;
		int count = 1, max = 0;
		int n = arr.length;

		for (int i = 0; i < n - 1; i++) {
			
			if (checkTurbulence(arr[i], arr[i + 1], flip)) {
				count++;
			} else {
				max = Math.max(max, count);
				count = 1;
				if(arr[i] != arr[i+1])
					i--;
			}
			flip = !flip;
		}
		
		max = Math.max(max, count);

		return max;
	}

	private static boolean checkTurbulence(int x, int y, boolean flip) {

		if (flip)
			return x > y;
		else
			return x < y;
	}

}
