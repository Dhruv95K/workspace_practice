package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestNumberInKswaps {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int k = Integer.parseInt(br.readLine());
			String s = br.readLine();
			max = s;
			LargestNumberInKswaps(s.toCharArray(), k);
			System.out.println(max);
		}

	}

	static String max;

	private static void LargestNumberInKswaps(char[] st, int k) {
		// TODO Auto-generated method stub
		if (k == 0)
			return;

		for (int i = 0; i < st.length; i++) {
			for (int j = i + 1; j < st.length; j++) {
				if (st[i] < st[j]) {
					swap(st,i,j);
					String curr = String.valueOf(st); 
					if(curr.compareTo(max) > 0)
						max = curr;
					LargestNumberInKswaps(st,k-1);
					swap(st,i,j);
				}
			}
		}
	}

	private static void swap(char[] st, int i, int j) {
		// TODO Auto-generated method stub
		char t = st[i];
		st[i] = st[j];
		st[j] = t;
	}

}
