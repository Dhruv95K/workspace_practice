package dsaw5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

import searching.Step;

public class PairBrackets {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {

			String st = read.readLine();
			int n = st.length();
			char arr[] = new char[n];
			
			for (int i = 0; i < n; i++)
				arr[i] = st.charAt(i);
			
			
			String res = pairingBrackets(arr, n);
			System.out.println(count);
			System.out.println(res);
		}
	}

	static int count = 0;
	
	private static String pairingBrackets(char[] arr, int n) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();
		

		for (int i = n - 1; i >= 0; i--) {
			if (arr[i] == '(')
				st.push(i);
		}

		for (int i = 0; i < n; i++) {
			if (arr[i] == ')' && !st.isEmpty() && st.peek() < i) {
				count++;
				sb.append(st.pop()+" ");
				sb.append(i+"\r\n");
			}
		}

		return sb.toString();
	}

}
