package backtracking;
/*
1239. Maximum Length of a Concatenated String with Unique Characters
Given an array of strings arr. String s is a concatenation of a sub-sequence of arr which have unique characters.

Return the maximum possible length of s.

Example 1:
	Input: arr = ["un","iq","ue"]
	Output: 4
	Explanation: All possible concatenations are "","un","iq","ue","uniq" and "ique".
	Maximum length is 4.

Example 2:	
	Input: arr = ["cha","r","act","ers"]
	Output: 6
	Explanation: Possible solutions are "chaers" and "acters".

Example 3:
	Input: arr = ["abcdefghijklmnopqrstuvwxyz"]
	Output: 26
 

Constraints:
	1. 1 <= arr.length <= 16
	2. 1 <= arr[i].length <= 26
	3. arr[i] contains only lower case English letters.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters1239 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");
		List<String> arr = new ArrayList<String>();

		for (int i = 0; i < n; i++)
			arr.add(input[i]);

		int ans = maxLength(arr);

	}

	public static int maxLength(List<String> arr) {
		List<String> dp = new ArrayList<String>();
		dp.add("");
		for (String s : arr) {
			if (!isUnique(s))
				continue;
			List<String> list = new ArrayList<String>();
			for (String s2 : dp) {
				String temp = s2 + s;
				if (temp.length() <= 26 && isUnique(temp))
					list.add(temp);
			}
			dp.addAll(list);
		}

		int max = 0;
		for (String s : dp)
			max = Math.max(max, s.length());

		return max;
	}

	private static boolean isUnique(String temp) {
		Set<Character> set = new HashSet<>();
		for (char c : temp.toCharArray()) {
			if (set.contains(c))
				return false;
			set.add(c);
		}

		return true;
	}

	static int result;

	public static int maxLengthDFS(List<String> arr) {
		result = 0;
		String temp = "";
		maxLengthDFS(arr, 0, temp);

		return result;
	}

	private static void maxLengthDFS(List<String> arr, int ind, String temp) {
		if (temp.length() > 26 || !isUnique(temp))
			return;

		result = Math.max(result, temp.length());

		if (ind == arr.size())
			return;

		for (int i = ind; i < arr.size(); i++) {
			if (isUnique(arr.get(i)))
				maxLengthDFS(arr, i + 1, temp + arr.get(i));
		}

		// maxLengthDFS(arr, ind+1, temp);
	}

}
