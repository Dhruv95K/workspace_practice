package Trees;

import java.util.HashMap;
import java.util.Scanner;

public class BinaryTreeToDLL {

	void inorder(Node node)
	{
		if(node==null)
			return ;
		else
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
	}
	void printList(Node head) 
    {
		Node prev = head;
        while (head != null) 
        {
            System.out.print(head.data + " ");
			prev = head;
            head = head.right;
        }
		
		System.out.println();
		while(prev != null)
		{
			System.out.print(prev.data+" ");
			prev = prev.left;
		}
    }
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		BinaryTreeToDLL obj = new BinaryTreeToDLL();
		//DLL d = new DLL();
		int t = sc.nextInt();
		while(t>0)
		{
			HashMap<Integer, Node> hm = new HashMap<Integer, Node>();
			int n = sc.nextInt();
			
			Node root = null;
			
			while(n>0)
			{
				int n1 = sc.nextInt();
				int n2 = sc.nextInt();
				char lr = sc.next().charAt(0);
				
				Node parent = hm.get(n1);
				if(parent == null)
				{
					parent = new Node(n1);
					hm.put(n1, parent);
					if(root == null)
					{
						root = parent;
						//d.head = root;
					}
					
				}
				
				Node child = new Node(n2);
				if(lr == 'L')
					parent.left = child;
				else
					parent.right = child;
				
				hm.put(n2,child);
			n--;
			}
			
			GfG g = new GfG();
			Node node = g.bToDLL(root);
			obj.printList(node);
		t--;
		System.out.println();
		}
	}

}

class GfG
{
    Node prev = null;
    Node bToDLL(Node root)
    {
    	if(root == null)
    		return null;
    	
    	Node head = bToDLL(root.left);
    	if(prev == null)
    		head = root;
    	else {
    		prev.right = root;
    		root.left = prev;
    	}
    	
    	prev = root;
    	bToDLL(root.right);
    	return head;
    }
}
