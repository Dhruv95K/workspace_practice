package dsaw7;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Traversal {

	@SuppressWarnings("unchecked")
	static ArrayList<Integer>[] adj = new ArrayList[10001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int edges = sc.nextInt();
			for (int i = 0; i < 10001; i++)
				adj[i] = new ArrayList<Integer>();
			int u, v;
			for (int i = 0; i < edges; i++) {
				u = sc.nextInt();
				v = sc.nextInt();
				adj[u].add(v);
			}

			int origin = sc.nextInt();
			new Graph().BFS(origin);
			System.out.println();

		}
	}

}

class Graph {
	static Traversal obj = new Traversal();
	// Position this line where user code will be pasted.

	static void BFS(int origin) {
		// Your code here
		Queue<Integer> q = new ArrayDeque<>();
		q.add(origin);
		Set<Integer> s = new HashSet<>();
		s.add(origin);

		while (!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr + " ");
			ArrayList<Integer> ar = obj.adj[curr];
			for (int i = 0; i < ar.size(); i++) {
				Integer integer = ar.get(i);
				if (!s.contains(integer)) {
					q.add(integer);
					s.add(integer);
				}
			}
		}
	}
}
