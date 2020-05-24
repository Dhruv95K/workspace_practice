package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SpecialInteger {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String inputLine[] = br.readLine().trim().split(" ");
		int arr[] = new int[n];
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; i++) {
		//	arr[i] = Integer.parseInt(inputLine[i]);
			A.add(Integer.parseInt(inputLine[i]));
		}

		System.out.println(solve(A,130));

	}

	public static int solve(ArrayList<Integer> A, int B) {

		int flg = 0;
		int n = A.size();
		int k = 0;
		for (k = 1; k <= n; k++) {
			int sum = 0;
			for (int i = 0; i < k; i++)
				sum += A.get(i);
			if (sum <= B) {
				for (int i = k; i < n; i++) {
					sum += A.get(i);
					sum -= A.get(i - k);
					if (sum > B)
						return k - 1;
				}

			} else
				return k - 1;
		}

		return n;
	}
	
	public boolean check() {
		
		return false;
	}

}
