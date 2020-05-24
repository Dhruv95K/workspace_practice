package backtracking;

import java.util.ArrayList;
import java.util.Scanner;

public class PalindromePartitioning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String s = sc.nextLine();
		
		partition(s);
		
		System.out.println(res);
	}
	
	static ArrayList<ArrayList<String>> res;
	
	private static ArrayList<ArrayList<String>> partition(String s) {
		// TODO Auto-generated method stub
		res = new ArrayList<>();
		ArrayList<String> temp = new ArrayList<>();
		
		backTrack(s,0,temp);
		
		return res;
	}

	private static void backTrack(String s, int ind, ArrayList<String> temp) {
		// TODO Auto-generated method stub
		if(ind==s.length()) {
			res.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i=ind;i<s.length();i++) {
			if(isPal(s,ind,i)) {
				temp.add(s.substring(ind, i+1));
				backTrack(s, i+1, temp);
				temp.remove(temp.size()-1);
			}
		}
	}

	private static boolean isPal(String s, int l, int h) {
		// TODO Auto-generated method stub
		while(l<h) {
			if(s.charAt(l)!=s.charAt(h))
				return false;
			l++;h--;
		}
		return true;
	}

}
