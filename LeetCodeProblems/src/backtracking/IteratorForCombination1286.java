package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

/*
1286. Iterator for Combination
Design an Iterator class, which has:

1. A constructor that takes a string characters of sorted distinct lowercase English letters and a number 
combinationLength as arguments.
2. A function next() that returns the next combination of length combinationLength in lexicographical order.
3. A function hasNext() that returns True if and only if there exists a next combination.
 

Example:
	CombinationIterator iterator = new CombinationIterator("abc", 2); // creates the iterator.
	
	iterator.next(); // returns "ab"
	iterator.hasNext(); // returns true
	iterator.next(); // returns "ac"
	iterator.hasNext(); // returns true
	iterator.next(); // returns "bc"
	iterator.hasNext(); // returns false
	 
Constraints:
	
	1. 1 <= combinationLength <= characters.length <= 15
	2. There will be at most 10^4 function calls per test.
	3. It's guaranteed that all calls of the function next are valid.
*/
public class IteratorForCombination1286 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String characters = br.readLine();
		int combinationLength = Integer.parseInt(br.readLine());

		CombinationIterator obj = new CombinationIterator(characters, combinationLength);

		for (int i = 0; i < 3; i++) {
			String param_1 = obj.next();
			boolean param_2 = obj.hasNext();
		}
	}

}

class CombinationIterator {
	Queue<String> pq;

	public CombinationIterator(String characters, int combinationLength) {
		pq = new PriorityQueue<>();
		generateCombinations(characters, combinationLength, 0, new StringBuilder());
	}

	private void generateCombinations(String characters, int combinationLength, int ind, StringBuilder sb) {
		if (combinationLength == 0) {
			pq.add(sb.toString());
			return;
		}
		
		if (ind == characters.length())
			return;

		/*sb.append(characters.charAt(ind));
		generateCombinations(characters, combinationLength - 1, ind + 1, sb);
		sb.deleteCharAt(sb.length() - 1);

		generateCombinations(characters, combinationLength, ind + 1, sb);*/
		
		for(int i = ind;i < characters.length();i++) {
			sb.append(characters.charAt(i));
			generateCombinations(characters, combinationLength - 1, i + 1, sb);
			sb.deleteCharAt(sb.length() - 1);
		}
			
	}

	public String next() {
		if(this.hasNext())
			return pq.poll();
		return "";
	}

	public boolean hasNext() {
		return !pq.isEmpty();
	}
}
