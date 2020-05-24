package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Leader {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[n];
			String inputLine[] = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(inputLine[i]);
			}

			Leader obj = new Leader();

			StringBuffer str = new StringBuffer();
			ArrayList<Integer> res = new ArrayList<Integer>();
			res = obj.leaders(arr, n);

			for (int i = res.size() - 1; i >= 0; i--) {
				str.append(res.get(i) + " ");
			}
			System.out.println(str);
		}
	}

	static ArrayList<Integer> leaders(int arr[], int n) {

		// Your code here
		/******************
		 * You just need to complete this function and return the vector containing the
		 * leaders.
		 ***************/
		int max = arr[n - 1];
		ArrayList<Integer> l = new ArrayList<Integer>(n);
		l.add(max);
		for (int i = n - 2; i >= 0; i--) {
			if (arr[i] > max) {
				max = arr[i];	
				l.add(max);
			} else
				arr[i] = max;
		}

	//	Collections.reverse(l);

		return l;
	}

}
