package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class MaximumDifference {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inputLine[] = br.readLine().trim().split(", ");
		int n = inputLine.length;
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; i++) {
		//	arr[i] = Integer.parseInt(inputLine[i]);
			A.add(Integer.parseInt(inputLine[i]));
		}

		System.out.println(solve(A,2));

	}
	
	public static int solve(ArrayList<Integer> A, int B) {
        long sum = 0L;
        int n = A.size();
        Collections.sort(A);
        
        for(int i:A)
            sum+=(long)i;
            
        long s1=0L,s2=0L;    
        for(int i=0;i<B;i++){
            s1+=(long)A.get(i);
            s2+=(long)A.get(n-i-1);
        }
        
        return (int)Math.max(sum-s1-s1,s2-sum+s2);
    }

}
