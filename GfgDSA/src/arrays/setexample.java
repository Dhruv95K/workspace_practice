
package arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class setexample {
	
	public static class node{
		static int x,y;

		public node(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		Set<List<Integer>> listSet1 = new HashSet<>() ;
		Set<List<Integer>> listSet2 = new HashSet<>() ;
		
		Set<node> list = new HashSet<>() ;
		
		List<Integer> l1 = new ArrayList<>();		
		List<Integer> l2 = new ArrayList<>();		
		
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l2.add(1);
		l2.add(2);
		l2.add(3);
		
		listSet1.add(l1);
		listSet1.add(l2);
	//	System.out.println(listSet1.hashCode());
		
		 HashMap<Integer,Integer> count = new HashMap<>();
		
	//	 System.out.println(count.get(1));
		 
		node n1 = new node(1,2);
		node n2 = new node(1,2);
		
		node n3 = null ;
		node n4 = null ;
		node.x=3;
		
		list.add(n1);
		list.add(n2);
		
		System.out.println(n3==n4);
			
		Queue<node> q = new ArrayDeque<>();
		
		addnodes(q);
		
	
	}


	private static void addnodes(Queue<node> q) {
		// TODO Auto-generated method stub
		node n1 = new node(1,2);
		node n2 = new node(1,2);
		q.add(n1);
		q.add(n2);
		
		
	}
	
}
