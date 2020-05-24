package binarySearch;

import java.util.HashMap;
import java.util.Map;

/*
911. Online Election
In an election, the i-th vote was cast for persons[i] at time times[i].
Now, we would like to implement the following query function: TopVotedCandidate.q(int t) will return the number of the person 
that was leading the election at time t.  
		
Votes cast at time t will count towards our query.  In the case of a tie, the most recent vote (among tied candidates) wins.

Example 1:
	Input: ["TopVotedCandidate","q","q","q","q","q","q"], [[[0,1,1,0,0,1,0],[0,5,10,15,20,25,30]],[3],[12],[25],[15],[24],[8]]
	Output: [null,0,1,1,0,0,1]
	Explanation: 
	At time 3, the votes are [0], and 0 is leading.
	At time 12, the votes are [0,1,1], and 1 is leading.
	At time 25, the votes are [0,1,1,0,0,1], and 1 is leading (as ties go to the most recent vote.)
	This continues for 3 more queries at time 15, 24, and 8.
	 
Note:
	1. 1 <= persons.length = times.length <= 5000
	2. 0 <= persons[i] <= persons.length
	3. times is a strictly increasing array with all elements in [0, 10^9].
	4. TopVotedCandidate.q is called at most 10000 times per test case.
	5. TopVotedCandidate.q(int t) is always called with t >= times[0].
*/

public class OnlineElection911 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class TopVotedCandidate {
	int[] times;
	Map<Integer, Integer> map;

	public TopVotedCandidate(int[] persons, int[] times) {
		this.times = times;
		map = new HashMap<>();
		int[] count = new int[persons.length+1];
		int lead = -1;
		for (int i = 0; i < persons.length; i++) {
			count[persons[i]]++;
			if(i==0 || count[persons[i]] >= count[lead]) {
				lead = persons[i];
			}
			map.put(times[i], lead);
		}
	}

	public int q(int t) {
		int time_index = findLowerOrEqual(times, t);
		int ans = -1;
		ans = map.get(times[time_index]);
		return ans;

	}

	private int findLowerOrEqual(int[] times, int t) {
		int l = 0, r = times.length - 1;
		int ans = -1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (times[mid] <= t) {
				ans = mid;
				l = mid + 1;
			} else
				r = mid - 1;
		}
		
		return ans;
	}
}


/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times); int param_1 =
 * obj.q(t);
 */
