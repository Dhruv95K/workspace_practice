package binarySearch;
/*
436. Find Right Interval
Given a set of intervals, for each of the interval i, check if there exists an interval j whose start 
point is bigger than or equal to the end point of the interval i, which can be called that j is on 
the "right" of i.

For any interval i, you need to store the minimum interval j's index, which means that the interval 
j has the minimum start point to build the "right" relationship for interval i. If the interval j 
doesn't exist, store -1 for the interval i. Finally, you need output the stored value of each interval 
as an array.

Note:
	1. You may assume the interval's end point is always bigger than its start point.
	2. You may assume none of these intervals have the same start point.
 
Example 1:
	Input: [ [1,2] ]
	Output: [-1]
	Explanation: There is only one interval in the collection, so it outputs -1.
 
Example 2:
	Input: [ [3,4], [2,3], [1,2] ]
	Output: [-1, 0, 1]
	Explanation: There is no satisfied "right" interval for [3,4].
	For [2,3], the interval [3,4] has minimum-"right" start point;
	For [1,2], the interval [2,3] has minimum-"right" start point.
 
Example 3:
	Input: [ [1,4], [2,3], [3,4] ]
	Output: [-1, 2, -1]
	Explanation: There is no satisfied "right" interval for [1,4] and [3,4].
	For [2,3], the interval [3,4] has minimum-"right" start point.
	NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to 
	get new method signature.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRightInterval436 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][m];
		String[] input;

		for (int i = 0; i < n; i++) {
			input = br.readLine().split(",");
			for (int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(input[i]);
		}

	}

	public int[] findRightInterval(int[][] intervals) {
		int n = intervals.length;
		int[] ans = new int[intervals.length];
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for(int i = 0;i<n;i++) {
			list.add(intervals[i][0]);
			map.put(intervals[i][0], i);
		}

		Collections.sort(list);
		int j = 0;
		for(int[] interval : intervals) {
			int index = findGreaterOrEqual(list,interval[1]);
			if(index == -1)
				ans[j++] = -1;
			else
				ans[j++] = map.get(list.get(index));
		}
		
		return ans;
	}

	private int findGreaterOrEqual(List<Integer> list, int key) {
		int l = 0,r = list.size()-1;
		int ans = -1;
		while(l <= r){
			int mid = l + (r-l)/2;
			if(list.get(mid) >= key) {
				ans = mid;
				r = mid-1;
			}
			else
				l = mid+1;
		}
		
		return ans;
	}
}
