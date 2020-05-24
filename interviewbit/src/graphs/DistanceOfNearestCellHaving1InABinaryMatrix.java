package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1InABinaryMatrix {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][m];

		String st[];
		for (int i = 0; i < n; i++) {
			st = br.readLine().trim().split(", ");
			for (int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st[j]);
		}

		System.out.println(solve(arr));

	}

	static int[] dx;
	static int[] dy;

	public static int[][] solve(int[][] A) {
		dx = new int[] { 1, -1, 0, 0 };
		dy = new int[] { 0, 0, 1, -1 };
		Queue<Point> q = new LinkedList<>();

		int[][] visited = new int[A.length][A[0].length];
		for(int[] v : visited)
			Arrays.fill(v, -1);
		
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 1) {
					q.offer(new Point(i, j));
					visited[i][j] = 0;
				}
			}
		}

		while (!q.isEmpty()) {
			int s = q.size();
			for (int i = 0; i < s; i++) {
				Point t = q.poll();
				int curDist = t.dist;
				
				for(int k = 0;k<4;k++) {
					int x = t.x + dx[k];
					int y = t.y + dy[k];
					
					if (x >= A.length || y >= A[0].length || x < 0 || y < 0 || visited[x][y] != -1 || A[x][y] == 1)
						continue;
					
					Point p = new Point(x,y);
					p.dist = curDist + 1;
					visited[x][y] = p.dist;
					q.offer(p);
				}
				
			}

		}

		return visited;
	}

}
