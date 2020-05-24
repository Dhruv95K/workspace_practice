package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
/*
1291. Sequential Digits
An integer has sequential digits if and only if each digit in the number is one more than the previous digit.
Return a sorted list of all the integers in the range [low, high] inclusive that have sequential digits.
 
Example 1:	
	Input: low = 100, high = 300
	Output: [123,234]
			
Example 2:
	Input: low = 1000, high = 13000
	Output: [1234,2345,3456,4567,5678,6789,12345]
 
Constraints:
	1. 10 <= low <= high <= 10^9
*/
import java.util.List;

public class SequentialDigits1291 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int low = Integer.parseInt(br.readLine());
		int high = Integer.parseInt(br.readLine());

		List<Integer> ans = sequentialDigits(low, high);
		System.out.println(ans);
	}

	public static List<Integer> sequentialDigits(int low, int high) {
		List<Integer> ans = new ArrayList<>();

		/*
		 * for(int i = low;i<=high;i++) { if(isSequential(i)) ans.add(i); }
		 */
		int lo = (int) Math.log10(low) + 1;
		int hi = (int) Math.log10(high) + 1;

		String seq = "123456789";

		for (int i = lo; i <= hi; i++) {
			for (int j = 0; j <= 9 - i; j++) {
				int num = Integer.parseInt(seq.substring(j,j+i));
				if(num >= low && num<= high)
					ans.add(num);
			}
		}

		return ans;
	}

	private static boolean isSequential(int num) {
		char[] st = String.valueOf(num).toCharArray();
		for (int i = 0; i < st.length - 1; i++) {
			if (st[i + 1] - st[i] != 1)
				return false;
		}
		return true;
	}

}
