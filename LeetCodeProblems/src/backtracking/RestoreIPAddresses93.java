package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
93. Restore IP Addresses
Given a string containing only digits, restore it by returning all possible valid IP address combinations.

Example:
Input: "25525511135"
Output: ["255.255.11.135", "255.255.111.35"]
*/
public class RestoreIPAddresses93 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();

		System.out.println(restoreIpAddresses(s));

	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		restoreIpAddresses(s,0,"",res,0);
		
		return res;
	}

	private static void restoreIpAddresses(String s, int ind, String restored, List<String> res, int count) {
		if(ind == s.length()) {
			if(count == 4)
				res.add(restored);
			return;
		}
		
		if(count >= 4)
			return;
		
		
		for(int i = 1;i<4;i++) {
			if(ind + i >s.length())
				break;
			String temp = s.substring(ind, ind+i);
			if(temp.charAt(0) == '0' && temp.length() > 1)
				break;
			if( i == 3 && Integer.parseInt(temp) >= 256)
				break;
			restoreIpAddresses(s, ind+i, restored + temp + (count==3 ? "":"."), res, count+1);
		}
	}

}
