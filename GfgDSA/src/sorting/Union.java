package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Union {

	// TODO Auto-generated method stub
	public static void main(String args[]) throws IOException {
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {
			String st[] = read.readLine().trim().split(" ");
			int N = Integer.parseInt(st[0]);
			int M = Integer.parseInt(st[1]);

			int arr1[] = new int[N];
			int arr2[] = new int[M];

			st = read.readLine().trim().split(" ");
			for (int i = 0; i < N; i++)
				arr1[i] = Integer.parseInt(st[i]);

			st = read.readLine().trim().split(" ");
			for (int i = 0; i < M; i++)
				arr2[i] = Integer.parseInt(st[i]);

			Union obj = new Union();
			obj.findUnion(arr1, arr2, N, M);
			System.out.println();
		}
	}

	/**
	 * @param arr1
	 * @param arr2
	 * @param n
	 * @param m
	 */
	static void findUnion(int arr1[], int arr2[], int n, int m) {
		// add your code here
		Set<Integer> union = new HashSet<>();
		
		for(int i=0;i<n;i++) {
			union.add(arr1[i]);
		}
		
		for(int i=0;i<m;i++) {
			union.add(arr2[i]);
		}
		
		List<Integer> res = new ArrayList<>(union);
		Collections.sort(res);
		
		StringBuilder sb = new StringBuilder();
		
		for(Integer i:res)
			sb.append(i+" ");
		
		System.out.print(sb);
		
	}

}
