package backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class KthPermutationSequence {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		System.out.println(getPermutation(n, k));
		
	}

	public static String getPermutation(int n, int k) {
		
		int[] fact = new int[n+1];
        fact[0] = 1;
        for(int i=1;i<=n;i++){
        	
            fact[i] = i*fact[i-1];
        }
        
        ArrayList<String> nums = new ArrayList<>();
        for(int i=1;i<=n;i++)
            nums.add(""+i);    
        
        k--;  //0 indxing
        StringBuilder sb = new StringBuilder();
        
        for(int i=1;i<=n;i++){
            int indx = k/fact[n-i];
            sb.append(nums.get(indx));
            nums.remove(indx);
            k = k - (indx*fact[n-i]);
        }
        
        return sb.toString();
	}

}
