package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class TopView {

	public static void main(String[] args) {
		{

			// Input the number of test cases you want to run
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

				new View().topView(root);
				System.out.println();
				t--;

			}
		}
	}
}

class View {
	static Map<Integer,Node> map;
	
	static void topView(Node root) {
		map = new TreeMap<>();
		
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(root,0));
		
		while(!q.isEmpty()) {
			Pair temp = q.poll();
			if(map.get(temp.hd) == null)
				map.put(temp.hd, temp.n);
			
			if(temp.n.left != null)
				q.add(new Pair(temp.n.left,temp.hd-1));
			
			if(temp.n.right != null)
				q.add(new Pair(temp.n.right,temp.hd+1));
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i:map.keySet()) {
			ans.add(map.get(i).data);
		}
		
		System.out.println(ans);
	}
}

class Pair{
	Node n;
	int hd;
	public Pair(Node n, int hd) {
		this.n = n;
		this.hd = hd;
	}
}
