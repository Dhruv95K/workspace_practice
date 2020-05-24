package dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

public class MinNumberOfCoins {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testcases = sc.nextInt();
		while (testcases-- > 0) {
			int value = sc.nextInt();
			int numberOfCoins = sc.nextInt();
			int coins[] = new int[numberOfCoins];

			for (int i = 0; i < numberOfCoins; i++) {
				int x = sc.nextInt();
				coins[i] = x;
			}

			long answer = minimumNumberOfCoins(coins, numberOfCoins, value);
			System.out.println(answer == Integer.MAX_VALUE ? "Not Possible" : answer);
		}
	}

	public static long minimumNumberOfCoins(int coins[],int numberOfCoins,int value)
    {
        long minimumNumberOfCoinsRequired[]=new long[value+1];
        //The above array holds the minimum number of coins for every amount from 0 to value
        Arrays.fill(minimumNumberOfCoinsRequired,Integer.MAX_VALUE);
        //We fill all array with inifinty as intially we need infinite coins to make the value
        minimumNumberOfCoinsRequired[0]=0;
        for(int coin:coins)//Iterating over each coin
        {
            for(int i=1;i<value+1;i++)
            {
                if(i>=coin) {
                   minimumNumberOfCoinsRequired[i] = Math.min(minimumNumberOfCoinsRequired[i-coin]+1,minimumNumberOfCoinsRequired[i]);
                }
            }
        }
	return minimumNumberOfCoinsRequired[value];
}

}
