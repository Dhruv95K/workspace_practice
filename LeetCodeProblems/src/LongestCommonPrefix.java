import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
14. Longest Common Prefix
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".
Example 1:

	Input: ["flower","flow","flight"]
	Output: "fl"
	Example 2:

	Input: ["dog","racecar","car"]
	Output: ""
	Explanation: There is no common prefix among the input strings.		
*/

public class LongestCommonPrefix {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] st = new String[n];
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < n; i++)
			st[i] = input[i];

		String ans = longestCommonPrefix(st);

		System.out.println(ans);

	}

	private static String longestCommonPrefix(String[] strs) {
		if (strs == null || strs.length == 0) return "";
	    for (int i = 0; i < strs[0].length() ; i++){
	        char c = strs[0].charAt(i);
	        for (int j = 1; j < strs.length; j ++) {
	            if (i == strs[j].length() || strs[j].charAt(i) != c)
	                return strs[0].substring(0, i);             
	        }
	    }
	    
	    return strs[0];
	}

	// used trie from longest word in Dictionary
	private static String longestCommonPrefixUsingTrie(String[] st) {
		if (st.length == 0)
			return "";
		String ans = "";
		Trie trie = new Trie();
		int i = 1;

		for (String word : st) {
			if (word.equals(""))
				return ans;
			trie.insertWord(word, i);
			i++;
		}

		ans = st[0].substring(0, traverseLCP(trie));

		return ans;

	}

	private static int traverseLCP(Trie trie) {
		int len = 0;
		TrieNode curr = trie.root;

		while (curr.childern.keySet().size() == 1) {
			len++;
			for (char c : curr.childern.keySet())
				curr = curr.childern.get(c);
		}

		return len;
	}

}
