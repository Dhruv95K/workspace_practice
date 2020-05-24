package binarySearch;
/*
367. Valid Perfect Square
Given a positive integer num, write a function which returns True if num is a perfect square else False.

Note: Do not use any built-in library function such as sqrt.

Example 1:	
	Input: 16
	Output: true
	
Example 2:	
	Input: 14
	Output: false
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidPerfectSquare367 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(isPerfectSquare(n));

	}
	
	public static boolean isPerfectSquare(int x) {
        if(x == 0)
            return false;
        
        long l = 1L,r = (long)x;
        long ans = -1;
        while(l <= r){
            long mid = l + (r-l)/2;
            long sqr = mid*mid;
            if(sqr == (long)x)
                return true;
            if(sqr < x){
                l = mid+1;
            }
            else
                r = mid-1;            
        }
        
        return false;
    }
	

}
