package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class SortByFreq {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(sc.readLine());
		while (n != 0) {
			int size = Integer.parseInt(sc.readLine());
			int arr[] = new int[size];
			String[] temp = sc.readLine().trim().split("\\s+");

			for (int i = 0; i < size; i++)
				arr[i] = Integer.parseInt(temp[i]);

			sortByFreq(arr, size);
			System.out.println();
			n--;
		}
	}

	static void sortByFreq(int arr[], int n) {
		// add your code here
		Map<Integer, Integer> m = new HashMap<>();
		for (int i : arr) {
			m.put(i, m.getOrDefault(i, 0) + 1);
		}

		List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(m.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				if (o1.getValue() > o2.getValue())
					return -1;
				else if (o1.getValue() == o2.getValue()) {
					return o1.getKey().compareTo(o2.getKey());
				} else
					return 1;
			}
		});

		
		StringBuilder sb = new StringBuilder();

		HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
		for (Map.Entry<Integer, Integer> aa : list) {
			temp.put(aa.getKey(), aa.getValue());
		}

		for (Map.Entry<Integer, Integer> me : list) {
			int key = me.getKey();
			int val = me.getValue();
			
			for(int i=0;i<val;i++)
				sb.append(key+" ");	
		}
		

		System.out.print(sb.toString().trim());
	}

}
