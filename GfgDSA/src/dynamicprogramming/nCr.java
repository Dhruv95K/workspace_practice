package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class nCr {
	static Map<String,Integer> cache;
	static int mod = 1000000007;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
        int testcase=s.nextInt();  
        while(testcase>0)
        {
            int n=s.nextInt();              // Input n
            int r=s.nextInt();              // Input p
            
            cache = new HashMap<>();
            System.out.println(nCrModp(n, r));
            
            testcase--;
        }
	}

	//throws stack overflow
	private static int nCrModpTopDown(int n, int r) {
		// TODO Auto-generated method stub
		if(r==n||r==0)
			return 1;
		if(r==1)
			return n;
		if(n<r)
			return 0;
		
		String key = n+"|"+r;
		if(cache.get(key) != null)
			return cache.get(key);
		
		cache.put(key,(nCrModpTopDown(n-1, r-1)%mod + nCrModpTopDown(n-1, r)%mod)%mod);
		
		return cache.get(key);
	}
	
	private static int nCrModp(int n, int r) {
		// TODO Auto-generated method stub
		int[][] ncr = new int[n+1][r+1];
		ncr[0][0] = 1;
		for(int i=0;i<=n;i++) {
			for(int j=0;(j<=i&&j<=r);j++) {
				if(j==0||j==i)
					ncr[i][j] = 1;
				else if(j==1||(i-j)==1)
					ncr[i][j] = i;
				else
					ncr[i][j] = ncr[i-1][j-1] + ncr[i-1][j];
			}
		}
		
		return ncr[n][r];
	}
	

}
