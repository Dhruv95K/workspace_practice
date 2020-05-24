package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {

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

	static int[] dx;
	static int[] dy;

	public static int solve(int[][] A) {
		Queue<Point> q = new LinkedList<>();
		dx = new int[] { 1, -1, 0, 0 };
		dy = new int[] { 0, 0, 1, -1 };
		int time = 0;
		boolean[][] visited = new boolean[A.length][A[0].length];

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[0].length; j++) {
				if (A[i][j] == 2) {
					q.add(new Point(i, j));
					visited[i][j] = true;
				}
			}
		}

		while (!q.isEmpty()) {
			int s = q.size();
			for (int k = 0; k < s; k++) {
				Point t = q.poll();
				int curDist = t.dist;

				for (int i = 0; i < 4; i++) {
					int x = t.x + dx[i];
					int y = t.y + dy[i];

					if (x >= A.length || y >= A[0].length || x < 0 || y < 0 || visited[x][y] == true || A[x][y] != 1)
						continue;

					visited[x][y] = true;
					Point p = new Point(x, y);
					p.dist = curDist + 1;
					q.offer(p);
				}
			}

			if (!q.isEmpty())
				time++;

		}

		if (checkAll(visited, A))
			return time;

		return -1;
	}

	private static boolean checkAll(boolean[][] visited, int[][] a) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[0].length; j++) {
				if (visited[i][j] == false && a[i][j] == 1)
					return false;
			}
		}

		return true;
	}

}
