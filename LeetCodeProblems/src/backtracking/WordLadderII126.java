package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
126. Word Ladder II
Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) 
from beginWord to endWord, such that:

	1. Only one letter can be changed at a time
	2. Each transformed word must exist in the word list. Note that beginWord is not a transformed word.

Note:
	Return an empty list if there is no such transformation sequence.
	All words have the same length.
	All words contain only lowercase alphabetic characters.
	You may assume no duplicates in the word list.
	You may assume beginWord and endWord are non-empty and are not the same.
	
Example 1:
	Input:
	beginWord = "hit",
	endWord = "cog",
	wordList = ["hot","dot","dog","lot","log","cog"]	
	Output:
	[
	  ["hit","hot","dot","dog","cog"],
	  ["hit","hot","lot","log","cog"]
	]
		
Example 2:
	Input:
	beginWord = "hit"
	endWord = "cog"
	wordList = ["hot","dot","dog","lot","log"]
	Output: []

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.

*/
public class WordLadderII126 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String beginWord = br.readLine();
		String endWord = br.readLine();
		int n = Integer.parseInt(br.readLine());

		ArrayList<String> wordList = new ArrayList<>();
		String[] input = br.readLine().split(", ");

		for (int i = 0; i < n; i++)
			wordList.add(input[i]);

		System.out.println(findLadders(beginWord, endWord, wordList));

	}

	static ArrayList<ArrayList<String>> result;
	static Map<String, ArrayList<String>> adjacentNeighbours;
	static Map<String, Integer> distance;

	public static ArrayList<ArrayList<String>> findLadders(String beginWord, String endWord, ArrayList<String> wordList) {
		result = new ArrayList<ArrayList<String>>();
		HashSet<String> dict = new HashSet<String>(wordList);
		dict.add(beginWord);
		adjacentNeighbours = new HashMap<String, ArrayList<String>>();
		distance = new HashMap<String, Integer>();

		if (wordList.contains(endWord)) {
			doBFS(beginWord, endWord, dict);
			if (distance.get(endWord) != null)
				doDFS(beginWord, endWord, new ArrayList<>());
		}
		return result;
	}

	private static void doDFS(String cur, String endWord, ArrayList<String> temp) {
		if (distance.get(cur) == null || distance.get(cur) > distance.get(endWord))
			return;

		temp.add(cur);
		if (cur.equals(endWord)) {
			result.add(new ArrayList<>(temp));
		} else {
			for (String neighbour : adjacentNeighbours.get(cur)) {
				if (distance.get(neighbour) == distance.get(cur) + 1)
					doDFS(neighbour, endWord, temp);
			}

		}

		temp.remove(temp.size() - 1);
	}

	private static void doBFS(String beginWord, String endWord, Set<String> dict) {
		for (String word : dict)
			adjacentNeighbours.put(word, new ArrayList<String>());
		// adjacentNeighbours.put(beginWord, new ArrayList<>());

		Queue<String> q = new LinkedList<>();
		q.add(beginWord);
		distance.put(beginWord, 0);

		while (!q.isEmpty()) {
			String temp = q.poll();
			int currDist = distance.get(temp);
			if (temp.equals(endWord))
				break;

			List<String> neighbours = getNeighbours(temp, dict);

			for (String neighbour : neighbours) {
				adjacentNeighbours.get(temp).add(neighbour);
				if (distance.get(neighbour) == null) {
					distance.put(neighbour, currDist + 1);

					q.offer(neighbour);
				}
			}

		}
	}

	private static List<String> getNeighbours(String temp, Set<String> dict) {
		List<String> neighbours = new ArrayList<String>();

		for (String word : dict) {
			if (isNeighbour(temp, word))
				neighbours.add(word);
		}

		return neighbours;
	}

	private static boolean isNeighbour(String temp, String word) {
		int count = 0;
		for (int i = 0; i < temp.length(); i++) {
			if (temp.charAt(i) == word.charAt(i))
				continue;
			else
				count++;
			if (count > 1)
				return false;
		}

		return count == 1;
	}

}
