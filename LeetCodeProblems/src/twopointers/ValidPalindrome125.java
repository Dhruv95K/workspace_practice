package twopointers;
/*
125. Valid Palindrome
Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:
	Input: "A man, a plan, a canal: Panama"
	Output: true

Example 2:	
	Input: "race a car"
	Output: false
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidPalindrome125 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		System.out.println(isPalindrome(s));

	}

	public static boolean isPalindrome(String s) {
		char[] ch = s.toCharArray();
		
		int l = 0,r = s.length()-1;
		
		while(l < r) {
			while(l < r && !Character.isLetter(ch[l]) && !Character.isDigit(ch[l]))
				l++;
			while(l < r && !Character.isLetter(ch[r]) && !Character.isDigit(ch[r]))
				r--;
			
			if(Character.toLowerCase(ch[l]) != Character.toLowerCase(ch[r]))
				return false;
			else {
				l++;r--;
			}
		}
		
		return true;
	}

}
