import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SpiralMatrixInput {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int side = Integer.parseInt(br.readLine());

		int[][] matrix = new int[side][side];

		String[] input = br.readLine().split(",");
		int index = 0;

		int k = 0, n = side, m = side, l = 0;

		while (k < n && l < m) {
			for(int i = l;i<m;i++)
				matrix[k][i] = Integer.parseInt(input[index++]);
			k++;
			
			for(int i = k;i<n;i++) 
				matrix[i][m-1] = Integer.parseInt(input[index++]);
			m--;
			
			if(k<n) {
				for(int i = m-1;i>=l;i--)
					matrix[n-1][i] = Integer.parseInt(input[index++]);
				n--;
			}
			
			if(l<m) {
				for(int i = n-1;i>=k;i--)
					matrix[i][l] = Integer.parseInt(input[index++]);
				l++;
			}
		}
		
		for(int[] mat : matrix)
			System.out.println(Arrays.toString(mat));
		
	}

}
