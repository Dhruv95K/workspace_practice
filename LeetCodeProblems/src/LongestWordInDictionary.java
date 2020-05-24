import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/*720. Longest Word in Dictionary
Given a list of strings words representing an English Dictionary, find the longest word in words 
that can be built one character at a time by other words in words. If there is more than one
possible answer, return the longest word with the smallest lexicographical order.

If there is no answer, return the empty string.

Example 1:
	Input: 
	words = ["w","wo","wor","worl", "world"]
	Output: "world"
	Explanation: 
	The word "world" can be built one character at a time by "w", "wo", "wor", and "worl".
Example 2:
	Input: 
	words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
	Output: "apple"
	Explanation: 
	Both "apply" and "apple" can be built from other words in the dictionary. However, "apple" is lexicographically smaller than "apply".
	Note:

All the strings in the input will only contain lowercase letters.
The length of words will be in the range [1, 1000].
The length of words[i] will be in the range [1, 30].
*/
public class LongestWordInDictionary {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] st = new String[n];
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < n; i++)
			st[i] = input[i];

		String ans = longestWord(st);

		System.out.println(ans);
	}

	public static String longestWord(String[] words) {
		Set<String> set = new HashSet<>();
		String ans = "";
		boolean flgHasPrefix = false;

		for (String word : words)
			set.add(word);

		for (String word : words) {
			if (word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0)) {
				for (int i = 1; i < word.length(); i++) {
					if (!set.contains(word.substring(0, i))) {
						flgHasPrefix = false;
						break;
					}
				}
				if (flgHasPrefix)
					ans = word;
			}
		}

		return ans;

	}

	public static String longestWordUsingTrie(String[] words) {
		String ans = "";
		Trie trie = new Trie();
		int i = 1;

		for (String word : words) {
			trie.insertWord(word, i);
			i++;
		}

		ans = trie.dfs(words);

		return ans;
	}

}

class TrieNode {
	int index;
	Map<Character, TrieNode> childern;

	public TrieNode() {
		childern = new HashMap<>();
		index = 0;
	}
}

class Trie {
	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insertWord(String word, int index) {
		TrieNode curr = root;
		for (char c : word.toCharArray()) {
			if (curr.childern.get(c) == null)
				curr.childern.put(c, new TrieNode());

			curr = curr.childern.get(c);

		}
		curr.index = index;
	}

	public String dfs(String[] words) {
		String ans = "";
		Stack<TrieNode> st = new Stack<>();
		st.push(root);

		while (!st.isEmpty()) {
			TrieNode curr = st.pop();
			if (curr == root || curr.index > 0) {
				if (curr != root) {
					String word = words[curr.index-1];
					if(word.length() > ans.length() || (word.length() == ans.length() && word.compareTo(ans) < 0)) {
						ans=word;
					}
				}

				for (TrieNode node : curr.childern.values())
					st.push(node);
			}
		}

		return ans;
	}

}
