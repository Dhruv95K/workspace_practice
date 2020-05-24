package arrays;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class practice {
	
	
	
	

	public static void main(String[] args) {
		Set<List<Integer>> result = new HashSet<>(); 
		List<Integer> l1 = new LinkedList<>();
		List<Integer> l2 = new LinkedList<>();
		
		l1.add(3);
		l1.add(2);
		l1.add(1);
		Collections.sort(l1);
		l2.add(1);
		l2.add(3);
		l2.add(2);
		Collections.sort(l2);
		
		result.add(l1);
		result.add(l2);

		System.out.println(result);

	}

	public static String reverseString(String s) {
		StringBuilder rev = new StringBuilder();
		rev.append(s);
		rev = rev.reverse();

		return rev.toString();
	}

}
