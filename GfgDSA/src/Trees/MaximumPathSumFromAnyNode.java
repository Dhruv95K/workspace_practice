package Trees;

import java.util.Scanner;

public class MaximumPathSumFromAnyNode {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			int n = sc.nextInt();
			if (n == 0) {
				System.out.println(0);
				continue;
			}
			Node root = null;
			for (int i = 0; i < n; i++) {
				int a = sc.nextInt();
				int a1 = sc.nextInt();
				char lr = sc.next().charAt(0);
				if (i == 0) {
					root = new Node(a);
					switch (lr) {
					case 'L':
						root.left = new Node(a1);
						break;
					case 'R':
						root.right = new Node(a1);
						break;
					}
				} else {
					insert(root, a, a1, lr);
				}
			}

			GfG6 g = new GfG6();
			System.out.println(g.findMaxSum(root));

		}
	}

	public static void insert(Node root, int a, int a1, char lr) {
		if (root == null) {
			return;
		}
		if (root.data == a) {
			switch (lr) {
			case 'L':
				root.left = new Node(a1);
				break;
			case 'R':
				root.right = new Node(a1);
				break;
			}
			return;
		}
		insert(root.left, a, a1, lr);
		insert(root.right, a, a1, lr);
	}

}

class GfG6
{
    // This function should returns sum of
    // maximum sum path from any node in
    // a tree rooted with given root.
	static int max ;
    int findMaxSum(Node node)
    {
    	if(node == null)
    		return 0;
    	max = Integer.MIN_VALUE;
    	
    	Res res = new Res();
    	
        return findMaxSum(node,res);
    }

	private int findMaxSum(Node node, Res res) {
		if(node == null) {
			return 0;
		}
		
		int l = findMaxSum(node.left, res);
		int r = findMaxSum(node.right, res);
		
		int max_single = Math.max(node.data + Math.max(l, r), node.data);
		
		int max_top = Math.max(max_single, l + r + node.data);
		
		res.s = Math.max(res.s, max_top);
		
		return max_single;
	}
	
	
	int helper(Node node)
    {
    	if(node == null)
    		return 0;
    	
    	int left = helper(node.left);
    	int right = helper(node.right);
    	
    	int sum = node.data +  Math.max(0,left) + Math.max(0,right);   	
    	max = Math.max(max, sum);
    	sum = node.data + Math.max(0, Math.max(left, right));
    	return sum;
    }
}

class Res{
	int s = 0;
}
