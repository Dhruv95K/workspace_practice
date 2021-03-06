package binarySearch;
/*
981. Time Based Key-Value Store
Create a timebased key-value store class TimeMap, that supports two operations.

1. set(string key, string value, int timestamp)
	Stores the key and value, along with the given timestamp.
	
2. get(string key, int timestamp)
	1. Returns a value such that set(key, value, timestamp_prev) was called previously, with timestamp_prev <= timestamp.
	2. If there are multiple such values, it returns the one with the largest timestamp_prev.
	3. If there are no values, it returns the empty string ("").
 
Example 1:
	Input: inputs = ["TimeMap","set","get","get","set","get","get"], inputs = [[],["foo","bar",1],["foo",1],["foo",3],["foo","bar2",4],["foo",4],["foo",5]]
	Output: [null,null,"bar","bar",null,"bar2","bar2"]
	Explanation:   
	TimeMap kv;   
	kv.set("foo", "bar", 1); // store the key "foo" and value "bar" along with timestamp = 1   
	kv.get("foo", 1);  // output "bar"   
	kv.get("foo", 3); // output "bar" since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 ie "bar"   
	kv.set("foo", "bar2", 4);   
	kv.get("foo", 4); // output "bar2"   
	kv.get("foo", 5); //output "bar2"   

Example 2:
	Input: inputs = ["TimeMap","set","set","get","get","get","get","get"], inputs = [[],["love","high",10],["love","low",20],["love",5],["love",10],["love",15],["love",20],["love",25]]
	Output: [null,null,null,"","high","high","low","low"]
 
Note:	
	1. All key/value strings are lowercase.
	2. All key/value strings have length in the range [1, 100]
	3. The timestamps for all TimeMap.set operations are strictly increasing.
	4. 1 <= timestamp <= 10^7
	5. TimeMap.set and TimeMap.get functions will be called a total of 120000 times (combined) per test case.
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TimeBasedKeyValueStore981 {

	public static void main(String[] args) {

	}

}

class TimeMap {

	Map<String, Map<Integer,String>> map;

	public TimeMap() {
		map = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if (map.get(key) == null)
			map.put(key, new TreeMap<>());

		map.get(key).put(timestamp, value);
	}

	public String get(String key, int timestamp) {
		if (map.get(key) == null || map.get(key).isEmpty())
			return "";
			
		List<Integer> list = new ArrayList<>(map.get(key).keySet());
		//Collections.sort(list);
		
		int l = 0, r = list.size() - 1;
		int ans = -1;
		
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (list.get(mid) <= timestamp) {
				ans = mid;
				l = mid + 1;
			} else
				r = mid - 1;
		}
		
		if(ans == -1)
			return "";
		
		return map.get(key).get(list.get(ans));
	}
}

class time {
	String value;
	int timestamp;

	public time(int timestamp, String value) {
		this.value = value;
		this.timestamp = timestamp;
	}
}
/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
 * obj.get(key,timestamp);
 */
