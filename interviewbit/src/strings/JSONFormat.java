package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class JSONFormat {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		ArrayList<String> json = prettyJSON(s1);
		for (String s : json)
			System.out.println(s);
	}

	public static ArrayList<String> prettyJSON(String A) {
		ArrayList<String> res = new ArrayList<String>();
		int n = A.length();
		// int spaces = 0;
		StringBuilder indent = new StringBuilder("");
		StringBuilder add = new StringBuilder("");
		for (int i = 0; i < n; i++) {
			if (A.charAt(i) == '{' || A.charAt(i) == '[') {
				res.add(indent.toString() + A.substring(i, i + 1));
				indent.append("\t");
			} else if (A.charAt(i) == '}' || A.charAt(i) == ']') {
				indent.replace(indent.length() - 1, indent.length(), "");
				res.add(indent.toString() + A.substring(i, i + 1));
			} else {
				int start = i;
			//	while(i<n&&)
			}
		}

		return res;
	}

}
