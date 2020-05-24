package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

/*
1079. Letter Tile Possibilities
ou have a set of tiles, where each tile has one letter tiles[i] printed on it.  Return the number of possible 
non-empty sequences of letters you can make.

Example 1:
	Input: "AAB"
	Output: 8
	Explanation: The possible sequences are "A", "B", "AA", "AB", "BA", "AAB", "ABA", "BAA".

Example 2:	
	Input: "AAABBC"
	Output: 188
	 

Note:
	1. 1 <= tiles.length <= 7
	2. tiles consists of uppercase English letters.
*/
public class LetterTilePossibilities1079 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		int ans = numTilePossibilitiesRecursive(s);
		System.out.println(ans);

	}

	public static int numTilePossibilities(String tiles) {
		int[] count = new int[26];
		for (char c : tiles.toCharArray())
			count[c - 'A']++;

		return dfs(count);
	}

	private static int dfs(int[] count) {
		int sum = 0;

		for (int i = 0; i < 26; i++) {
			if(count[i] == 0)
				continue;
			sum++;
			count[i]--;
			sum+=dfs(count);
			count[i]++;
		}

		return sum;
	}

	// Recursive Solution
	public static int numTilePossibilitiesRecursive(String tiles) {
		Set<String> s = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		visited = new boolean[tiles.length()];

		dfsPossibilities(tiles, sb, s);
		return s.size();
	}

	static boolean[] visited;

	private static void dfsPossibilities(String tiles, StringBuilder sb, Set<String> set) {
		if (sb.length() > 0)
			set.add(sb.toString());
		
		/*if (sb.length() >= tiles.length())
			return;*/

		for (int i = 0; i < tiles.length(); i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			sb.append(tiles.charAt(i));
			dfsPossibilities(tiles, sb, set);
			sb.setLength(sb.length() - 1);
			visited[i] = false;
		}

	}

}
