package searching;

import java.util.Scanner;

public class Majority {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Majority().majorityElement(arr, n)); 
        }
	}
	
	static int majorityElement(int a[], int n)
    {
        // your code here
		return majorityElement(a, 0,n-1);
    }

	private static int majorityElement(int[] a, int l, int r) {
		// TODO Auto-generated method stub
		if(l==r)
			return a[l];
		
		int mid = (l+r)/2;	
		
		int majorL = majorityElement(a, l,mid);
		int majorR = majorityElement(a, mid+1,r);
		
		if(majorL==majorR)
			return majorL;
		
		int lcount = count(a,majorL,l,r);
		int rcount = count(a,majorR,l,r);
		
		int maj = (r-l+1)/2;
		
		if(lcount>maj)
			return majorL;
		else if(rcount>maj)
			return majorR;
		else
			return -1;
	}

	private static int count(int[] a, int num, int l, int r) {
		// TODO Auto-generated method stub
		int c = 0;
		for(int i=l;i<=r;i++) {
			if(a[i]==num)
				c++;
		}
		return c;
	}

}
