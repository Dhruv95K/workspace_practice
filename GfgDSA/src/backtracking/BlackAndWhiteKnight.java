package backtracking;

import java.io.IOException;
import java.util.Scanner;

public class BlackAndWhiteKnight {

	public static void main(String[] args) throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t=0; t<T; t++) 
        {
            int N = sc.nextInt();
            int M = sc.nextInt();
            System.out.println(new BlackAndWhite().solve(N, M));
        }
    }

}

class BlackAndWhite {

	static long solve(int N, int M)
    {
		return 0;
    }

}
