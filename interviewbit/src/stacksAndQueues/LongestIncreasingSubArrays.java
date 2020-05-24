package stacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Iterator;

public class LongestIncreasingSubArrays {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String[] input = br.readLine().split(" ");
			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);

			input = br.readLine().split(" ");
			ArrayDeque<Integer> q = new ArrayDeque<>();

			for (int i = 0; i < n; i++) {
				q.add(Integer.parseInt(input[i]));
			}

			for (int i = 0; i < m; i++) {
				char c = (char) br.read();
				if (c == 'L') {
					q.addFirst(q.removeLast());
					System.out.println(longestIncSubarray(q, n));
				} else {
					q.addLast(q.pollFirst());
					System.out.println(longestIncSubarray(q, n));
				}
			}
		}
	}

	private static int longestIncSubarray(ArrayDeque<Integer> q, int n) {
		Iterator<Integer> it = q.iterator();
		return 0;
	}

}
