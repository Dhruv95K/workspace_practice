import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 1044. Longest Duplicate Substring

Given a string S, consider all duplicated substrings: (contiguous) substrings of S that occur 2 or more times.  
(The occurrences may overlap.)
Return any duplicated substring that has the longest possible length.  (If S does not have a duplicated substring, the answer 
		is "".)

Example 1:

Input: "banana"
Output: "ana"
Example 2:

Input: "abcd"
Output: ""

	*/

public class LongestDuplicateSubstring {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		String s = read.readLine();
		
		String ans = longestDupSubstring(s);
		
	}

	public static String longestDupSubstring(String s) {
		
		
		return null;
	}

}
