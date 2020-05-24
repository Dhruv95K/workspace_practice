package Trees;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;


public class PreorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
            Tree g = new Tree();
            g.preorder(root);
            System.out.print("");
            t--;
        }
	}

}

class Tree
{
    void preorder(Node root)
    {
       Stack<Node> st = new Stack<>();
       st.push(root);
       
       while(!st.isEmpty()) {
    	   Node cur = st.pop();
    	   System.out.print(cur.data + " ");
    	   if(cur.right!=null)
    		   st.push(cur.right);
    	   if(cur.left!=null)
    		   st.push(cur.left);
       }
       
       
    }
}
