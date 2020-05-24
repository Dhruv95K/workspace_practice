package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NumberOfSqaurefulArrays {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];
		String[] input = br.readLine().split(" ");

		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int ans = solve(arr);
		System.out.println(ans);
	}

	static Map<Integer, Integer> count;
	static Map<Integer, List<Integer>> squareSums;

	private static int solve(int[] arr) {
		// TODO Auto-generated method stub
		count = new HashMap<>();
		squareSums = new HashMap<>();
		int ans = 0;

		for (int key : arr)
			count.put(key, count.getOrDefault(key, 0) + 1);

		for (int key : count.keySet())
			squareSums.put(key, new ArrayList<Integer>());

		for (int x : count.keySet()) {
			for (int y : count.keySet()) {
				if (Math.sqrt(x + y) == (int) Math.sqrt(x + y))
					squareSums.get(x).add(y);
			}
		}

		for (int key : count.keySet())
			ans += dfs(key, arr.length - 1);

		return ans;
	}

	private static int dfs(int x, int toDo) {
		count.put(x, count.get(x) - 1);
		int ans = 1;
		if(toDo!=0) {
			ans = 0;
			for(int y : squareSums.get(x)) 
				if(count.get(y) != 0)
					ans += dfs(y,toDo-1);
			
		}
		
		count.put(x, count.get(x) + 1);
		return ans;
	}

}
