package trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CheckTreeOrders {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		ArrayList<Integer> a = new ArrayList<>();
		ArrayList<Integer> b = new ArrayList<>();
		ArrayList<Integer> c = new ArrayList<>();

		String[] inputLine = br.readLine().split(", ");
		for (int j = 0; j < n; j++) {
			a.add(Integer.parseInt(inputLine[j]));
		}

		inputLine = br.readLine().split(", ");
		for (int j = 0; j < n; j++) {
			b.add(Integer.parseInt(inputLine[j]));
		}
		
		inputLine = br.readLine().split(", ");
		for (int j = 0; j < n; j++) {
			c.add(Integer.parseInt(inputLine[j]));
		}

		boolean isTree = checkTree(a, 0, b, 0, c, 0, a.size());

		System.out.println(isTree ? 1 : 0);
		

		
	}

	public static boolean checkTree(ArrayList<Integer> pre, int s, ArrayList<Integer> in, int s1,
			ArrayList<Integer> post, int s2, int len) {
		if (len == 0)
			return true;

		if (len == 1) {
			return (pre.get(s) == in.get(s1) && pre.get(s) == post.get(s2));
		}
		
		int index  = -1;
		index = findIndex(in, s1, len, pre.get(s));
		if(index==-1)
			return false;
		
		boolean leftCheck = checkTree(pre, s + 1, in, s1, post, s2, index-s1);

		boolean rightCheck = checkTree(pre, s + (index-s1) + 1, in, s1 + (index-s1) + 1, post, s2 + index-s1, len - (index - s1) - 1);

		return (leftCheck && rightCheck);

	}

	public static int findIndex(ArrayList<Integer> in, int start, int len, int data) {
		for (int i = start; i <start + len; i++) {
			if (in.get(i) == data)
				return i;
		}

		return -1;
	}

}
