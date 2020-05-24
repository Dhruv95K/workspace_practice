package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeWithoutSpace {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while (t-- > 0) {
			String inputLine[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(inputLine[0]);
			int m = Integer.parseInt(inputLine[1]);
			int arr1[] = new int[n];
			int arr2[] = new int[m];
			inputLine = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				arr1[i] = Integer.parseInt(inputLine[i]);
			}
			inputLine = br.readLine().trim().split(" ");
			for (int i = 0; i < m; i++) {
				arr2[i] = Integer.parseInt(inputLine[i]);
			}

			merge(arr1, arr2, n, m);

			StringBuffer str = new StringBuffer();
			for (int i = 0; i < n; i++) {
				str.append(arr1[i] + " ");
			}
			for (int i = 0; i < m; i++) {
				str.append(arr2[i] + " ");
			}
			System.out.println(str);
		}

	}

	public static void merge(int arr1[], int arr2[], int n, int m) {
		// add your code here
		int i=0;
		
		while(i<n) {
			if(arr1[i]<=arr2[0])
				i++;
			else {
				int tmp = arr1[i];
				arr1[i] = arr2[0];
				arr2[0] = tmp;
				insertionSortLogic(arr2);
			}
		}
		
	}

	private static void insertionSortLogic(int[] arr2) {
		// TODO Auto-generated method stub
		int temp = arr2[0];
		int j=1;
		while(j<arr2.length && arr2[j]<temp) {
			arr2[j-1] = arr2[j];
			j++;
		}
		
		arr2[j-1] = temp;
	}

}
