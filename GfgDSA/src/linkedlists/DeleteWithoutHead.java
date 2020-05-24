package linkedlists;

import java.util.*;

class SingleNode
{
	int data ;
	SingleNode next;
	SingleNode(int d)
	{
		data = d;
		next = null;
	}
	public SingleNode() {		
	}
}

public class DeleteWithoutHead
{
	SingleNode head;
	
	void printList(SingleNode head)
	{
		SingleNode tnode = head;
		while(tnode != null)
		{
			System.out.print(tnode.data+ " ");
			tnode = tnode.next;
		}
		System.out.println();
	}
	
	void addToTheLast(SingleNode node)
	{
		
		if(head == null)
		{
			head = node;
		}else
		{
			SingleNode temp = head;
			while(temp.next != null)
			temp = temp.next;
			
			temp.next = node;
		}
	}
	
	SingleNode search_Node(SingleNode head, int k)
	{
		SingleNode current = head;
		while(current != null)
		{
			if(current.data == k)
				break;
			current = current.next;
		}
	return current;
	}
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		while(t>0)
		{
			int n = sc.nextInt();
			DeleteWithoutHead llist = new DeleteWithoutHead();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			SingleNode head= new SingleNode(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new SingleNode(a));
			}
			
			int k = sc.nextInt();
			SingleNode del = llist.search_Node(llist.head,k);
			
			DeleteNode g = new DeleteNode();
			if(del != null && del.next != null)
			{
				g.deleteNode(del);
			}
			llist.printList(llist.head);
		t--;
		}
	}
}


class DeleteNode
{
    void deleteNode(SingleNode node)
    {
    	SingleNode prev = null;	
        while(node.next!=null){
            node.data = node.next.data;
            prev = node;
            node = node.next;
        }
        prev.next = null;
        node = null;
    }
}