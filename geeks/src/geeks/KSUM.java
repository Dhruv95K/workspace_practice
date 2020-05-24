package geeks;

import java.util.Arrays;
import java.util.Scanner;

public class KSUM {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0) {

			int n, k;
			n = sc.nextInt();
			k = sc.nextInt();
			int[] ar = new int[n];
			
			for (int i = 0; i < n; i++) {
				ar[i]=sc.nextInt();
			}
			
			Arrays.sort(ar);
			long sum = 0;
			
			for(int i=0;i<k;i++) {
				sum+=ar[i];
			}
			
			System.out.println(sum);

		}
	}

}
