package twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
923. 3Sum With Multiplicity
Given an integer array A, and an integer target, return the number of tuples i, j, k  
such that i < j < k and A[i] + A[j] + A[k] == target.

As the answer can be very large, return it modulo 10^9 + 7.
		
Example 1:
	Input: A = [1,1,2,2,3,3,4,4,5,5], target = 8
	Output: 20
	Explanation: 
	Enumerating by the values (A[i], A[j], A[k]):
	(1, 2, 5) occurs 8 times;
	(1, 3, 4) occurs 8 times;
	(2, 2, 4) occurs 2 times;
	(2, 3, 3) occurs 2 times.
	
Example 2:	
	Input: A = [1,1,2,2,2,2], target = 5
	Output: 12
	Explanation: 
	A[i] = 1, A[j] = A[k] = 2 occurs 12 times:
	We choose one 1 from [1,1] in 2 ways,
	and two 2s from [2,2,2,2] in 6 ways.
 
Note:
	1. 3 <= A.length <= 3000
	2. 0 <= A[i] <= 100
	3. 0 <= target <= 300
*/
public class ThreeSumWithMultiplicity923 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		String[] input = br.readLine().split(",");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int target = Integer.parseInt(br.readLine());

		System.out.println(threeSumMulti(arr, target));
	}

	public static int threeSumMulti(int[] A, int target) {
		long ans = 0L;
		long mod = 1000000007;
		Arrays.sort(A);
		
		for (int i = 0; i < A.length - 2; i++) {
			int l = i + 1, r = A.length - 1;
			while (l < r) {
				int sum = A[i] + A[l] + A[r];
				if (sum < target)
					l++;
				else if (sum > target)
					r--;
				else if (A[l] != A[r]) {
					long count_l = 1, count_r = 1;
					while (l < r && A[l] == A[l + 1]) {
						l++;
						count_l++;
					}
					while (r > l && A[r] == A[r - 1]) {
						r--;
						count_r++;
					}

					ans += count_l * count_r;
					ans %= mod;

					l++;
					r--;
				}
				else {
					ans += (r-l+1)*(r-l) / 2;
					ans %= mod;
					break;
				}

			}

		}

		return (int) ans;

	}

}
