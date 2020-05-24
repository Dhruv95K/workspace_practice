package twopointers;
/*
930. Binary Subarrays With Sum
In an array A of 0s and 1s, how many non-empty subarrays have sum S?

Example 1:
	Input: A = [1,0,1,0,1], S = 2
	Output: 4
	Explanation: 
	The 4 subarrays are bolded below:
	[1,0,1,0,1]
	[1,0,1,0,1]
	[1,0,1,0,1]
	[1,0,1,0,1]
 

Note:
	1. A.length <= 30000
	2. 0 <= S <= A.length
	3. A[i] is either 0 or 1.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class BinarySubarraysWithSum930 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		String[] input = br.readLine().split(",");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int sum = Integer.parseInt(br.readLine());

		System.out.println(numSubarraysWithSum(arr, sum));
	}

	private static int numSubarraysWithSum(int[] arr, int sum) {

		// return numSubarraysWithSumAtMostS(arr, sum) - numSubarraysWithSumAtMostS(arr,sum - 1);
		Map<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);
		int cursum = 0, ans = 0;

		for (int i = 0; i < arr.length; i++) {
			cursum += arr[i];
			ans += map.getOrDefault(cursum - sum, 0);
			map.put(cursum, map.getOrDefault(cursum, 0) + 1);
		}
		return ans;
	}

	public static int numSubarraysWithSumAtMostS(int[] A, int S) {
		int ans = 0;
		int sum = 0, start = 0;

		for (int i = 0; i < A.length; i++) {
			sum += A[i];
			/*
			 * if(A[i] < S) continue;
			 */

			while (sum > S && start <= i) {
				sum -= A[start];
				start++;
			}

			ans += i - start + 1;
		}

		return ans;
	}

}
