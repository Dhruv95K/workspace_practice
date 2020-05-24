package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MedianTwo {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		/*Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			int[] a1 = new int[n];
			int[] a2 = new int[m];

			for (int k = 0; k < n; k++) {
				a1[k] = sc.nextInt();
			}
			
			for (int j = 0; j < m; j++) {
				a2[j] = sc.nextInt();
			}

			MedianTwo obj = new MedianTwo();
			int median = obj.findMedian(a1, a2, n, m);
			System.out.println();
		}*/
		
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {
			String st[] = read.readLine().trim().split("\\s+");
			
			int n = Integer.parseInt(st[0]);
			int m = Integer.parseInt(st[1]);
						
			int a1[] = new int[n];
			int a2[] = new int[m];
			
			st = read.readLine().trim().split("\\s+");
			
			for (int i = 0; i < n; i++)
				a1[i] = Integer.parseInt(st[i]);
			
			st = read.readLine().trim().split("\\s+");			
			
			for (int i = 0; i < m; i++)
				a2[i] = Integer.parseInt(st[i]);

			MedianTwo obj = new MedianTwo();
			int median = obj.findMedian(a1, a2, n, m);
			System.out.println(median);
		}


	}

	private int findMedian(int[] a1, int[] a2, int n, int m) {
		// TODO Auto-generated method stub
		int[] merged = merge(a1, a2, n, m);
		
		int median = 0;
		if((n+m)%2==0)
			median = (merged[(n+m)/2]+merged[((n+m)/2) - 1])/2;
		else 
			median = merged[(n+m)/2];
		
		return median;
	}

	private int[] merge(int[] a1, int[] a2, int n, int m) {
		// TODO Auto-generated method stub

		int i = 0, j = 0,k=0;
		int[] merged = new int[n+m];
		
		while(i<n&&j<m) {
			if(a1[i]<a2[j]) {
				merged[k++]=a1[i++];
			}
			else
				merged[k++]=a2[j++];
		}
		
		while(i<n)
			merged[k++]=a1[i++];
		
		while(j<m)
			merged[k++]=a2[j++];
		
		return merged;
	}

}
