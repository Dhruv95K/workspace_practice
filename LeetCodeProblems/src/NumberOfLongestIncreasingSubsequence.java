import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*673. Number of Longest Increasing Subsequence
Given an unsorted array of integers, find the number of longest increasing subsequence.

**************************REVISIT SEGMENT TREE SOLUTION************************************

*/
public class NumberOfLongestIncreasingSubsequence {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int ans = findNumberOfLIS(arr);
		System.out.println(ans);

	}

	private static int findNumberOfLIS(int[] arr) {
		int n = arr.length;
		int[] lis = new int[n];
		int[] count = new int[n];
		int maxLength = 1;
		int ans = 0;
		
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					if (lis[i] <= lis[j]) {
						lis[i] =  1 + lis[j];
						count[i] = count[j];
					}
					else if(lis[i] == lis[j]+1)
						count[i]+=count[j];
				}
			}
			maxLength = Math.max(maxLength, lis[i]);
		}
		
		for(int i=0;i<lis.length;i++)
			if(lis[i] == maxLength)
				ans+=count[i];
		/*
		 * temp = new ArrayList<>(); return getLisCount(lis, max, arr);
		 */
		return ans;
	}

	static ArrayList<Integer> temp;

//			backtracking recursive solution
	public static int getLisCount(int[] lis, int max, int[] arr) {
		int n = lis.length;
		int ans = 0;

		for (int i = 0; i < n; i++) {
			if (lis[i] == max) {
				temp.add(arr[i]);
				ans += backTrack(lis, i, max - 1, arr);
				temp.remove(temp.size() - 1);
			}
		}

		return ans;
	}

	private static int backTrack(int[] lis, int ind, int max, int[] arr) {
		if (max == 0 || ind == 0) {
			for (int i = temp.size() - 1; i >= 0; i--)
				System.out.print(temp.get(i) + ", ");
			System.out.println("");
			return 1;
		}

		int ans = 0;
		for (int i = ind - 1; i >= 0; i--) {
			if (lis[i] == max && arr[i] < arr[ind]) {
				temp.add(arr[i]);
				ans += backTrack(lis, i, max - 1, arr);
				temp.remove(temp.size() - 1);
			}
		}

		return ans;
	}

}
