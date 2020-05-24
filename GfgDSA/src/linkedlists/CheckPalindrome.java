package linkedlists;
import java.util.*;


class Is_LinkedList_Palindrom
{
	 SingleNode head;  
	
	/* Function to print linked list */
    void printList(SingleNode head)
    {
        SingleNode temp = head;
        while (temp != null)
        {
           System.out.print(temp.data+" ");
           temp = temp.next;
        }  
        System.out.println();
    }
	
 
    /* Inserts a new Node at front of the list. */
    public void addToTheLast(SingleNode node) 
	{
		if (head == null) 
		{
			head = node;
		} else 
		{
		   SingleNode temp = head;
		   while (temp.next != null)
		   temp = temp.next;
		   temp.next = node;
		}
    }
	
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		 
		while(t>0)
        {
			int n = sc.nextInt();
			//int k = sc.nextInt();
			Is_LinkedList_Palindrom llist = new Is_LinkedList_Palindrom();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			SingleNode head= new SingleNode(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				llist.addToTheLast(new SingleNode(a));
			}
			
			if(isPalindrome(llist.head) == true)
			System.out.println(1);
		else
			System.out.println(0);
			t--;
		}
		
	}

    // Function to check if linked list is palindrome
    static boolean isPalindrome(SingleNode node) 
    {
    	SingleNode slo = node;
    	SingleNode prev_slo = null;
		SingleNode fast = node;
		SingleNode mid = null;
		
		while(fast!=null && fast.next!=null) {
			fast = fast.next.next;
			prev_slo = slo;
			slo = slo.next;
		}
		
		if(fast!=null) {
			mid = slo;
			slo = slo.next;
		}
		
		prev_slo.next = null;
		slo = reverse(slo);
		
		if(compare(node,slo))
			return true;
		else
			return false;
    }


	private static boolean compare(SingleNode node, SingleNode slo) {
		// TODO Auto-generated method stub
		while(node!=null && slo!=null) {
			if(node.data != slo.data)
				return false;
			node = node.next;
			slo = slo.next;
		}
		return true;
	}


	private static SingleNode reverse(SingleNode slo) {
		// TODO Auto-generated method stub
		SingleNode curr = slo;
		SingleNode prev = null;
		SingleNode next = null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
    
}
