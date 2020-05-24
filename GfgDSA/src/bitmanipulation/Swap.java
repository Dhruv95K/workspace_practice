package bitmanipulation;

import java.util.Scanner;

public class Swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();

			Swap obj = new Swap();

			System.out.println(obj.swapBits(n));
		}
	}

	public static int swapBits(int n) {

		int even = 0xAAAAAAAA;
		int odd = 0x55555555;
		n = ((n & even)>>1) | ((n & odd)<<1);
		
		return n;
	}

}
