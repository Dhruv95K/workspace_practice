package hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;



public class Number123 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for (int g = 0; g < t; g++) {
			int n = Integer.parseInt(br.readLine().trim());
			int arr[] = new int[n];
			
			String inputLine[] = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(inputLine[i]);
			}
			
			printNumbers123(arr, n);
			System.out.println();

		}
	}

	private static void printNumbers123(int[] arr, int n) {
		// TODO Auto-generated method stub
		
		Set<Integer> num = createHashSet(100000);
		StringBuilder sb = new StringBuilder();
		Arrays.sort(arr);
		for(int i:arr) {
			if(!num.add(i))
				sb.append(i+" ");
		}
		
		if(sb.length()==0)
			System.out.print(-1);
		else
			System.out.print(sb.toString().trim());
	}

	private static Set<Integer> createHashSet(int a) {
		// TODO Auto-generated method stub
		Set<Integer> num = new HashSet<>();
		for(int i=1;i<=a;i++) {
			if(isDigitPresent(i))
				num.add(i);	
		}
		
		return num;
	}

	private static boolean isDigitPresent(int i) {
		// TODO Auto-generated method stub
		String str = Integer.toString(i);
		if(str.contains("0")||str.contains("4")||str.contains("5")||str.contains("6")||str.contains("7")||str.contains("8")||str.contains("9"))
			return false;	
		
		return true;
	}

}
