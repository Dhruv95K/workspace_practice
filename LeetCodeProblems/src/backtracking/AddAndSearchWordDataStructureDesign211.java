package backtracking;
/*
211. Add and Search Word - Data structure design
Design a data structure that supports the following two operations:

void addWord(word)
bool search(word)
search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . 
means it can represent any one letter.

Example:
	addWord("bad")
	addWord("dad")
	addWord("mad")
	search("pad") -> false
	search("bad") -> true
	search(".ad") -> true
	search("b..") -> true
Note:
	1. You may assume that all words are consist of lowercase letters a-z.
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AddAndSearchWordDataStructureDesign211 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class WordDictionary {
	Map<Integer, List<String>> map;

	public WordDictionary() {
		map = new HashMap<Integer, List<String>>();
	}

	public void addWord(String word) {
		int index = word.length();
		List<String> l;
		if (map.get(index) == null) {
			l = new ArrayList<String>();
			map.put(index, l);
		} else
			l = map.get(index);

		map.get(index).add(word);
	}

	public boolean search(String word) {
		int index = word.length();
		if (map.get(index) == null)
			return false;
		
		if(map.get(index).contains(word))
			return true;
		
		for(String s : map.get(index))
			if(isSame(word,s))
				return true;
		
		return false;
	}

	private boolean isSame(String word, String s) {
		for(int i = 0;i<word.length();i++) {
			if(word.charAt(i) != s.charAt(i) || word.charAt(i) != '.')
				return false;
		}
		return true;
	}
}
