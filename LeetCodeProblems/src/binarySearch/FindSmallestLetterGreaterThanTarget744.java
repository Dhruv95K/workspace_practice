package binarySearch;

/*
744. Find Smallest Letter Greater Than Target
Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the 
smallest element in the list that is larger than the given target.

Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

Examples:
Input:
letters = ["c", "f", "j"]
target = "a"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "c"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "g"
Output: "j"

Input:
letters = ["c", "f", "j"]
target = "j"
Output: "c"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"
Note:
	1. letters has a length in range [2, 10000].
	2. letters consists of lowercase letters, and contains at least 2 unique letters.
	3. target is a lowercase letter.
*/
public class FindSmallestLetterGreaterThanTarget744 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public char nextGreatestLetter(char[] letters, char target) {
		int l = 0, r = letters.length - 1;
		char ans = '$';
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (letters[mid] - 'a' > target - 'a') {
				ans = letters[mid];
				r = mid - 1;
			} else
				l = mid + 1;
		}

		return ans == '$' ? letters[0] : ans;
	}

}
