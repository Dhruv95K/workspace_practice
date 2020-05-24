package practice.algorithms.bitmanipulation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class flippingbits {

	static long flippingBits(long n) {

        int x = (int)(Math.log((int)n)/Math.log(2)) + 1;

        for(int i=0;i<x;i++){
            n = n ^ (1<<i);
        }

        return n;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            long n = scanner.nextLong();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            long result = flippingBits(n);

            System.out.println(result);
        }

        scanner.close();
    }

}
