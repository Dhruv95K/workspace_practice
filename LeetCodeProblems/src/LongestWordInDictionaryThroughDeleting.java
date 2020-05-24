import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*524. Longest Word in Dictionary through Deleting
Given a string and a string dictionary, find the longest string in the dictionary that can be formed by deleting some
 characters of the given string. If there are more than one possible results, return the longest word with the smallest 
 lexicographical order. If there is no possible result, return the empty string.

Example 1:
	Input:
	s = "abpcplea", d = ["ale","apple","monkey","plea"]
	Output: 
	"apple"
		
Example 2:
	Input:
	s = "abpcplea", d = ["a","b","c"]
	
	Output: 
	"a"
Note:
1.All the strings in the input will only contain lower-case letters.
2.The size of the dictionary won't exceed 1,000.
3.The length of all the strings in the input won't exceed 1,000.

*/
public class LongestWordInDictionaryThroughDeleting {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(br.readLine());

		List<String> list = new ArrayList<>();
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < n; i++)
			list.add(input[i]);

		String ans = findLongestWord(s, list);

	}

	private static String findLongestWord(String s, List<String> list) {
		String ans = "";

		for (String str : list) {
			if (isSubsequence(str, s)) {
				if (str.length() > ans.length() || (str.length() == ans.length() && str.compareTo(ans) < 0))
					ans = str;
			}
		}
		
		return ans;
	}

	public static boolean isSubsequence(String x, String y) {
		int n = y.length();
		int m = x.length();
		int j = 0;

		for (int i = 0; i < n && j < m; i++) {
			if (x.charAt(j) == y.charAt(i))
				j++;
		}

		return j == x.length();
	}

}
