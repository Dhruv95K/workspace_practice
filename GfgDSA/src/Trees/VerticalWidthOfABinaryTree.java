package Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class VerticalWidthOfABinaryTree {

	public static void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data);
		inorder(root.right);
	}

	public static void main(String args[]) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {

			int n = Integer.parseInt(read.readLine());
			VerticalWidthOfABinaryTree llist = new VerticalWidthOfABinaryTree();
			Node root = null, parent = null;
			HashMap<Integer, Node> m = new HashMap<>();
			int k = 0;
			String str[] = read.readLine().trim().replace("  ", " ").split(" ");
			for (k = 0; k < n * 3;) {
				int a = Integer.parseInt(str[k++]);
				int b = Integer.parseInt(str[k++]);
				char c = str[k++].charAt(0);

				if (m.containsKey(a) == false) {
					parent = new Node(a);
					m.put(a, parent);
					if (root == null)
						root = parent;
				} else
					parent = m.get(a);
				Node child = new Node(b);
				if (c == 'L')
					parent.left = child;
				else
					parent.right = child;
				m.put(b, child);
			}
			VerticalWidth obj = new VerticalWidth();
			int ans = obj.verticalWidth(root);
			System.out.println(ans);
		}
	}

}

class Values2 {
	int min=Integer.MAX_VALUE,max = Integer.MIN_VALUE;
}

class VerticalWidth {
	public static int verticalWidth(Node root) {
		Values2 v = new Values2();
		verticalWidth(root,v,0);
		
		return v.max - v.min + 1;
	}

	private static void verticalWidth(Node root, Values2 v, int hd) {
		if(root == null)
			return ;
		
		v.max = Math.max(v.max, hd);
		v.min = Math.min(v.min, hd);
		
		verticalWidth(root.left,v,hd-1);
		verticalWidth(root.right,v,hd+1);
		
	}
}
