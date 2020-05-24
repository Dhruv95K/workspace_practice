package CodeforcesRound636Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BalancedArray {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int n = Integer.parseInt(br.readLine());

			balancedArray(n);
		}


	}

	private static void balancedArray(int n) {
		if(n/2 % 2 != 0) {
			System.out.println("NO");
			return;
		}
			
		int[] arr = new int[n];
		
		for(int i =0;i<n/2;i++) 
			arr[i] = 2*(i+1);
		
		for(int i = n/2;i<n-1;i++) 
			arr[i] =  arr[i-n/2] - 1;
		
		arr[n-1] = arr[n/2 - 1] + (n/2 - 1);
		System.out.println("YES");
		
		for(int i : arr)
			System.out.print(i+" ");
		
		System.out.println("");
	}

}
