package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Point {
	int x, y, dist;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.dist = 0;
	}
}

public class KnightOnChessBoard {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int d = Integer.parseInt(br.readLine());
		int e = Integer.parseInt(br.readLine());
		int f = Integer.parseInt(br.readLine());

		System.out.println(knightBFS(a, b, c, d, e, f));

	}

	private static int knightBFS(int a, int b, int c, int d, int e, int f) {
		int[][] visited = new int[a][b];
		int dist = 0;
		dx = new int[] { 2, 1, -1, -2, -2, -1, 1, 2 };
		dy = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };

		Queue<Point> q = new LinkedList<>();
		q.add(new Point(c, d));
		visited[c - 1][d - 1] = 1;

		while (!q.isEmpty()) {
			Point t = q.poll();
			if (t.x == e && t.y == f) {
				return t.dist;
			}
			int curDist = t.dist;
			for (int i = 0; i < 8; i++) {
				int x = t.x + dx[i];
				int y = t.y + dy[i];
				
				if (x > a || y > b || x <= 0 || y <= 0 || visited[x-1][y-1] == 1)
					continue;
				
				visited[x-1][y-1] = 1;
				Point newPoint = new Point(x, y);
				newPoint.dist = curDist+1;
				q.offer(newPoint);
			}

		}

		return -1;
	}

	static int maxDepth;
	static int[] dx;
	static int[] dy;

	// wrong this is for max moves
	public static int knightDFS(int a, int b, int c, int d, int e, int f) {
		int[][] board = new int[a][b];

		maxDepth = 0;
		dx = new int[] { 2, 1, -1, -2, -2, -1, 1, 2 };
		dy = new int[] { 1, 2, 2, 1, -1, -2, -2, -1 };
		doDFS(board, c - 1, d - 1, 1);

		return maxDepth;
	}

	// wrong goes into infinite loop
	private static void doDFS(int[][] board, int curX, int curY, int moves) {
		int n = board.length;
		int m = board[0].length;

		board[curX][curY] = moves;
		if (moves >= 64) {
			board[curX][curY] = 0;
			return;
		}

		for (int i = 0; i < 8; i++) {
			int x = curX + dx[i];
			int y = curY + dy[i];

			if (x >= n || y >= m || x < 0 || y < 0 || board[x][y] != 0)
				continue;

			doDFS(board, x, y, moves + 1);
		}
		board[curX][curY] = 0;
	}

}
