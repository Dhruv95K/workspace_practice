package sorting;

import java.util.Scanner;

public class Inversion_of_Array {

	public static void main (String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();
        
        while(t-- > 0)
        {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];
            
            for(long i = 0; i < n; i++)
             arr[(int)i] = sc.nextLong();
             
            System.out.println(new Inversion_of_Array().inversionCount(arr, n));
            
        }
    }

	private long inversionCount(long[] arr, long n) {
		// TODO Auto-generated method stub
		
		long ans = invCount(arr,0,n-1);
		
		return ans;
	}

	private long invCount(long[] arr, long l, long r) {
		// TODO Auto-generated method stub
		long count = 0;
		if(l>=r)
			return 0;
		
		long mid = l + (r-l)/2;
		count += invCount(arr, l, mid);
		count += invCount(arr, mid+1, r);
		count += merge(arr,l,mid,r);
		
		return count;
	}

	private long merge(long[] arr, long l, long mid, long r) {
		
		long count =0;
		long[] c = new long[(int)(r-l+1)];
		int i=(int)l,j=(int)mid+1,k=0;
		
		while(i<=mid&&j<=r) {
			if(arr[i]<=arr[j]) {
				c[k++]=arr[i++];
			}
			else {
				c[k++]=arr[j++];
				count += mid-i+1;
			}
		}
		while(i<=mid)
			c[k++]=arr[i++];
		
		while(j<=r)
			c[k++]=arr[j++];
		i=0;
		int m=(int)l;
		while(m<=r)
		{
		   arr[m++]=c[i++];
		}
		
		return count;
	}

}
