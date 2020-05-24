package dynamicprogramming;

import java.util.Scanner;

public class WaysToSumN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
	     int t=s.nextInt();
	     while(t-->0){
	         int n=s.nextInt();
	         Arraysss obj = new Arraysss();
	         System.out.println(obj.countWays(n));
	     }
	}

}

class Arraysss{
    
    // function to count ways in which n can be
    // expressed as the sum of two or more integers
    int countWays(int n){
    
         // your code here
         int mod = 1000000007;
         int[] ways = new int[n+1];
         ways[0] = 1;
         
         for(int i=1;i<=n-1;i++){
             for(int j=i;j<=n;j++){
                 ways[j] = (ways[j]%mod + ways[j-i]%mod)%mod;
             }
         }
         
         return ways[n]%mod;
    }
}
