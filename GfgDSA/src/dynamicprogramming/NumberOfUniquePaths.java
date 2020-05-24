package dynamicprogramming;

import java.util.Scanner;

public class NumberOfUniquePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while (test-- > 0) {
			int p = sc.nextInt(); // Take size of both the strings as input
			int q = sc.nextInt();

			System.out.println(uniquePaths(p,q));
		}
	}

	private static int uniquePaths(int p, int q) {
		// TODO Auto-generated method stub
		int[][] ways = new int[p][q];
		
		for(int i=0;i<p;i++) {
			for(int j=0;j<q;j++){
				if(i==0||j==0)
					ways[i][j] = 1;
				else {
					ways[i][j] = ways[i-1][j] + ways[i][j-1];
				}
			}
		}
		
		return ways[p-1][q-1];
	}
	
	

}
