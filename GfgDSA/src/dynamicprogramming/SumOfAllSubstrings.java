package dynamicprogramming;

import java.util.Scanner;

public class SumOfAllSubstrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
	      int t=scan.nextInt();
	      while(t-->0)
	      {
	          String str=scan.next();
	          
	          System.out.println(sumSubstrings(str));
	         
	      }
	}
	
	static long sumSubstrings(String s){
        // your code here
		int n = s.length();
	
		int[] sumSubstr = new int[n];
		sumSubstr[0] = Character.getNumericValue(s.charAt(0));
		int sum = sumSubstr[0];
		
		for(int i=1;i<n;i++) {
			sumSubstr[i] = (i+1)*Character.getNumericValue(s.charAt(i)) + 10*sumSubstr[i-1];
			sum+=sumSubstr[i];
		}
		
		return sum;
    }
    

}
