package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SubarrayWithSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int arr[] = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}
			int sum = sc.nextInt();
			System.out.println(new SubarrayWithSum().subArraySum(arr, n, sum));

		}
	}

	static int subArraySum(int arr[], int n, int sum) {
		// add your code here
		Map<Integer,Integer> countSum = new HashMap<>();
		int curr_sum = 0;
		int count = 0;
		for(int i=0;i<n;i++) {
			curr_sum+=arr[i];
			
			if(curr_sum==sum) {
				count = count + 1;
			} 
			
			count += countSum.getOrDefault(curr_sum-sum, 0);
			
			Integer c = countSum.get(curr_sum);
			if(c==null)
				countSum.put(curr_sum, 1);
			else
				countSum.put(curr_sum, c+1);
		}
		
		return count;
	}

}
