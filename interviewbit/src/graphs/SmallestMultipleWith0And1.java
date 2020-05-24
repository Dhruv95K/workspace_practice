package graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class node {
	String val;
	int mod;
	
	public node(String val, int mod) {
		this.val = val;
		this.mod = mod;
	}
}

public class SmallestMultipleWith0And1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		System.out.println(multiple2(n));
	}
	
	//faster method - calculate mod as you go
	public static String multiple2(int A) {
		boolean[] visited = new boolean[A];
		Queue<node> q = new LinkedList<>();

		q.add(new node("1",1%A));
		visited[1%A] = true;
		
		while(!q.isEmpty()) {
			node t = q.poll();
			
			if(t.mod == 0)
				return t.val.toString();
			
			int rem0 = (t.mod * 10) % A;
			int rem1 = (t.mod * 10 + 1) % A;
			
			if(!visited[rem0]) {
				visited[rem0] = true;
				q.offer(new node(t.val + "0", rem0));
			}
			
			if(!visited[rem1]) {
				visited[rem1] = true;
				q.offer(new node(t.val + "1", rem1));
			}
		}
		
		return "";
	}

	//runs slow due to mod function
	public static String multiple(int A) {
		Set<Integer> visited = new HashSet<>();
		Queue<String> q = new LinkedList<>();

		q.add("1");
		
		while(!q.isEmpty()) {
			String t = q.poll();
			int rem = mod(t,A);
			
			if(rem == 0){
				return t;
			}
			
			if(!visited.contains(rem)) {
				visited.add(rem);
				q.offer(t + "0");
				q.offer(t + "1");
			}
		}
		
		return null;
	}

	private static Integer mod(String string, int a) {
		int r = 0;
		for (int i = 0; i < string.length(); i++) {
			r = r*10 + (string.charAt(i) - '0');
			r = r % a;
		}
		
		return r;
	}

}
