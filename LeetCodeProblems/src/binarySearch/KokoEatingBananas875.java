package binarySearch;
/*
875. Koko Eating Bananas

Koko loves to eat bananas.  There are N piles of bananas, the i-th pile has piles[i] bananas.  The guards have gone and 
will come back in H hours.
Koko can decide her bananas-per-hour eating speed of K.  Each hour, she chooses some pile of bananas, and eats K bananas 
from that pile.  If the pile has less than K bananas, she eats all of them instead, and won't eat any more bananas during 
this hour.
Koko likes to eat slowly, but still wants to finish eating all the bananas before the guards come back.
Return the minimum integer K such that she can eat all the bananas within H hours.

Example 1:
	Input: piles = [3,6,7,11], H = 8
	Output: 4
	
Example 2:
	Input: piles = [30,11,23,4,20], H = 5
	Output: 30
	
Example 3:
	Input: piles = [30,11,23,4,20], H = 6
	Output: 23
 
Note:

	1. 1 <= piles.length <= 10^4
	2. piles.length <= H <= 10^9
	3. 1 <= piles[i] <= 10^9
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KokoEatingBananas875 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		String[] input = br.readLine().split(",");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(input[i]);

		int H = Integer.parseInt(br.readLine());

		System.out.println(minEatingSpeed(arr, H));
	}

	public static int minEatingSpeed(int[] piles, int h) {
		int max = 0;
	/*	for(int pile : piles)
			max = Math.max(max, pile);*/
				
		int l = 1, r = 1000000000;
		int ans = -1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			int hours = getHoursToEat(piles,mid);
			if(hours <= h) {
				ans = mid;
				r = mid-1;
			}
			else 
				l = mid + 1;
		}

		return ans;
	}

	private static int getHoursToEat(int[] piles, int capacity) {
		int hours = 0;
		for(int pile : piles) {
			hours += (pile + capacity - 1)/capacity;
		}
		
		return hours;
	}

	
}
