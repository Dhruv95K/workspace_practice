package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductOfSums {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		int c = Integer.parseInt(br.readLine());
		int D[] = new int[a];
		int E[] = new int[b];
		int F[] = new int[c];
		
		String[] inputLine = br.readLine().trim().split(" ");
		for (int i = 0; i < a; i++) {
			D[i] = Integer.parseInt(inputLine[i]);
		}
		
		inputLine = br.readLine().trim().split(" ");
		for (int i = 0; i < b; i++) {
			E[i] = Integer.parseInt(inputLine[i]);
		}
		
		inputLine = br.readLine().trim().split(" ");
		for (int i = 0; i < c; i++) {
			F[i] = Integer.parseInt(inputLine[i]);
		}

		System.out.println(getSum(a,b,c,D,E,F));
	}
	
	public static int getSum(int A, int B, int C, int[] D, int[] E, int[] F) {
        long[] preD = new long[A];
        long[] preF = new long[C];
        preD[0] = (long)D[0];
        preF[0] = (long)F[0];
        long sum1 = 0L,sum2 = 0L,sum = 0L;
        for(int i=1;i<A;i++)
            preD[i] = (long)D[i]+preD[i-1];

        for(int i=1;i<C;i++)
            preF[i] = (long)F[i]+preF[i-1];    
        
        for(int i=0;i<B;i++){
            int key = E[i];
            int upper1 = upperBound(D,key);
            if(upper1 == -1)
                upper1 = D.length;
            if(upper1 == 0)
            	sum1 = 0L;
            else
            	sum1 = ((long)key * (long)upper1) + (long)preD[upper1-1];
            
            int upper2 = upperBound(F,key) ;
            if(upper2 == -1)
                upper2 = F.length;
            if(upper2 == 0)
            	sum2 = 0L;
            else
            	sum2 = ((long)key * (long)upper2) + (long)preF[upper2-1];
            
            sum += (sum1 * sum2); 
        }
        
        return (int)(sum%1000000007);
    }
    
    
    public static int upperBound(int[] a,int key){
        int lo = 0,hi = a.length-1;
        int ans = -1;
        while(lo<=hi){
            int mid = lo + (hi-lo)/2;
            if(a[mid]>key){
                ans = mid;
                hi = mid - 1;
            }
            else 
                lo = mid + 1;
        }
            
        return ans;
        
    }

}
