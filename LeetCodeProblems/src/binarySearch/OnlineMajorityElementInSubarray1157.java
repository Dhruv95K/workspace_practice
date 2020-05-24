package binarySearch;
/*
1157. Online Majority Element In Subarray
Implementing the class MajorityChecker, which has the following API:
	1. MajorityChecker(int[] arr) constructs an instance of MajorityChecker with the given array arr;
	2. int query(int left, int right, int threshold) has arguments such that:
		a. 0 <= left <= right < arr.length representing a subarray of arr;
		b. 2 * threshold > right - left + 1, ie. the threshold is always a strict majority of the length of the subarray
		
Each query(...) returns the element in arr[left], arr[left+1], ..., arr[right] that occurs at least threshold times, or 
-1 if no such element exists.

Example:	
	MajorityChecker majorityChecker = new MajorityChecker([1,1,2,2,1,1]);
	majorityChecker.query(0,5,4); // returns 1
	majorityChecker.query(0,3,3); // returns -1
	majorityChecker.query(2,3,2); // returns 2
 

Constraints:
	1. 1 <= arr.length <= 20000
	2. 1 <= arr[i] <= 20000
	3. For each query, 0 <= left <= right < len(arr)
	4. For each query, 2 * threshold > right - left + 1
	4. The number of queries is at most 10000
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class OnlineMajorityElementInSubarray1157 {

}

class MajorityChecker {
	private Map<Integer, ArrayList<Integer>> map;
	private int[] nums;
	private int tryBound;

	public MajorityChecker(int[] arr) {
		this.map = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if (map.get(arr[i]) == null)
				map.put(arr[i], new ArrayList<>());
			map.get(arr[i]).add(i);
		}
		tryBound = 20;
		this.nums = arr;
	}

	public int query(int left, int right, int threshold) {
		for (int i = 0; i < tryBound; i++) {
			int a = nums[getRandom(left, right)];
			int count = getOccurence(left, right, a);
			if (count >= threshold)
				return a;
		}

		return -1;
	}

	private int getRandom(int left, int right) {
		Random random = new Random();
		return random.nextInt(right - left + 1) + left;
	}

	private int getOccurence(int left, int right, int a) {
		ArrayList<Integer> list = map.get(a);
		int i = Collections.binarySearch(list, left);
		int j = Collections.binarySearch(list, right);
		if (i == list.size())
			return 0;
		if(i < 0)
			i = -i;	
		if (j < 0)
			j = -j-1;

		return j - i + 1;
	}
}

/**
 * Your MajorityChecker object will be instantiated and called as such:
 * MajorityChecker obj = new MajorityChecker(arr); int param_1 =
 * obj.query(left,right,threshold);
 */