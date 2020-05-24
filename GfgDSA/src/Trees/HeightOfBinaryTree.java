package Trees;

import java.util.HashMap;
import java.util.Scanner;

public class HeightOfBinaryTree {

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

			

			System.out.println(height(root));
			t--;

		}

	}
	
	static int height(Node node) 
    {
         if(node == null)
        	 return 0;
         
         return 1 + Math.max(height(node.left), height(node.right));
    } 

}
