package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.channels.FileChannel.MapMode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

class edge {

	int s, e;
	int dist;

	public edge(int s, int e, int dist) {
		this.s = s;
		this.e = e;
		this.dist = dist;
	}
}

public class Dijsktra {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int A = Integer.parseInt(br.readLine());

		int n = Integer.parseInt(br.readLine());
		int[][] arr = new int[n][3];

		String st[];
		for (int i = 0; i < n; i++) {
			st = br.readLine().trim().split(", ");
			for (int j = 0; j < 3; j++)
				arr[i][j] = Integer.parseInt(st[j]);
		}

		int C = Integer.parseInt(br.readLine());

		System.out.println(Arrays.toString(solve(A, arr, C)));
	}

	public static int[] solve(int A, int[][] B, int C) {
		int[] dist = new int[A];
		Arrays.fill(dist, Integer.MAX_VALUE);

		Map<Integer, ArrayList<edge>> map = new HashMap<>();
		for (int i = 0; i < B.length; i++) {
			if (map.get(B[i][0]) == null)
				map.put(B[i][0], new ArrayList<>());
			if (map.get(B[i][1]) == null)
				map.put(B[i][1], new ArrayList<>());

			map.get(B[i][0]).add(new edge(B[i][0], B[i][1], B[i][2]));
			map.get(B[i][1]).add(new edge(B[i][1], B[i][0], B[i][2]));

		}

		Queue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {

			public int compare(Integer o1, Integer o2) {

				return dist[o1] - dist[o2];
			}

		});

		dist[C] = 0;
		for (int i = 0; i < A; i++)
			q.offer(i);

		while (!q.isEmpty()) {
			int t = q.poll();
			
			if(map.get(t) == null || dist[t] == -1 || dist[t] == Integer.MAX_VALUE) {
				dist[t] = -1;
				continue;
			}
			
			for (edge neighbour : map.get(t)) {
				if (q.contains(neighbour.e)) {
					q.remove(neighbour.e);
					dist[neighbour.e] = Math.min(dist[neighbour.e], dist[t] + neighbour.dist);
					q.offer(neighbour.e);
				}
			}
		}

		dist[C] = 0;
		
		return dist;
	}

}
