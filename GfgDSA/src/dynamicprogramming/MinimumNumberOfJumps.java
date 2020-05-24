package dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinimumNumberOfJumps {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			String[] inputLine = br.readLine().split(" ");
			for(int i=0;i<n;i++) {
				arr[i] = Integer.parseInt(inputLine[i]);
			}
			
			System.out.println(minimumNumberOfJumps(arr,n));
		}
		
	}

	private static int minimumNumberOfJumps(int[] arr,int n) {
		// TODO Auto-generated method stub
		int[] jumps = new int[n];
		jumps[0] = 0;
		
		for(int i=1;i<n;i++) {
			jumps[i] = Integer.MAX_VALUE;
			for(int j=0;j<i;j++) {
				if(j+arr[j]>=i && jumps[j]!=Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[j] + 1,jumps[i]);
					break;
				}
			}
		}
		
		return jumps[n-1]==Integer.MAX_VALUE ? -1 : jumps[n-1];
	}

}
