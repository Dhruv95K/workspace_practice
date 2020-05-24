import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
1124. Longest Well-Performing Interval
We are given hours, a list of the number of hours worked per day for a given employee.

A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.

A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.

Return the length of the longest well-performing interval.

Example 1:	
	Input: hours = [9,9,6,0,6,6,9]
	Output: 3
	Explanation: The longest well-performing interval is [9,9,6].
 
Constraints:
	1. 1 <= hours.length <= 10000
	2. 0 <= hours[i] <= 16
*/
public class LongestWellPerformingInterval {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		String[] input = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int ans = longestWPI(arr);
		System.out.println(ans);
	}

	public static int longestWPI(int[] hours) {
		int n = hours.length;
		for(int i=0;i<n;i++) {
			if(hours[i] <=8)
				hours[i] = -1;
			else
				hours[i] = 1;
		}
		
		int ans = findInterval(hours);
		return 0;
	}

	private static int findInterval(int[] hours) {
		Map<Integer,Integer> map = new HashMap<>();
		int n = hours.length;
		int curr = 0;
		int max = 0;
		
		for(int i=0;i<n;i++) {
			curr+=hours[i];
			if(curr > 0)
				max = i+1;
			else {
				if(map.containsKey(curr-1))
					max = Math.max(max, i - map.get(curr - 1));
				
				if(map.get(curr)==null)
					map.put(curr, i);
			}
		}
		
		return max;
		
	}
}
