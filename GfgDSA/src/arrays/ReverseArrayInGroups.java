package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ReverseArrayInGroups {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
		while (t-- > 0) {
			String inputLine1[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(inputLine1[0]);
			int k = Integer.parseInt(inputLine1[1]);

			ArrayList<Integer> mv = new ArrayList<>();

			String inputLine2[] = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++) {
				mv.add(Integer.parseInt(inputLine2[i]));
			}

			ReverseArrayInGroups obj = new ReverseArrayInGroups();

			mv = obj.reverseInGroups(mv, n, k);

			StringBuffer str = new StringBuffer();

			for (int i = 0; i < n; i++) {
				str.append(mv.get(i) + " ");
			}
			System.out.println(str);
		}

	}
	
	
	public static ArrayList<Integer> reverseInGroups(ArrayList<Integer> mv, int n, int k) {
        // add your code here
      //  reverse(mv,0,k-1);
        int i;
        for(i = 0;(i+k)<n;i=i+k) {
        	reverse(mv,i,i+k-1);
        }
        
        reverse(mv,i,n-1);
        int a = Integer.MAX_VALUE;
        return mv;
        
    }
    
    public static void reverse(ArrayList<Integer> mv,int l,int r){
        while(l<r){
            
            swap(mv,l,r);
            l++;
            r--;
        }
        
    } 
    
    public static void swap(ArrayList<Integer> mv,int l,int r){
        
        int temp = mv.get(l);
        mv.set(l,mv.get(r));
        mv.set(r,temp);
    }
	
	
}