package Trees;

import java.util.Scanner;

public class Maximumdifferencebetweennodeanditsancestor {

	public static void main (String[] args) 
    {
         Scanner sc=new Scanner(System.in);
          int t=sc.nextInt();
          
           while(t-->0){
            int n=sc.nextInt();
            if(n==0){
                System.out.println(0);
                continue;
            }
            Node root = null;
            for(int i=0;i<n;i++){
                int a=sc.nextInt();
                int a1=sc.nextInt();
                char lr=sc.next().charAt(0);
                if(i==0){
                    root=new Node(a);
                    switch(lr){
                        case 'L':root.left=new Node(a1);
                        break;
                        case 'R':root.right=new Node(a1);
                        break;
                    }
                }
                else{
                    insert(root,a,a1,lr);
                }
            }
            
            MaximumDiff g=new MaximumDiff();
            System.out.println(g.maxDiff(root));
            
        }
    }
    public static void insert(Node root,int a,int a1,char lr){
        if(root==null){
            return;
        }
        if(root.data==a){
            switch(lr){
                case 'L':root.left=new Node(a1);
                break;
                case 'R':root.right=new Node(a1);
                break;
            }
            return;
        }
        insert(root.left,a,a1,lr);
        insert(root.right,a,a1,lr);
    }

}

class MaximumDiff
{	
	static int res = 0;
    int maxDiff(Node root)
    {
        res = -1000000;
        calcDiff(root);
        return res;
    }
    
	private int calcDiff(Node root) {
		if(root == null)
			return 0;
		
		int l = calcDiff(root.left);
		int r = calcDiff(root.right);
		
		int m = Math.min(l, r);
		res = Math.max(res, root.data - m);
		
		return Math.min(root.data, m);
	}
}

