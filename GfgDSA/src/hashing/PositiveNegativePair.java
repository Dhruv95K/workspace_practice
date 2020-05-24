package hashing;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PositiveNegativePair {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
		//	int arr[] = new int[n];
			Set<Integer> s = new HashSet<>();
			for (int i = 0; i < n; i++) {
			//	arr[i] = sc.nextInt();
				s.add(sc.nextInt());
			}
			
			System.out.println(pairs(s, n));

		}
	}

	private static String pairs(Set<Integer> s, int n) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		for(int i:s) {
			if(i>0) {
				if(s.contains(0-i))
					sb.append(i+" "+(0-i));
			}
		}
		return sb.toString();
	}

}
