import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*409 
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes 
that can be built with those letters.
This is case sensitive, for example "Aa" is not considered a palindrome here.
Assume the length of given string will not exceed 1,010.
*/

public class LongestPalindrome {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int ans = lengthOfLongestPalindrome(input);
		System.out.println(ans);

	}

	private static int lengthOfLongestPalindrome(String s) {
		int[] freq = new int[256];
		int n = s.length();
		int max = 0;

		for (int i = 0; i < n; i++) {
			freq[s.charAt(i) - 'A']++;
		}

		

		for (int i = 0; i < 256; i++) {
			if (freq[i] % 2 == 0)
				max += freq[i];
			else if (freq[i] % 2 == 1) {
				max += freq[i]-1;
				if(max%2==0)
					max++;
			}
		}

		return max ;
	}

}
