package CodeforcesRound636Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WeightsDistributing {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String[] input = br.readLine().split(" ");

			int n = Integer.parseInt(input[0]);
			int m = Integer.parseInt(input[1]);
			int a = Integer.parseInt(input[2]);
			int b = Integer.parseInt(input[3]);
			int c = Integer.parseInt(input[4]);

			int[] prices = new int[m];
			input = br.readLine().split(" ");
			for (int i = 0; i < m; i++)
				prices[i] = Integer.parseInt(input[i]);

			int[][] edges = new int[m][2];

			for (int i = 0; i < m; i++) {
				input = br.readLine().split(" ");
				edges[i][0] = Integer.parseInt(input[0]);
				edges[i][1] = Integer.parseInt(input[1]);
			}

			System.out.println(minPrice(prices, edges, n, m, a, b, c));
		}
	}

	static List<List<Integer>> adjList;

	private static long minPrice(int[] prices, int[][] edges, int n, int m, int a, int b, int c) {
		Arrays.sort(prices);
		long[] pre = new long[m + 1];

		for (int i = 0; i < m; i++)
			pre[i + 1] = pre[i] + prices[i];

		adjList = new ArrayList<>();

		for (int i = 0; i < n; i++)
			adjList.add(new ArrayList<>());

		for (int i = 0; i < m; i++) {
			int x = edges[i][0] - 1;
			int y = edges[i][1] - 1;

			adjList.get(x).add(y);
			adjList.get(y).add(x);
		}

		int[] dista = new int[n];
		int[] distb = new int[n];
		int[] distc = new int[n];
		Arrays.fill(dista, Integer.MAX_VALUE);
		Arrays.fill(distb, Integer.MAX_VALUE);
		Arrays.fill(distc, Integer.MAX_VALUE);

		bfs(a, dista);
		bfs(b, distb);
		bfs(c, distc);

		long ans = Long.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if(dista[i] + distb[i] + distc[i] > m)
				continue;
			
			ans = Math.min(ans, pre[distb[i]] + pre[dista[i] + distb[i] + distc[i]]);
		}

		return ans;
	}

	private static void bfs(int start, int[] dist) {
		start--;
		dist[start] = 0;

		Queue<Integer> q = new LinkedList<>();
		q.add(start);

		while (!q.isEmpty()) {
			int t = q.poll();
			for (int c : adjList.get(t)) {
				if (dist[c] == Integer.MAX_VALUE) {
					q.add(c);
					dist[c] = dist[t] + 1;
				}
			}
		}
	}

}
