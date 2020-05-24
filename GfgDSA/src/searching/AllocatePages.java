package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AllocatePages {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(read.readLine());

		while (t-- > 0) {
			int sizeOfArray = Integer.parseInt(read.readLine());
			int arr[] = new int[sizeOfArray];

			String st[] = read.readLine().trim().split("\\s+");
			for (int i = 0; i < sizeOfArray; i++)
				arr[i] = Integer.parseInt(st[i]);
			
			int students = Integer.parseInt(read.readLine());
			
			System.out.println(allocateMinPages(arr,sizeOfArray,students));
		}
	}

	private static int allocateMinPages(int[] arr, int n, int s) {
		// TODO Auto-generated method stub
		if(s>n)
			return -1;	
		long sum=0L,max=0L;
		for(int i:arr) {
			sum+=(long)i;
			max = Math.max(max, (long)i);
		}
		long lo=max,hi=sum;
		
		while(lo<=hi) {
			long mid = lo + (hi-lo)/2;
			if(checkStudents(arr,mid)<=s) {
				hi=mid-1;
			}
			else
				lo=mid+1;
		}
		
		return (int)lo;
	}

	private static int checkStudents(int[] arr, long mid) {
		// TODO Auto-generated method stub
		long total=0;
		int count=1;
		for(int i:arr) {
			total+=(long)i;
			if(total>mid) {
				total=(long)i;
				count++;
			}
		}
		return count;
	}

}
