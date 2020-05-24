package Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Lnode {
	int data;
	Lnode left, right, nextRight;

	Lnode(int x) {
		this.data = x;
		left = right = nextRight = null;
	}

}

public class ConnectNodesAtSameLevel {

	static void printSpecial(Lnode root) {
		if (root == null)
			return;
		Lnode node = root;
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.nextRight;
		}
		if (root.left != null)
			printSpecial(root.left);
		else
			printSpecial(root.right);

	}

	static void inorder(Lnode root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while (t-- > 0) {
			HashMap<Integer, Lnode> m = new HashMap<Integer, Lnode>();
			int n = Integer.parseInt(br.readLine());

			Lnode root = null;

			String nums[] = br.readLine().split(" ");
			int mm = n;
			for (int idx = 0; idx < mm; idx++) {

				int n1 = Integer.parseInt(nums[idx * 3]);
				int n2 = Integer.parseInt(nums[idx * 3 + 1]);

				String lr = nums[idx * 3 + 2];
				Lnode parent = m.get(n1);
				if (parent == null) {
					parent = new Lnode(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}
				Lnode child = new Lnode(n2);
				if (lr.equals("L"))
					parent.left = child;
				else
					parent.right = child;
				m.put(n2, child);
			}
			new Level().connect(root);
			printSpecial(root);
			System.out.println();
			inorder(root);
			System.out.println();

		}

	}

}

class Level {
	static void connect(Lnode root) {
		Queue<Lnode> q = new LinkedList<>();
		q.add(root);
		q.add(null);

		while (!q.isEmpty()) {
			int n = q.size();
			Lnode cur ;
			for (int i = 0; i < n; i++) {
				cur = q.poll();
				if(cur == null)
					continue;
				if(cur.left!=null)
					q.add(cur.left);
				if(cur.right!=null)
					q.add(cur.right);
				
				cur.nextRight = q.peek();
			}
			
			if(!q.isEmpty())
				q.add(null);
		}
	}

}
