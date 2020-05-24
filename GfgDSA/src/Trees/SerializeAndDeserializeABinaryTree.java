package Trees;

import java.util.ArrayList;
import java.util.Scanner;


public class SerializeAndDeserializeABinaryTree {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			Node root = null;
			if (n == 1) {
				System.out.println(sc.nextInt());
				n--;
			}
			while (n-- > 0) {
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);
				if (root == null) {
					root = new Node(n1);
					switch (lr) {
					case 'L':
						root.left = new Node(n2);
						break;
					case 'R':
						root.right = new Node(n2);
						break;
					}
				} else {
					insert(n1, n2, lr, root);
				}
			}
			ArrayList<Integer> aa = new ArrayList<Integer>();
			GfG7 g = new GfG7();
			String s = g.serialize(root, aa);
			Node root1 = g.deSerialize(s);
			inorder(root1);
			System.out.println();
		}
	}

	public static void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}

	public static void insert(int n1, int n2, char lr, Node root) {
		if (root == null) {
			return;
		}
		if (root.data == n1) {
			switch (lr) {
			case 'L':
				root.left = new Node(n2);
				break;
			case 'R':
				root.right = new Node(n2);
				break;
			}
		}
		insert(n1, n2, lr, root.left);
		insert(n1, n2, lr, root.right);
	}

}

class GfG7{
	public String serialize(Node root,ArrayList<Integer> temp) {
		serializeTree(root,temp);
		String s = new String();
		for(int i : temp) {
				s += i + ",";
		}
		
		return s;
    }

    private void serializeTree(Node root, ArrayList<Integer> temp) {
    	if(root == null) {
    		temp.add(-1);
    		return;
    	}
		
    	temp.add(root.data);
    	serializeTree(root.left, temp);
    	serializeTree(root.right, temp);
	}

	public Node deSerialize(String data) {
		ArrayList<Integer> temp = new ArrayList<>();
		for(String st : data.split(",")) {
			temp.add(Integer.parseInt(st));
		}
		ind = 0;
		Node root = deSerialize(temp);
		return root;
    }
	
	static int ind;
	private Node deSerialize(ArrayList<Integer> temp) {
		if(ind == temp.size() || temp.get(ind) == -1) {
			ind++;
			return null;
		}
		
		Node root = new Node(temp.get(ind++));
		root.left = deSerialize(temp);
		root.right = deSerialize(temp);
		
		return root;
	}
	
	
}
