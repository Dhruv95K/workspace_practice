import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*                 
 395. Longest Substring with At Least K Repeating Characters
 Find the length of the longest substring T of a given string (consists of lowercase letters only) 
 such that every character in T appears no less than k times.
 
Example 1:
	Input:
	s = "aaabb", k = 3	
	Output:
	3
	The longest substring is "aaa", as 'a' is repeated 3 times.

Example 2:
	Input:
	s = "ababbc", k = 2
	Output:
	5
	The longest substring is "ababb", as 'a' is repeated 2 times and 'b' is repeated 3 times.
*/

public class LongestSubstringwithAtLeastKRepeatingCharacters {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int k = Integer.parseInt(br.readLine());
		int max_size = lengthOfLongestSubstring(input, k);
		System.out.println(max_size);
	}

	private static int lengthOfLongestSubstring(String s, int k) {
		Map<Character, Integer> count = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			count.put(s.charAt(i), count.getOrDefault(s.charAt(i), 0) + 1);
		}

		Set<Character> lessFrequent = new HashSet<>();

		for (char c : count.keySet())
			if (count.get(c) < k)
				lessFrequent.add(c);

		if (lessFrequent.isEmpty())
			return s.length();

		int ans = 0;
		int i = 0;
		int j = 0;
		for (j = 0; j < s.length(); j++) {
			char c = s.charAt(j);
			if (lessFrequent.contains(c)) {
				if (i != j)
					ans = Math.max(ans, lengthOfLongestSubstring(s.substring(i, j), k));
				i = j + 1;
			}
		}

		if (i != j)
			ans = Math.max(ans, lengthOfLongestSubstring(s.substring(i, j), k));

		return ans;
	}


	public int longestSubstring(String s, int k) {
		int[] counts = new int[26];
		int max = 0;
		for (int u = 1; u <= 26; ++u) {
			Arrays.fill(counts, 0);
			int left = 0;
			int right = 0;
			int unique = 0;
			int kOrMore = 0;
			while (right < s.length()) {
				if (unique <= u) {
					char c = s.charAt(right);
					int idx = (int) c - (int) 'a';
					counts[idx]++;
					if (counts[idx] == 1) {
						++unique;
					}
					if (counts[idx] == k) {
						++kOrMore;
					}
					++right;
				} else {
					char o = s.charAt(left);
					int idx = (int) o - (int) 'a';
					counts[idx]--;
					if (counts[idx] == 0) {
						--unique;
					}
					if (counts[idx] == k - 1) {
						--kOrMore;
					}
					++left;
				}
				if (unique == u && kOrMore == unique) {
					max = Math.max(max, right - left);
				}
			}
		}
		return max;
	}

}
