package backtracking;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CombinationIterator1286 {

	public static void main(String[] args) {

	}

	Map<Character, Integer> ch2id;
	Stack<Character> st;
	String result,str;
	int combLength;

	public CombinationIterator1286(String characters, int combinationLength) {
		ch2id = new HashMap<Character, Integer>();
		st = new Stack<>();
		combLength = combinationLength;
		str = characters;
		result = "";
		
		int ind = 0;
		for (char ch : characters.toCharArray())
			ch2id.put(ch, ind++);

		for (int i = 0; i < combinationLength; i++) {
			st.push(characters.charAt(i));
			result += characters.charAt(i);
		}

	}

	public String next() {
		String currResult = result;

		int indx = str.length() - 1;
		while (!st.isEmpty() && ch2id.get(st.peek()) == indx) {
			st.pop();
			indx--;
			result = result.substring(0, result.length() - 1);
		}
		
		if(st.isEmpty()) 
			return currResult;
		
		indx = ch2id.get(st.pop());
		result = result.substring(0, result.length() - 1);
		
		while(st.size() < combLength) {
			char temp = str.charAt(++indx);
			result += temp;
			st.push(temp);
		}

		return currResult;
	}
	
	public boolean hasNext() {
		return !st.isEmpty();
	}
}
