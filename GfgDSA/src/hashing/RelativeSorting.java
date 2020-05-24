package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class RelativeSorting {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		while(t-->0) {
			
			String[] inputLine = br.readLine().split(" ");
			int n = Integer.parseInt(inputLine[0]);
			int m = Integer.parseInt(inputLine[1]);
			int arr1[] = new int[n];
			int arr2[] = new int[m];
			HashMap<Integer,Integer> map = new HashMap<>();
			
			inputLine = br.readLine().split(" ");
			for(int i = 0;i<n;i++) {
				arr1[i] = Integer.parseInt(inputLine[i]);
				map.put(arr1[i], map.getOrDefault(arr1[i], 0) + 1);
			}
			inputLine = br.readLine().split(" ");
			for(int i = 0;i<m;i++) {
				arr2[i] = Integer.parseInt(inputLine[i]);
			}
			
			printSorted(arr1,arr2,map);
			System.out.println();
		}
		
	}

	private static void printSorted(int[] arr1, int[] arr2, HashMap<Integer, Integer> map) {
		// TODO Auto-generated method stub
		ArrayList<Integer> l1 = new ArrayList<>();
		for(int i : arr2) {
			if(map.containsKey(i)) {
				int c = map.get(i);
				while(c-->0)
					l1.add(i);
				map.remove(i);
			}
		}
		
		ArrayList<Integer> l2 = new ArrayList<>();
		for(Integer i:map.keySet()) {
			int c = map.get(i);
			while(c-->0)
				l2.add(i);
		}
		Collections.sort(l2);
		l1.addAll(l2);
		
		for(int i : l1) {
			System.out.print(i+" ");
		}
	}
	
}
