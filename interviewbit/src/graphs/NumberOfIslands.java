package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

	public static void main(String[] args) throws NumberFormatException, IOException {
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

	public static int solve(int[][] A) {
		int n = A.length;
		int m = A[0].length;

		boolean[][] visited = new boolean[n][m];
		int islands = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (A[i][j] == 1 && visited[i][j] == false) {
					doBFS(A, i, j,visited);
					islands++;
				}
			}
		}

		return islands;
	}

	static int[] dx;
	static int[] dy;

	private static void doBFS(int[][] a, int i, int j, boolean[][] visited) {
		Queue<Point> q = new LinkedList<>();
		dx = new int[] { -1, 0, 1, 0, -1, 1, -1, 1 };
		dy = new int[] { 0, -1, 0, 1, -1, 1, 1, -1 };

		q.offer(new Point(i, j));
		visited[i][j] = true;
		
		while (!q.isEmpty()) {
			Point t = q.poll();

			for (int k = 0; k < 8; k++) {
				int x = t.x + dx[k];
				int y = t.y + dy[k];

				if (x >= a.length || y >= a[0].length || x < 0 || y < 0 || visited[x][y] == true || a[x][y] != 1)
					continue;
				
				visited[x][y] = true;
				q.offer(new Point(x, y));
				
			}
		}
	}

}
