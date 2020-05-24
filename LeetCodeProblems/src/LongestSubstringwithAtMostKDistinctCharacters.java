import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringwithAtMostKDistinctCharacters {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int k = Integer.parseInt(br.readLine());
		int max_size = lengthOfLongestSubstring(input,k);
		System.out.println(max_size);
		
	}
	
	
	private static int lengthOfLongestSubstring(String s, int k) {
		int curr_start = 0, max_size = 0;
		int n = s.length();
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
			if(map.size() <= k)
				max_size = Math.max(max_size, i - curr_start + 1);
			else {
				while(map.size()>k) {
					char l = s.charAt(curr_start);
					if(map.get(l) == 1)
						map.remove(l);
					else
						map.put(c, map.get(c) - 1);
					curr_start++;
				}
			}
		}

		System.out.println(s.substring(curr_start,curr_start+max_size));

		return max_size;
	}
	
	
	
}
