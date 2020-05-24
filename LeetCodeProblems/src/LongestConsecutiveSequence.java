import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*128. Longest Consecutive Sequence
Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

Your algorithm should run in O(n) complexity.

Example:	
	Input: [100, 4, 200, 1, 3, 2]
	Output: 4
	Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
*
*/

public class LongestConsecutiveSequence {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		
		String[] input = br.readLine().split(", ");
		for(int i =0 ;i<n;i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		
		int ans = longestConsecutiveSequence(arr);
		System.out.println(ans);
	}

	private static int longestConsecutiveSequence(int[] arr) {
		Set<Integer> nums = new HashSet<>(); 
		for(int i : arr)
			nums.add(i);
		
		int longestStreak = 0;
		
		for(int num : nums) {
			if(!nums.contains(num-1)) {
				int curr = num;
				int currentStreak = 1;
				
				while(nums.contains(curr+1)) {
					currentStreak++;
					curr++;
				}
				
				longestStreak = Math.max(longestStreak, currentStreak);
			}
		}
		
		return longestStreak;
	}

}
