import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*3. Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.*/


public class LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int ans = lengthOfLongestSubstring(input);
		System.out.println(ans);
	}

	private static int lengthOfLongestSubstring(String s) {
		int curr_start = 0, max_size = 0;
		int n = s.length();
		Map<Character, Integer> index = new HashMap<Character, Integer>();

		for (int i = 0; i < n; i++) {
			if (index.get(s.charAt(i)) != null) {
				curr_start = Math.max(curr_start,index.get(s.charAt(i)) + 1);
			}

			max_size = Math.max(max_size, i - curr_start + 1);
			index.put(s.charAt(i), i );
		}

		return max_size;
	}

}
