import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
521. Longest Uncommon Subsequence I
Given a group of two strings, you need to find the longest uncommon subsequence of this 
group of two strings. The longest uncommon subsequence is defined as the longest subsequence 
of one of these strings and this subsequence should not be any subsequence of the other strings.

The input will be two strings, and the output needs to be the length of the longest uncommon 
subsequence. If the longest uncommon subsequence doesn't exist, return -1.

Example 1:
	Input: "aba", "cdc"
	Output: 3
Explanation: The longest uncommon subsequence is "aba" (or "cdc"),	
because "aba" is a subsequence of "aba", 
but not a subsequence of any other strings in the group of two strings.

Note:
	1.Both strings' lengths will not exceed 100.
	2.Only letters from a ~ z will appear in input strings.
*/

public class LongestUncommonSubsequenceI {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();

		int len = findLUSlength(s1, s2);

		System.out.println(len);
	}

	public static int findLUSlength(String a, String b) {
		if(a.equals(b))
			return -1;
		
		return Math.max(a.length(), b.length());
	}

}
