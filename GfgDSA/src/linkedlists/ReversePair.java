package linkedlists;

import java.util.*;
import java.io.*;
import java.lang.*;
 

public class ReversePair
{
  static  SingleNode head;  
  static  SingleNode lastNode;
  
  public static void addToTheLast(SingleNode node)
  {
      if (head == null)
      {
          head = node;
          lastNode = node;
      }
      else
      {
          SingleNode temp = head;
          lastNode.next = node;
          lastNode = node;
      }
  }
   static void printList(SingleNode head)
  {
      SingleNode temp = head;
      while (temp != null)
      {
          System.out.print(temp.data+" ");
          temp = temp.next;
      }
  }
  /* Drier program to test above functions */
  public static void main(String args[]) throws IOException
  {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      //out = new PrintWriter(new BufferedOutputStream(System.out));
      int t= Integer.parseInt(br.readLine());
          
      while(t>0)
      {
          int n = Integer.parseInt(br.readLine());
          SingleNode head = null;
          //LinkedList1 llist = new LinkedList1();
                      String str = br.readLine();
                      String nums[] = str.trim().split("\\s+");
          
              int a1= Integer.parseInt(nums[0]);
              head= new SingleNode(a1);
              addToTheLast(head);
          
          for (int i = 1; i < n; i++)
          {
              int a = Integer.parseInt(nums[i]);
              addToTheLast(new SingleNode(a));
          }
          head = pairwise_swap(head);
          
          printList(head);
          System.out.println();
          
          t--;
      }
      //out.close();
  }

  public static SingleNode pairwise_swap(SingleNode node)
  {
      if(node == null || node.next == null)
    	  return node;
      
      SingleNode rem = node.next.next;
      
      SingleNode newHead = node.next;
      
      node.next.next = node;
      
      node.next = pairwise_swap(rem);
      
      return newHead;
  }
     
}