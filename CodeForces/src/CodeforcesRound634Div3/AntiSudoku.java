package CodeforcesRound634Div3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AntiSudoku {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			int[][] arr = new int[9][9];
			
			for (int i = 0; i < 9; i++) {
				String input = br.readLine();
				char[] c = input.toCharArray();
				for(int j = 0;j<9;j++)
					if(c[j] == '2')
						c[j] = '1';
				System.out.println(String.valueOf(c));
			}
		//	antiSudoku(arr);
		}

	}

	private static void antiSudoku(int[][] arr) {
		for (int i = 0; i < 9; i++) {
			for(int j = 0;j<9;j++)
				if(arr[i][j] == 2)
					arr[i][j] = 1;
		}
		
		for (int i = 0; i < 9; i++) {
			for(int j = 0;j<9;j++)
				System.out.print(arr[i][j]);
			System.out.println("");
		}
	}

}
