package binarySearch;
/*
69. Sqrt(x)
Implement int sqrt(int x).

Compute and return the square root of x, where x is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

Example 1:
	Input: 4
	Output: 2
			
Example 2:
	Input: 8
	Output: 2
	Explanation: The square root of 8 is 2.82842..., and since 
	             the decimal part is truncated, 2 is returned.		
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SqrtX69 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		
		System.out.println(mySqrt(n));
	}

	
	 public static int mySqrt(int x) {
	        if(x == 0)
	            return 0;
	        
	        long l = 1L,r = (long)x;
	        long ans = -1;
	        while(l <= r){
	            long mid = l + (r-l)/2;
	            long sqr = mid*mid;
	            if(sqr <= x){
	                ans = mid;
	                l = mid+1;
	            }
	            else
	                r = mid-1;            
	        }
	        
	        return (int)ans;
	    }
}
