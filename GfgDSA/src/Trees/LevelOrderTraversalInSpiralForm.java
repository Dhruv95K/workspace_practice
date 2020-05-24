package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversalInSpiralForm {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		// Node root=null;
		while (t > 0) {
			HashMap<Integer, Node> m = new HashMap<Integer, Node>();
			int n = sc.nextInt();
			Node root = null;
			while (n > 0) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);
				// cout << n1 << " " << n2 << " " << (char)lr << endl;
				Node parent = m.get(n1);
				if (parent == null) {
					parent = new Node(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}
				Node child = new Node(n2);
				if (lr == 'L')
					parent.left = child;
				else
					parent.right = child;
				m.put(n2, child);
				n--;
			}

			Spiral g = new Spiral();
			g.printSpiral(root);
			System.out.println();
			t--;

		}
	}

}

class Spiral {
	void printSpiral(Node node) {
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		boolean reverse = false;
		List<Node> temp;
		Node curr;

		while (!q.isEmpty()) {
			int s = q.size();
			temp = new ArrayList<>();
			for (int i = 0; i < s; i++) {
				curr = q.poll();
				temp.add(curr);
				if (curr.left != null)
					q.add(curr.left);
				if (curr.right != null)
					q.add(curr.right);
			}

			if (reverse)
				for (int i = 0; i < temp.size(); i++)
					System.out.print(temp.get(i).data + " ");
			else {
				for (int i = temp.size() - 1; i >= 0; i--)
					System.out.print(temp.get(i).data + " ");
			}

			reverse = !reverse;
		}
	}
}
