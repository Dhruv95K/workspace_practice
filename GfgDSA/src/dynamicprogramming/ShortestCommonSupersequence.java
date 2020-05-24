package dynamicprogramming;

import java.util.Scanner;

public class ShortestCommonSupersequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int p = sc.nextInt(); // Take size of both the strings as input
			int q = sc.nextInt();

			String s1 = sc.next(); // Take both the string as input
			String s2 = sc.next();

			System.out.println(s1.length() + s2.length() - lcs(p, q, s1, s2));
		}
	}
	
	static int lcs(int p, int q, String s1, String s2){
        int[][] lcs = new int[p+1][q+1];
        
        for(int i=0;i<=p;i++) {
        	for(int j=0;j<=q;j++) {
        		if(j==0||i==0)
        			continue;
        		if(s1.charAt(i-1)==s2.charAt(j-1))
        			lcs[i][j] = 1 + lcs[i-1][j-1];
        		else{
        			lcs[i][j]=Math.max(lcs[i-1][j], lcs[i][j-1]);
        		}
        	}
        }
        
    	return lcs[p][q];
    }

}
