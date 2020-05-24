import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*424. Longest Repeating Character Replacement
Given a string s that consists of only uppercase English letters, you can perform at most k 
operations on that string.
In one operation, you can choose any character of the string and change it to any other 
uppercase English character.
Find the length of the longest sub-string containing all repeating letters you can 
get after performing the above operations.

Note:
Both the string's length and k will not exceed 104.

Example 1:

	Input:
	s = "ABAB", k = 2
	
	Output:
	4

Explanation:
Replace the two 'A's with two 'B's or vice versa.
 

Example 2:
	
	Input:
	s = "AABABBA", k = 1
	
	Output:
	4

Explanation:
Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
*/

public class LongestRepeatingCharacterReplacement {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int k = Integer.parseInt(br.readLine());

		int ans = characterReplacement(s, k);
		System.out.println(ans);

	}

	public static int characterReplacement(String s, int k) {
		int result = 0;
		int l = 0, r = 0, maxCharCount = 0;
		int[] count = new int[26];

		for (r = 0; r < s.length(); r++) {
			count[s.charAt(r) - 'A']++;
			maxCharCount = Math.max(maxCharCount, count[s.charAt(r) - 'A']);
			while (r - l + 1 - maxCharCount > k) {
				count[s.charAt(l) - 'A']--;
				l++;
			}
			for(int i = 0; i < 26; i++){
				maxCharCount = Math.max(maxCharCount, count[i]);
            }

			result = Math.max(result, r - l + 1);
		}

		return result;
	}

}
