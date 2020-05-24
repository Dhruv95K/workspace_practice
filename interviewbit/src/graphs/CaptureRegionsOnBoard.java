package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CaptureRegionsOnBoard {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		ArrayList<ArrayList<Character>> a = new ArrayList<>();

		String st[];
		for (int i = 0; i < n; i++) {
			st = br.readLine().trim().split(", ");
			a.add(new ArrayList<>());
			for (int j = 0; j < m; j++)
				a.get(i).add(st[j].charAt(0));
		}

		System.out.println(a);

	}

	static int[] dx;
	static int[] dy;

	public void solve(ArrayList<ArrayList<Character>> a) {
		int n = a.size();
		int m = a.get(0).size();

		dx = new int[] { 1, -1, 0, 0 };
		dy = new int[] { 0, 0, 1, -1 };

		for (int i = 0; i < n; i++) {
			if (a.get(i).get(0) == 'O')
				dfs(a, i, 0);

			if (a.get(i).get(m - 1) == 'O')
				dfs(a, i, m - 1);
		}

		for (int j = 0; j < m; j++) {
			if (a.get(0).get(j) == 'O')
				dfs(a, 0, j);

			if (a.get(n - 1).get(j) == 'O')
				dfs(a, n - 1, j);
		}
		
		for(int i = 0;i<n;i++) {
			for(int j = 0;j<m;j++) {
				if(a.get(i).get(j) == '#')
					a.get(i).set(j, 'O');
				else if(a.get(i).get(j) == 'O')
					a.get(i).set(j, 'X');
			}
		}
	}

	private void dfs(ArrayList<ArrayList<Character>> a, int i, int j) {
		a.get(i).set(j, '#');

		for (int k = 0; k < 4; k++) {
			int x = i + dx[k];
			int y = j + dy[k];
			
			if(x<0 || x >= a.size() || y<0 || y >= a.get(0).size() || a.get(x).get(y) != 'O' )
				continue;
			
			dfs(a,x,y);
		}
	}
}
