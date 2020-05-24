package Trees;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class InorderTraversal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0)
        {
            HashMap<Integer, Node> m = new HashMap<Integer, Node> ();
            int n = sc.nextInt();
            Node root = null;
            while (n > 0)
            {
                int n1 = sc.nextInt();
                int n2 = sc.nextInt();
                char lr = sc.next().charAt(0);
                
                
                Node parent = m.get(n1);
                if (parent == null)
                {
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
            Tree1 g = new Tree1();
            g.inOrder(root);
            System.out.print("");
            t--;
        }

	}

}

class Tree1
{
    void inOrder(Node root)
    {
    	Stack<Node> st = new Stack<>();
        //st.push(root);
        Node cur = root;
        while(!st.isEmpty() || cur != null) {
        	while(cur!=null) {
        		st.push(cur);
        		cur = cur.left;
        	}
        	cur = st.pop();
        	System.out.print(cur.data + " ");
        	cur = cur.right;
        }
    }
}
