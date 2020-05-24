package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestDistanceInAMaze {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[][] arr = new int[n][m];
		int[] B = new int[2];
		int[] C = new int[2];
		String st[];
		for (int i = 0; i < n; i++) {
			st = br.readLine().trim().split(", ");
			for (int j = 0; j < m; j++)
				arr[i][j] = Integer.parseInt(st[j]);
		}
		
		st = br.readLine().trim().split(", ");
		B[0] = Integer.parseInt(st[0]);
		B[1] = Integer.parseInt(st[1]);
		
		st = br.readLine().trim().split(", ");
		C[0] = Integer.parseInt(st[0]);
		C[1] = Integer.parseInt(st[1]);
		
		System.out.println(solve(arr, B, C));

	}

	public static int solve(int[][] A, int[] B, int[] C) {
		
		int startX = B[0];
		int startY = B[1];

		int endX = C[0];
		int endY = C[1];

		dx = new int[] { 1, -1, 0, 0 };
		dy = new int[] { 0, 0, 1, -1 };
		
	//	return doBFS(A, startX, startY, endX, endY);
		
		int distance[][] = new int[A.length][A[0].length];
		for (int[] v : distance)
			Arrays.fill(v, Integer.MAX_VALUE);
		distance[startX][startY] = 0;
		
		doDFS(A, startX, startY, distance);
		
		return distance[endX][endY] == Integer.MAX_VALUE ? -1 : distance[endX][endY];
	}

	static int[] dx;
	static int[] dy;

	private static int doBFS(int[][] a, int startX, int startY, int endX, int endY) {
		Queue<Point> q = new LinkedList<>();
		int distance[][] = new int[a.length][a[0].length];

		for (int[] v : distance)
			Arrays.fill(v, Integer.MAX_VALUE);

		q.offer(new Point(startX, startY));
		distance[startX][startY] = 0;

		while (!q.isEmpty()) {
			Point t = q.poll();
			int curDist = t.dist;
			for (int i = 0; i < 4; i++) {
			    int count = 0;
				int x = t.x + dx[i];
				int y = t.y + dy[i];

				while (x >= 0 && x < a.length && y >= 0 && y < a[0].length && a[x][y] == 0) {
					x += dx[i];
					y += dy[i];
					count++;
				}
				
				if(distance[x-dx[i]][y - dy[i]] > distance[t.x][t.y] + count) {
					distance[x-dx[i]][y - dy[i]] = distance[t.x][t.y] + count;
					q.offer(new Point(x-dx[i], y-dy[i]));
				}
			}

		}

		return distance[endX][endY] == Integer.MAX_VALUE ? -1 : distance[endX][endY];
	}
	
	private static void doDFS(int[][] a, int i, int j, int[][] distance) {
		
		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			int count = 0;
			
			while (x >= 0 && x < a.length && y >= 0 && y < a[0].length && a[x][y] == 0) {
				x += dx[k];
				y += dy[k];
				count++ ;
			}
			
			if(distance[x-dx[k]][y - dy[k]] > distance[i][j] + count) {
				distance[x-dx[k]][y - dy[k]] = distance[i][j] + count;
				doDFS(a,x-dx[k],y - dy[k],distance);
			}
		}
		
	}

}
