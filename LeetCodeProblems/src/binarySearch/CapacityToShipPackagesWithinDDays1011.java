package binarySearch;
/*
1011. Capacity To Ship Packages Within D Days
A conveyor belt has packages that must be shipped from one port to another within D days.
The i-th package on the conveyor belt has a weight of weights[i].  Each day, we load the 
ship with packages on the conveyor belt (in the order given by weights). We may not load more 
weight than the maximum weight capacity of the ship.

Return the least weight capacity of the ship that will result in all the packages on the 
conveyor belt being shipped within D days.
Example 1:
	Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
	Output: 15
	Explanation: 
	A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
	1st day: 1, 2, 3, 4, 5
	2nd day: 6, 7
	3rd day: 8
	4th day: 9
	5th day: 10

Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and 
splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed. 

Example 2:
	Input: weights = [3,2,2,4,1,4], D = 3
	Output: 6
	Explanation: 
	A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
	1st day: 3, 2
	2nd day: 2, 4
	3rd day: 1, 4

Example 3:
	Input: weights = [1,2,3,1,1], D = 4
	Output: 3
	Explanation: 
	1st day: 1
	2nd day: 2
	3rd day: 3
	4th day: 1, 1
 

Note:
	1. 1 <= D <= weights.length <= 50000
	2. 1 <= weights[i] <= 500

*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CapacityToShipPackagesWithinDDays1011 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] arr = new int[n];
		String[] input = br.readLine().split(",");
		for (int i = 0; i < n; i++)
			arr[i] = Integer.parseInt(input[i]);

		int D = Integer.parseInt(br.readLine());

		System.out.println(shipWithinDays(arr, D));
	}

	public static int shipWithinDays(int[] weights, int D) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int weight : weights) {
			sum += weight;
			max = Math.max(max, weight);
		}

		int l = max, r = sum;
		int ans = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			int days = calculateDaystoShip(weights, mid);
			if (days <= D) {
				ans = mid;
				r = mid - 1;
			} else
				l = mid + 1;
		}
		
		return ans;
	}

	private static int calculateDaystoShip(int[] weights, int capacity) {
		int curDay = 1;
		int curSum = 0;

		for (int weight : weights) {
			curSum += weight;
			if (curSum > capacity) {
				curDay++;
				curSum = weight;
			}
		}

		return curDay;
	}

}
