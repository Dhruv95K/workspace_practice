package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SameFormatString {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String s2 = br.readLine();

		System.out.println(solve(s1, s2));

	}

	public static int solve(final String A, final String B) {
		int i = 0, j = 0;
		int n = A.length();
		int m = B.length();

		if (m < n)
			return 0;

		while (i < A.length() && j < B.length()) {
			char a = A.charAt(i), b = B.charAt(j);
			if (a == b) {
				while (j < B.length() && B.charAt(j) == a)
					j++;
				i++;
			} else
				return 0;

		}

		if (i != n && j != m)
			return 0;

		return 1;
	}

}
