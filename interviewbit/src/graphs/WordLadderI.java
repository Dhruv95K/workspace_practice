package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordLadderI {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String beginWord = br.readLine();
		String endWord = br.readLine();
		int n = Integer.parseInt(br.readLine());

		ArrayList<String> wordList = new ArrayList<>();
		String[] input = br.readLine().split(",");

		for (int i = 0; i < n; i++)
			wordList.add(input[i]);

		System.out.println(solve(beginWord, endWord, wordList));
	}

	public static int solve(String beginWord, String endWord, ArrayList<String> wordList) {
		Map<String,Integer> distance = new HashMap<>();
		distance.put(beginWord, 0);
		Queue<String> q = new LinkedList<>();
		Set<String> dict = new HashSet<>(wordList);
		dict.add(beginWord);
		
		q.offer(beginWord);
		
		while(!q.isEmpty()) {
			String temp = q.poll();
			int curdist = distance.get(temp);
			
			if(temp.equals(endWord))
				break;
			
			ArrayList<String> neighbours = getNeighbours(temp,dict);
			for(String neighbour : neighbours) {
				if(distance.get(neighbour) == null) {
					distance.put(neighbour, curdist+1);
					q.offer(neighbour);
				}
			}
		}
		
		if(distance.get(endWord)!=null)
			return distance.get(endWord) + 1;
		else 
			return 0;
	}
	
	private static ArrayList<String> getNeighbours(String s, Set<String> dict) {
		ArrayList<String> neighbours = new ArrayList<>();
		
		for(String word : dict) {
			if(isAdjacent(s,word)) 
				neighbours.add(word);
		}
		
		for(String neighbour : neighbours)
			dict.remove(neighbour);
		
		return neighbours;
	}

	private static boolean isAdjacent(String s, String word) {
		if(s.length()!=word.length())
			return false;
		
		int cnt = 0;
		for(int i = 0; i<s.length();i++) {
			if(s.charAt(i) != word.charAt(i))
				cnt++;
			if(cnt > 1)
				return false;
		}
		
		return cnt == 1;
	}
}
