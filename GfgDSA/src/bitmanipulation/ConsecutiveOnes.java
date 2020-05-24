package bitmanipulation;

import java.util.Scanner;

public class ConsecutiveOnes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();

			ConsecutiveOnes obj = new ConsecutiveOnes();

			System.out.println(obj.maxConsecutiveOnes(n));
		}
	}

	public static int maxConsecutiveOnes(int x) {

		int count = 0;
		int max = 0;

		while (x > 0) {
			if ((x & 1) == 1)
				count++;
			else {
				if (count > max)
					max = count;
				count = 0;
			}
			x = x >> 1;
		}
		if (count > max)
			max = count;
		return max;
	}
}
