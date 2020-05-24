package dsaw5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ClosestFriends {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub

		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(read.readLine());

			int arr[] = new int[n];

			String st[] = read.readLine().trim().split("\\s+");

			for (int i = 0; i < n; i++)
				arr[i] = Integer.parseInt(st[i]);

			String res = closestFriends(arr, n);

			System.out.println(res);
		}

	}

	public static String closestFriends(int[] arr, int n) {

		StringBuilder sb = new StringBuilder();
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < n; i++) {
			while (!st.isEmpty() && (arr[st.peek()] >= arr[i])) {
				st.pop();
			}

			if (st.isEmpty())
				sb.append(-1+" ");
			else
				sb.append(st.peek()+" ");

			st.push(i);
		}

		return sb.toString();
	}

}
