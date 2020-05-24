package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CompareVersions {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		String s2 = br.readLine();

		System.out.println(compareVersion(s1, s2));
		
	}

	public static int compareVersion(String A, String B) {

		String[] version1 = A.split("\\.");
		String[] version2 = B.split("\\.");

		int n = version1.length > version2.length ? version1.length : version2.length;
		int val1, val2;

		for (int i = 0; i < n; i++) {
			if (i < version1.length)
				val1 = Integer.parseInt(version1[i]);
			else
				val1 = 0;

			if (i < version2.length)
				val2 = Integer.parseInt(version2[i]);
			else
				val2 = 0;

			if (val1 > val2)
				return 1;
			else if (val1 < val2)
				return -1;
		}

		return 0;
	}

}
