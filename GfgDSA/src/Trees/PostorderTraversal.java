package Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;

public class PostorderTraversal {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		while (t > 0) {
			HashMap<Integer, Node> m = new HashMap<Integer, Node>();

			int n = Integer.parseInt(br.readLine());

			Node root = null;
			String nums[] = br.readLine().split(" ");

			int mm = n;
			for (int idx = 0; idx < mm; idx++) {

				int n1 = Integer.parseInt(nums[idx * 3]);
				int n2 = Integer.parseInt(nums[idx * 3 + 1]);

				String lr = nums[idx * 3 + 2];

				Node parent = m.get(n1);
				if (parent == null) {
					parent = new Node(n1);
					m.put(n1, parent);
					if (root == null)
						root = parent;
				}
				Node child = new Node(n2);
				if (lr.equals("L"))
					parent.left = child;
				else
					parent.right = child;
				m.put(n2, child);
			}

			Tree3 g = new Tree3();
			g.postOrder(root);
			System.out.print("");
			t--;
		}

		br.close();
	}

}

class Tree3 {
	void postOrder(Node root) {
		Stack<Node> st = new Stack<>();
		Node lastVisited = null;
		Node cur = root;
		
		while(!st.isEmpty()|| cur != null) {
			while(cur!=null) {
				st.push(cur);
				cur = cur.left;
			}
			Node peekNode = st.peek();
			if(peekNode.right != null && lastVisited != peekNode.right)
				cur = peekNode.right;
			else {
				System.out.print(peekNode.data);
				lastVisited = st.pop();
			}
		}
	}
}
