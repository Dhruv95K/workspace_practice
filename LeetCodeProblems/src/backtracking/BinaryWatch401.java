package backtracking;
/*
401. Binary Watch
A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent 
the minutes (0-59).
Each LED represents a zero or one, with the least significant bit on the right.

For example, the above binary watch reads "3:25".

Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible 
times the watch could represent.

Example:
	Input: n = 1
	Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]

Note:
	1. The order of output does not matter.
	2. The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
	3. The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BinaryWatch401 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		List<String> ans = readBinaryWatch(n);
		System.out.println(ans);
	}

	public static List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<String>();

		for (int h = 0; h < 12; h++) {
			for (int s = 0; s < 60; s++) {
				if (Integer.bitCount(h) + Integer.bitCount(s) == num)
					res.add(h + ":" + ((s < 10) ? "0" + s : s));
			}
		}

		return res;
	}

	// 2nd solution
	static String[][] hrs = { { "0" }, 
			{ "1", "2", "4", "8" }, 
			{ "3", "5", "6", "9", "10" }, 
			{ "7", "11" }};
	static String[][] minute = {{"00"},
            {"01", "02", "04", "08", "16", "32"},
            {"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40", "48"},
            {"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44", "49", "50", "52", "56"},
            {"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"},
            {"31", "47", "55", "59"}};

	public static List<String> readBinaryWatch2(int num) {
		List<String> res = new ArrayList<String>();

		for(int i =0;i<=num  && i<=3;i++) {
			if(num-i<=5) {
				for(String st1 : hrs[i])
					for(String st2 : minute[num-i])
						res.add(st1+":"+st2);
						
			}
		}

		return res;
	}

}
