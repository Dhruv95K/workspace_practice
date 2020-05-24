package Trees;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class PrintABinaryTreeInVerticalOrder {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {
			HashMap<Integer, Node> m = new HashMap<Integer, Node>();
			int n = Integer.parseInt(read.readLine());
			Node root = null;
			String str[] = read.readLine().replace("  ", " ").trim().split(" ");
			int k = 0;
			while (n-- > 0) {
				int n1 = Integer.parseInt(str[k++]);
				int n2 = Integer.parseInt(str[k++]);
				char lr = str[k++].charAt(0);

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

			BinaryTree obj = new BinaryTree();
			obj.verticalOrder(root);
			System.out.println();
		}
	}

}

class BinaryTree
{
	static Map<Integer,ArrayList<Node>> map;
    static void verticalOrder(Node root)
    {
    	map = new TreeMap<>();
    	Queue<VerticalPair> q = new LinkedList<>();
    	q.add(new VerticalPair(root, 0));
    	
    	while(!q.isEmpty()) {
    		VerticalPair p = q.poll();
    		if(map.get(p.hd) == null) {
    			map.put(p.hd, new ArrayList<>());
    		}
    		map.get(p.hd).add(p.node);
    		
    		if(p.node.left!=null)
    			q.add(new VerticalPair(p.node.left, p.hd-1));
    		
    		if(p.node.right!=null)
    			q.add(new VerticalPair(p.node.right, p.hd+1));
    	}
    	
    	ArrayList<Node> temp;
		for(int i:map.keySet()) {
			temp = map.get(i);
			for(Node j : temp)
				System.out.print(j.data + " ");
		}
    	
    }
}

class VerticalPair{
	Node node;
	int hd;
	
	public VerticalPair(Node node, int hd) {
		this.node = node;
		this.hd = hd;
	}
}
