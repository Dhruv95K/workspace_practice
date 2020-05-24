package searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class AggressiveCows {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//		int n = Integer.parseInt(br.readLine());
		String inputLine[] = br.readLine().trim().split(", ");
		int n = inputLine.length;
//		int arr[] = new int[n];
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; i++) {
		//	arr[i] = Integer.parseInt(inputLine[i]);
			A.add(Integer.parseInt(inputLine[i]));
		}

		System.out.println(solve(A,385));

	}
	
	public static int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int n = A.size();
        int lo = 0,hi = A.get(n-1);
        int ans = 0;
        while(lo<=hi){
            int mid = (lo+hi)/2;
            if(check(A,mid,B)){
                ans = mid;
                lo = mid+1;
            }
            else
                hi = mid-1;
        }
        

        return ans;
    }
	
	public static boolean check(ArrayList<Integer> A,int mid,int B){
        int curr = A.get(0);
        int cnt = 1;
        for(Integer i : A){
            if(i-curr>=mid){
                curr=i;
                cnt++;
            }
        }
        if(cnt >= B)
            return true;
            
        return false;    
    }

}
