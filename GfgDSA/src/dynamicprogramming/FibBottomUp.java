package dynamicprogramming;

import java.util.Scanner;

public class FibBottomUp {

	public static void main (String[] args) 
	{
	    Scanner sc=new Scanner(System.in);
	    int testcases=sc.nextInt();
	    Geeks.dp[0]=0;
	    Geeks.dp[1]=1;
	    Geeks.dp[2]=1;
	    while(testcases-->0)
	    {
	        int number=sc.nextInt();
	        
	        Geeks obj=new Geeks();
	        System.out.println(obj.findNthFibonacci(number));
	        
	    }
	}

}

class Geeks
{
    static long dp[] = new long[100];
    
    //Complete this function
    public long findNthFibonacci(int number)
    {
      if(dp[number]>0)
      return dp[number];
      
         for(int i=3;i<=number;i++)
        	 dp[i] = dp[i-1] + dp[i-2];
        	 
      return dp[number];
    }
}
