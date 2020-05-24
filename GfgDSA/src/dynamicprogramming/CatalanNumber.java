package dynamicprogramming;

import java.math.BigInteger;
import java.util.Scanner;

public class CatalanNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		
		while (testcases-- > 0) {
			int number = sc.nextInt();
			catalan = new BigInteger[number+1];
			for(int i=0;i<=number;i++){
				catalan[i] = BigInteger.ZERO;	
			}	
			System.out.println(findNthCatalanIterative(number));
		}
	}

	static BigInteger[] catalan;
	private static BigInteger findNthCatalan(int number) {
		// TODO Auto-generated method stub
		if(number<=1)
			return BigInteger.ONE;
		if(catalan[number]!=BigInteger.ZERO)
			return catalan[number];
		
		for(int i=0;i<number;i++) {
			catalan[number] = catalan[number].add(findNthCatalan(i).multiply(findNthCatalan(number-i-1)));
		}
		
		return catalan[number];
	}

	private static BigInteger findNthCatalanIterative(int number) {
		// TODO Auto-generated method stub
		if(number<=1)
			return BigInteger.ONE;	
		BigInteger[] catalan = new BigInteger[number+1];
		catalan[0] = BigInteger.ONE;
		
		for(int i=1;i<=number;i++){
			catalan[i] = BigInteger.ZERO;	
		}
		
		for(int i=1;i<=number;i++) {
			for(int j = 0;j<i;j++) {
				catalan[i] = catalan[i].add(catalan[j].multiply(catalan[i-j-1]));
			}
		}
		
		
		return catalan[number];
	}
	
	
	
}
