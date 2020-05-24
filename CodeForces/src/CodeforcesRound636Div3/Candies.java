package CodeforcesRound636Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Candies {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			System.out.println(candies(n));
		}

	}

	private static int candies(int n) {
		int lo = 2;
		int hi = (int) (Math.log(n + 1) / Math.log(2));
		int ans = 0;

		for (int k = lo; k <= hi; k++) {
			int pow = (int) Math.pow(2, k);
			if (n % (pow - 1) == 0) {
				ans = n / (pow - 1);
				break;
			}
		}
		
		return ans;
	}

}
