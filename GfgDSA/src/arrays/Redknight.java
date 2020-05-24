package arrays;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Redknight {

	public static class node{
        int x,y,dist;
        boolean visited;
        String path;
        
        public node(int x, int y) {
            super();
            this.x = x;
            this.y = y;
            this.visited=false;
            this.path="";
        }
        
        
    }
    

    // Complete the printShortestPath function below.
    static void printShortestPath(int n, int i_start, int j_start, int i_end, int j_end) {
        // Print the distance along with the sequence of moves.
        node n1 = new node(i_start,j_start);    
        node n2 = new node(i_end,j_end);
         
        doBFS(n1,n2,n);
        
    }

    private static void doBFS(node n1, node n2,int n) {
		// TODO Auto-generated method stub
    	Queue<node> q = new ArrayDeque<>();
    	
    	q.add(n1);
    	
    	while(!q.isEmpty()) {
    		node curr = q.poll();
    		if(curr.x==n2.x && curr.y==n2.y) {
				System.out.println(curr.dist);
				System.out.println(curr.path);
				return;
			}
    		if(curr.visited==false) {
    			curr.visited=true;
    			addNeighbours(q,curr,n);
    		}
    	}
    	
    	System.out.println("Impossible");
    	
	}


	private static void addNeighbours(Queue<node> q, node curr,int n) {
		// TODO Auto-generated method stub
		int x = curr.x;
		int y = curr.y;
		
		if((x-1)>=0 && (y-2)>0) {
			node newNode = new node(x-1,y-2);
			newNode.dist+=1;
			newNode.path+="UL ";
			
			q.add(newNode);
		}
		if((x+1)<n && (y-2)>0) {
			node newNode = new node(x+1,y-2);
			newNode.dist+=1;
			newNode.path+="UR ";
			
			q.add(newNode);
		}
		if((x+2)<n) {
			node newNode = new node(x+2,y);
			newNode.dist+=1;
			newNode.path+="R ";
			
			q.add(newNode);
		}
		if((x+1)<n && (y+2)<n) {
			node newNode = new node(x+1,y+2);
			newNode.dist+=1;
			newNode.path+="LR ";
			
			q.add(newNode);
		}
		if((x-1)>=0 && (y+2)<n) {
			node newNode = new node(x-1,y+2);
			newNode.dist+=1;
			newNode.path+="LL ";
			
			q.add(newNode);
		}
		if((x-2)>=0) {
			node newNode = new node(x-2,y);
			newNode.dist+=1;
			newNode.path+="L ";
			
			q.add(newNode);
		}
		
		
		
	}


	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
  //      System.out.println(n);

        String[] i_startJ_start = scanner.nextLine().split(" ");
        

        int i_start = Integer.parseInt(i_startJ_start[0]);
        int j_start = Integer.parseInt(i_startJ_start[1]);

        int i_end = Integer.parseInt(i_startJ_start[2]);

        int j_end = Integer.parseInt(i_startJ_start[3]);

        System.out.println(i_start+" "+i_end);
        
        printShortestPath(n, i_start, j_start, i_end, j_end);

        scanner.close();
    }

}
