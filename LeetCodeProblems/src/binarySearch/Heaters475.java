package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
475. Heaters
Winter is coming! Your first job during the contest is to design a standard heater with fixed 
warm radius to warm all the houses.
Now, you are given positions of houses and heaters on a horizontal line, find out minimum 
radius of heaters so that all houses could be covered by those heaters.
So, your input will be the positions of houses and heaters seperately, and your expected output will 
be the minimum radius standard of heaters.

Note:
	1. Numbers of houses and heaters you are given are non-negative and will not exceed 25000.
	2. Positions of houses and heaters you are given are non-negative and will not exceed 10^9.
	3. As long as a house is in the heaters' warm radius range, it can be warmed.
	4. All the heaters follow your radius standard and the warm radius will the same.
 
Example 1:
	Input: [1,2,3],[2]
	Output: 1
	Explanation: The only heater was placed in the position 2, and if we use the radius 1 standard, 
		then all the houses can be warmed.
	 

Example 2:	
	Input: [1,2,3,4],[1,4]
	Output: 1
	Explanation: The two heater was placed in the position 1 and 4. We need to use radius 1 standard, 
		then all the houses can be warmed.
*/

public class Heaters475 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[] houses = new int[n];
		int[] heaters = new int[m];

		String[] input = br.readLine().split(",");
		for (int i = 0; i < n; i++)
			houses[i] = Integer.parseInt(input[i]);

		for (int i = 0; i < m; i++)
			heaters[i] = Integer.parseInt(input[i]);

		System.out.println(findRadius(houses, heaters));
	}

	private static int findRadius(int[] houses, int[] heaters) {
		Arrays.sort(houses);
        Arrays.sort(heaters);
        
        int i = 0, j = 0, res = 0;
        while (i < houses.length) {
            while (j < heaters.length - 1
                && Math.abs(heaters[j + 1] - houses[i]) <= Math.abs(heaters[j] - houses[i])) {
                j++;
            }
            res = Math.max(res, Math.abs(heaters[j] - houses[i]));
            i++;
        }
        
        return res;
		
	}



	public static int findRadiusBinarySearch(int[] houses, int[] heaters) {
		Arrays.sort(heaters);
		int res = 0;

		for (int house : houses) {
			int leftHeater = findLessThan(heaters, house);
			int rightHeater = findGreaterThan(heaters, house);

			int leftRadius = leftHeater == -1 ? Integer.MAX_VALUE : house - heaters[leftHeater];
			int rightRadius = rightHeater == -1 ? Integer.MAX_VALUE : heaters[rightHeater] - house;

			int radius = Math.min(leftRadius,rightRadius);
			res = Math.max(res, radius);
		}
		
		return res;
	}

	private static int findGreaterThan(int[] heaters, int target) {
		int l = 0, r = heaters.length - 1;
		int ans = -1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (heaters[mid] >= target) {
				ans = mid;
				r = mid - 1;
			} else
				l = mid + 1;
		}

		return ans;
	}

	private static int findLessThan(int[] heaters, int target) {
		int l = 0, r = heaters.length - 1;
		int ans = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (heaters[mid] <= target) {
				ans = mid;
				l = mid + 1;
			} else
				r = mid - 1;
		}

		return ans;
	}
}
