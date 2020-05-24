import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
925. Long Pressed Name
Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, 
the key might get long pressed, and the character will be typed 1 or more times.

You examine the typed characters of the keyboard.  Return True if it is possible that it was 
your friends name, with some characters (possibly none) being long pressed.

Example 1:
	Input: name = "alex", typed = "aaleex"
	Output: true
	Explanation: 'a' and 'e' in 'alex' were long pressed.

Example 2:
	Input: name = "saeed", typed = "ssaaedd"
	Output: false
	Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.

Example 3:
	Input: name = "leelee", typed = "lleeelee"
	Output: true

Example 4:
	Input: name = "laiden", typed = "laiden"
	Output: true
	Explanation: It's not necessary to long press any character.
 

Note:

1. name.length <= 1000
2. typed.length <= 1000
3. The characters of name and typed are lowercase letters.

*/
public class LongPressedName {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s1 = br.readLine();
		String s2 = br.readLine();

		System.out.println(isLongPressedName(s1, s2));

	}

	public static boolean isLongPressedName(String name, String typed) {
		int n = name.length();
		int m = typed.length();
		int i, j;

		for (i = 0, j = 0; i < n && j < m; i++, j++) {
			if (name.charAt(i) != typed.charAt(j))
				return false;

			char c = name.charAt(i);
			int cnt1 = 0;
			int cnt2 = 0;

			int c1 = i, c2 = j;
			while (c1 < n && name.charAt(c1) == c) {
				cnt1++;
				c1++;
			}
			while (c2 < m && typed.charAt(c2) == c) {
				cnt2++;
				c2++;
			}

			if (cnt2 < cnt1)
				return false;

			i = c1 - 1;
			j = c2 - 1;

		}

		if (i != name.length())
			return false;

		return true;

	}

}
