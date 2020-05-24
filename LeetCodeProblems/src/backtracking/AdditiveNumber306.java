package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
306. Additive Number
Additive number is a string whose digits can form additive sequence.
A valid additive sequence should contain at least three numbers. Except for the first two numbers, each subsequent 
number in the sequence must be the sum of the preceding two.
Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.

Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.

Example 1:	
	Input: "112358"
	Output: true
	Explanation: The digits can form an additive sequence: 1, 1, 2, 3, 5, 8. 
	             1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
	             
Example 2:	
	Input: "199100199"
	Output: true
	Explanation: The additive sequence is: 1, 99, 100, 199. 
	             1 + 99 = 100, 99 + 100 = 199
	 
Constraints:	
	1. num consists only of digits '0'-'9'.
	2. 1 <= num.length <= 35
*/
public class AdditiveNumber306 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		System.out.println(isAdditiveNumber(s));

	}

	public static boolean isAdditiveNumber(String num) {
		List<Long> ans = new ArrayList<>();
		
		return isAdditiveNumber(num, 0, ans);
	}

	private static boolean isAdditiveNumber(String num, int ind, List<Long> ans) {
		if (ind == num.length()) {
			if (ans.size() >= 3) {
				System.out.println(ans);
				return true;
			}
		}

		for (int i = ind; i < num.length(); i++) {
			if (i > ind && num.charAt(ind) == '0')
				break;
			String temp = num.substring(ind, i + 1);
			if(temp.length() > 18)
				break;
			long number = Long.parseLong(temp);
			if (ans.size() >= 2 && number > ans.get(ans.size() - 1) + ans.get(ans.size() - 2))
				break;
			if (ans.size() < 2 || number == ans.get(ans.size() - 1) + ans.get(ans.size() - 2)) {
				ans.add(number);
				if(isAdditiveNumber(num, i+1, ans))
					return true;
				ans.remove(ans.size()-1);
			}
		}

		return false;
	}

}
