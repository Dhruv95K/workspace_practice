package hiringContests.EskoMay17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class VictorWarehousing {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] units = br.readLine().split(",");
		Map<String, Integer> nodes = new HashMap<>();
		for (int i = 0; i < units.length; i++)
			nodes.put(units[i], i);

		int n = units.length;

		int[][] adjMatrix = new int[n][n];

		Map<String, String> map = new HashMap<>();
		for (int i = 0; i < n - 1; i++) {
			String[] input = br.readLine().split("=");
			String from = input[0].trim();
			String[] right = input[1].trim().split(" ");
			int cost = Integer.parseInt(right[0]);
			String to = right[1];
			map.put(from, to);

			adjMatrix[nodes.get(from)][nodes.get(to)] = cost;
		}

		int lastLevel = -1;
		String last = "";
		for (String key : units) {
			if (map.get(key) == null) {
				lastLevel = nodes.get(key);
				last = key;
				break;
			}
		}

		Map<Integer, String> count = new TreeMap<>(Collections.reverseOrder());

		for (String key : map.keySet()) {
			if (nodes.get(key) == lastLevel)
				continue;

			String from = key;
			String to = map.get(key);
			int nodeFrom = nodes.get(from);
			int nodeTo = nodes.get(to);
			int c = adjMatrix[nodeFrom][nodeTo];

			while (nodeTo != lastLevel) {
				from = to;
				to = map.get(to);
				nodeFrom = nodes.get(from);
				nodeTo = nodes.get(to);

				c = c * adjMatrix[nodeFrom][nodeTo];
			}
			count.put(c, key);
		}

		count.put(1, last);

		ArrayList<Integer> list = new ArrayList<Integer>(count.keySet());
		int cnt = 1;
		
		for (int i = 0; i < list.size() - 1; i++) {
			int c = list.get(i);
			String st = count.get(list.get(i));
			
			System.out.print(cnt+st + " = ");
			cnt = (c * cnt) / list.get(i + 1);
		}
		
		System.out.print(cnt+last);
	}

}
