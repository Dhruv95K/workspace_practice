import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
937. Reorder Data in Log Files
You have an array of logs.  Each log is a space delimited string of words.

For each log, the first word in each log is an alphanumeric identifier.  Then, either:

Each word after the identifier will consist only of lowercase letters, or;
Each word after the identifier will consist only of digits.
We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.

Return the final order of the logs.

Example 1:

	Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
	Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 

Constraints:

1. 0 <= logs.length <= 100
2. 3 <= logs[i].length <= 100
3. logs[i] is guaranteed to have an identifier, and a word after the identifier.
*/

public class ReorderDataInLogFiles {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		String[] st = new String[n];
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < n; i++)
			st[i] = input[i];

		String[] ans = reOrderLogs(st);

		System.out.println(ans);

	}

	private static String[] reOrderLogs(String[] st) {

		Arrays.sort(st, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				String[] a = o1.split(" ",2);
				String[] b = o2.split(" ",2);
				boolean isDigit1 = Character.isDigit(a[1].charAt(0)); 
				boolean isDigit2 = Character.isDigit(b[1].charAt(0));
				
				if(!isDigit1 && !isDigit2){
					int score = a[1].compareTo(b[1]);
					if(score<0)
						return -1;
					else if(score>0)
						return 1;
					else
						return a[0].compareTo(b[0]);
				}
				
				return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
			}

		});

		return st;
	}

}
