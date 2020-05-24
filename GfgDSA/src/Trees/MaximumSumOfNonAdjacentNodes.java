package Trees;

import java.util.Scanner;

public class MaximumSumOfNonAdjacentNodes {

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

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();

		while (t-- > 0) {
			Node root = null;
			int n = sc.nextInt();

			if (n == 0) {
				System.out.println(0);
				continue;
			}

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
			System.out.println(new MaxSumNonAdjacent().getMaxSum(root));
		}
	}

}

class MaxSumNonAdjacent
{
    static int getMaxSum(Node root)
    {
        if(root == null)
        	return 0;
        
        int include = root.data;
        if(root.left!=null)
        	include += getMaxSum(root.left.left) + getMaxSum(root.left.right);
        if(root.right!=null)
        	include += getMaxSum(root.right.left) + getMaxSum(root.right.right);
        
        int exclude = getMaxSum(root.left) + getMaxSum(root.right);
        
        return Math.max(include, exclude);
    }
}