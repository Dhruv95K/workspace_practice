package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Intersection {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
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

			new Intersection().printIntersection(arr1, arr2, N, M);
			System.out.println();
		}
	}

	static void printIntersection(int arr1[], int arr2[], int n, int m) {

		Set<Integer> res = new HashSet<>();
		List<Integer> l = new ArrayList<>(res);

		for (int i : arr1) {
			res.add(i);
		}

		for (int i = 0; i < m; i++) {
			if(res.contains(arr2[i])) {
				l.add(arr2[i]);
				res.remove(arr2[i]);
			}
		}

		if(l.isEmpty()){
		    System.out.print(-1);
		    return;
		}
				
		Collections.sort(l);

		StringBuilder sb = new StringBuilder();

		for (Integer i : l)
			sb.append(i + " ");

		System.out.print(sb);
	}

}
