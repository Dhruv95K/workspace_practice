package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Step {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(read.readLine());

			int arr[] = new int[n];

			String st[] = read.readLine().trim().split("\\s+");

			for (int i = 0; i < n; i++)
				arr[(int) i] = Integer.parseInt(st[(int) i]);

			System.out.println(new Step().maxStep(arr, n));
		}
	}

	static int maxStep(int arr[], int n) {

		int maxCount = 0;
		int count = 0;

		for (int i = 1; i < n; i++) {
			if (arr[i] > arr[i - 1]) {
				count++;
			} else {
				if (maxCount < count)
					maxCount = count;
				count = 0;
			}
		}
		
		if (maxCount < count)
			maxCount = count;

		return maxCount;
	}
}
