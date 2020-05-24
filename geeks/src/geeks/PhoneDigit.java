package geeks;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneDigit {

	static Map<String, String> phone = new HashMap<String, String>() {
		{
			put("2", "abc");
			put("3", "def");
			put("4", "ghi");
			put("5", "jkl");
			put("6", "mno");
			put("7", "pqrs");
			put("8", "tuv");
			put("9", "wxyz");
		}
	};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt(); // input size of array
			int arr[] = new int[n]; // input the elements of array that are keys to be pressed

			for (int i = 0; i < n; i++)
				arr[i] = sc.nextInt();
			new PhoneDigit().possibleWords(arr, n);

		}
	}

	private void possibleWords(int[] arr, int n) {
		// TODO Auto-generated method stub
		String s = "";
		for (int i : arr)
			s += i;

		backTrack("", s);
	}

	private void backTrack(String comb, String digits) {
		// TODO Auto-generated method stub
		if (digits.length() == 0)
			System.out.println(comb);
		else {
			String digit = digits.substring(0, 1);
			String letters = phone.get(digit);

			for (int i = 0; i < letters.length(); i++) {
				
				String letter = letters.substring(i, i+1);
				
				backTrack(comb+letter,digits.substring(1));
			}

		}
	}

}
