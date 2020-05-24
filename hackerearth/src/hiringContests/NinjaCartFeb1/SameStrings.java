package hiringContests.NinjaCartFeb1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SameStrings {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String a = br.readLine();
			String b = br.readLine();

			if (isSame(a, b))
				System.out.println("YES");
			else
				System.out.println("NO");
		}

	}

	private static boolean isSame(String a, String b) {
		Map<Character, Integer> map = new HashMap<>();

		for (int i = 0; i < a.length(); i++)
			map.put(a.charAt(i), map.getOrDefault(a.charAt(i), 0) + 1);

		for (int i = 0; i < b.length(); i++)
			map.put(b.charAt(i), map.getOrDefault(b.charAt(i), 0) + 1);

		for (char c : map.keySet())
			if (map.get(c) % 2 != 0)
				return false;

		return true;
	}

}
