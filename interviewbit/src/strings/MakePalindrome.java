package strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakePalindrome {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s1 = br.readLine();
		System.out.println(solve(s1));
	}
	
	public static int solve(String A) {
        StringBuilder sb = new StringBuilder(A);
        int n = sb.length();
        sb.append("$");
        for(int i=n-1;i>=0;i--) {
        	sb.append(sb.charAt(i));
        }
        int ans = findLPS(sb);
   //     System.out.print(ans);
        return A.length() - ans;    
    }
    
    public static int findLPS(StringBuilder a){
        int[] lps = new int[a.length()];
        lps[0] = 0;
        int j = 0,i=1;
        while(i<a.length()){
            if(a.charAt(i) == a.charAt(j)){
               j++;
               lps[i] = j;
               i++;
            }
            else{
                if(j!=0)
                    j = lps[j-1];
                else{
                    lps[i]=0;
                    i++;
                }    
            }
        }
        return lps[a.length()-1];
    }
}
