package twopointers;
/*
345. Reverse Vowels of a String

Write a function that takes a string as input and reverse only the vowels of a string.
Example 1:
	Input: "hello"
	Output: "holle"
		
Example 2:
	Input: "leetcode"
	Output: "leotcede"

Note:
	The vowels does not include the letter "y".
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString345 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		System.out.println(reverseVowels(s));
	}

	public static String reverseVowels(String s) {
		int i = 0;
		int j = s.length() - 1;
		
		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		vowels.add('A');
		vowels.add('E');
		vowels.add('I');
		vowels.add('O');
		vowels.add('U');
		
		char[] ch = s.toCharArray();
		
		while(i<j) {
			while(i < j && !vowels.contains(ch[i]))
				i++;
			while(i < j && !vowels.contains(ch[j]))
				j--;

			swap(ch,i,j);
			i++;j--;

		}
		
		return String.valueOf(ch);
	}

	private static void swap(char[] ch, int i, int j) {
		char t = ch[i];
		ch[i] = ch[j];
		ch[j] = t;
	}
}
