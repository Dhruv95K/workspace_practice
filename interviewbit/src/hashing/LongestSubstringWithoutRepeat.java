package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeat {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inputLine = br.readLine();

		System.out.println(lengthOfLongestSubstring(inputLine));
	}

	public static int lengthOfLongestSubstring(String A) {
		int start = 0;
		int start_index = -1;
		int maxlen = 0;		
		int currlen = 0;
		int n = A.length();
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			map.put(A.charAt(i), map.getOrDefault(A.charAt(i), 0) + 1);
				
			if (map.get(A.charAt(i)) > 1) {
				while (A.charAt(start) != A.charAt(i)) {
					map.put(A.charAt(start), map.getOrDefault(A.charAt(start), 0) - 1);
					start++;
				}
				map.put(A.charAt(start), map.getOrDefault(A.charAt(start), 0) - 1);
				start++;
				maxlen = Math.max(maxlen, currlen);
				currlen = i - start + 1;
			} else
				currlen++;

		}

		maxlen = Math.max(currlen, maxlen);

		return maxlen;

	}

}
