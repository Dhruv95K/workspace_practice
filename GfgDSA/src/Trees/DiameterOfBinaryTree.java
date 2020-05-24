package Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class DiameterOfBinaryTree {

	public static void main(String[] args) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());
		while (t > 0) {
			HashMap<Integer, Node> m = new HashMap<Integer, Node>();
			int n = Integer.parseInt(read.readLine());
			Node root = null;
			int k = 0;
			String str[] = read.readLine().trim().replace("  ", " ").split(" ");
			for (k = 0; k < n * 3;) {
				int n1 = Integer.parseInt(str[k++]);
				int n2 = Integer.parseInt(str[k++]);
				char lr = str[k++].charAt(0);
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

			}
			Diameter g = new Diameter();
			System.out.println(g.diameter(root));
			t--;
		}
	}

}

class Diameter {
	static class Height {
		int h = 0;
	}

	int diameter(Node node) {
		Height h = new Height();
		return diameter(node, h);
	}

	private int diameter(Node node, Height h) {
		if(node == null) {
			h.h = 0;
			return 0;
		}
		
		Height lh = new Height(),rh = new Height();
		
		int lDiameter = diameter(node.left,lh);
		int rDiameter = diameter(node.right, rh);
		
		h.h = 1 + Math.max(lh.h, rh.h);
		
		return Math.max(1 + lh.h + rh.h, Math.max(lDiameter, rDiameter));
	}
}
