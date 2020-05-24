package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WaysToStairWithoutOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		while(t-- > 0){
		    
		    int m = sc.nextInt();
		    
		    DynamicProgramming obj = new DynamicProgramming();
		    
		    System.out.println(obj.countWays(m));
		    
		}
	}
	

}

class DynamicProgramming{
    
    // function to find number of ways 
    static Map<String,Long> ways;
    Long countWays(int m){
        ways = new HashMap<>();
        
        return countWays(m,1);
    }    
    
    static Long countWays(int m,int i){
        if(m==0)
            return 1L;
        if(m<0)
            return 0L;
        if(i>=3)
            return 0L;
        
        String key = m+"|"+i;    
        if(ways.get(key)!=null)
            return ways.get(key);
            
        ways.put(key,countWays(m-i,i) + countWays(m,i+1));    
        
        return ways.get(key);
    }
    
}