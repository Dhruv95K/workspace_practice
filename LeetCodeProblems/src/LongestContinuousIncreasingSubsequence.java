import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*674. Longest Continuous Increasing Subsequence
Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
*/
public class LongestContinuousIncreasingSubsequence {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(read.readLine());
		int arr[] = new int[n];
		String st[] = read.readLine().trim().split(" ");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(st[i]);
		
		

		int len = findLengthOfLCIS(arr);
	}

	public static int findLengthOfLCIS(int[] nums) {
		if (nums.length == 0)
			return 0;

		int currlen = 1;
		int maxlen = 0;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1])
				currlen++;
			else {
				maxlen = Math.max(maxlen, currlen);
				currlen = 1;

			}
		}

		maxlen = Math.max(maxlen, currlen);

		return maxlen;
	}

}
