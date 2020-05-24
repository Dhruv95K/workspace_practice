package geeks;

import java.util.Scanner;

public class Josephus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0) {
			Josephus obj = new Josephus();

			int n, k;
			n = sc.nextInt();
			k = sc.nextInt();

			System.out.println(obj.josephus(n, k));

		}
	}
	
	private int josephus1(int n, int k) {
		// TODO Auto-generated method stub
		int l = n - highestPowerOfK(n, k);
		
		return ((2*l) + 1)%n;
	}
	
	

	private int josephus(int n, int k) {
		// TODO Auto-generated method stub
		if(n==1)
			return 1;
		
		return (josephus(n-1, k)+k-1)%n + 1;
	}

	
	
	private int highestPowerOfK(int n, int k) {
		// TODO Auto-generated method stub
		int p = (int)(Math.log(n)/Math.log(k));
		
		return (int)Math.pow(k, p);
	}

}
