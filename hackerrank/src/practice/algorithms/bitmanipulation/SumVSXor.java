package practice.algorithms.bitmanipulation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumVSXor {

	public static int countUnsetBits(long n) {
		int unset = 0;
		while (n > 0) {
			if ((n & 1) == 0)
				unset++;
			n = n >> 1;
		}

		System.out.println(unset);
		return unset;
	}

	// Complete the sumXor function below.
	static long sumXor(long n) {
		if ((n & (n - 1)) == 0)
			return n;
		int p = countUnsetBits(n);
		return (long) Math.pow(2, p);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		long n = Long.parseLong(bufferedReader.readLine().trim());

		long result = sumXor(n);

		// bufferedWriter.write(String.valueOf(result));
		// bufferedWriter.newLine();
		System.out.println(result);
		bufferedReader.close();
		// bufferedWriter.close();
	}

}
