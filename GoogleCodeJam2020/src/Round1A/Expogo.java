package Round1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

class queueNode {
	long x, y;
	String steps;

	public queueNode(long l, long m, String steps) {
		this.x = l;
		this.y = m;
		this.steps = steps;
	}
}

public class Expogo {

	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

		while (t-- > 0) {
			long x = in.nextLong();
			long y = in.nextLong();

			System.out.println(stepsToTarget(x, y));
		}

	}

	private static String stepsToTarget(long x, long y) {
		Set<String> visited = new HashSet<>();

		int counter = 0;

		Queue<queueNode> q = new LinkedList<>();
		q.add(new queueNode(0L, 0L, ""));
		visited.add(0 + "#" + 0);

		while (!q.isEmpty()) {
			int n = q.size();
			long stepSize = (long) Math.pow(2, counter);
			for (int i = 0; i < n; i++) {
				queueNode t = q.poll();
				long curX = t.x;
				long curY = t.y;

				if (curX == x && curY == y) {
					return t.steps;
				}

				long east = curX + stepSize;
				long west = curX - stepSize;
				long south = curY - stepSize;
				long north = curY + stepSize;

				if (east >= -1000000000L && east <= 1000000000L) {
					if ((x > 0 && east <= x) || (x < 0 && east >= x)) {
						String coordinates = east + "#" + curY;
						if (!visited.contains(coordinates)) {
							visited.add(coordinates);
							q.add(new queueNode(east, curY, t.steps + "E"));
						}
					}
				}

				if (west >= -1000000000L && west <= 1000000000L) {
					if ((x > 0 && west <= x) || (x < 0 && west >= x)) {
						String coordinates = west + "#" + curY;
						if (!visited.contains(coordinates)) {
							visited.add(coordinates);
							q.add(new queueNode(west, curY, t.steps + "W"));
						}
					}
				}

				if (south >= -1000000000L && south <= 1000000000L) {
					if ((y > 0 && south <= y) || (y < 0 && south >= y)) {
						String coordinates = curX + "#" + south;
						visited.add(coordinates);
						q.add(new queueNode(curX, south, t.steps + "S"));
					}
				}

				if (north >= -1000000000L && north <= 1000000000L) {
					if ((y > 0 && north <= y) || (y < 0 && north >= y)) {
						String coordinates = curX + "#" + north;
						visited.add(coordinates);
						q.add(new queueNode(curX, north, t.steps + "N"));
					}
				}
			}

			counter++;

		}

		return "IMPOSSIBLE";
	}

}
