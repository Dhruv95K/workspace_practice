package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class KnapsackProblem {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine());
            int w = Integer.parseInt(read.readLine());
            
            int val[] = new int[n];
            int wt[] = new int[n];
            
            String st[] = read.readLine().trim().split("\\s+");
            for(int i = 0; i < n; i++)
              val[i] = Integer.parseInt(st[i]);
             
            String s[] = read.readLine().trim().split("\\s+"); 
            for(int i = 0; i < n; i++)
              wt[i] = Integer.parseInt(s[i]);
              
            System.out.println(new Knapsack().knapSack(w, wt, val, n));
        }
	}
}

class Knapsack 
{ 
    // Returns the maximum value that can be put in a knapsack of capacity W
	static Map<String,Integer> cache ;
    public Knapsack() {
		this.cache = new HashMap<>();
	}
    
	public int knapSack(int w, int[] wt, int[] val, int n) {
		// TODO Auto-generated method stub
		int[][] knapSack = new int[n+1][w+1];
		
		for(int i=1;i<=n;i++) {
			for(int j=0;j<=w;j++) {
				if(wt[i-1] > j)
					knapSack[i][j] = knapSack[i-1][j];
				else
					knapSack[i][j] = Math.max(knapSack[i-1][j],val[i-1]+knapSack[i-1][j-wt[i-1]]);
			}
		}
		
		return knapSack[n][w];
	}

	static int knapSackRecursive(int W, int wt[], int val[], int n) 
    { 
    	 if(n==0 || W < 0)
    		 return 0;
    	 
    	 if(wt[n-1]>W)
    		 return knapSackRecursive(W, wt, val, n-1);
    	 
    	 String key = W+"|"+n;
    	 if(cache.get(key)!=null)
    		 return cache.get(key);
    	 
    	 cache.put(key, Math.max(knapSackRecursive(W, wt, val, n-1),
    			 				val[n-1] + knapSackRecursive(W-wt[n-1], wt, val, n-1)));
    	 
    	 return cache.get(key);
    } 
}
