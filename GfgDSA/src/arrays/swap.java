package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class swap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3};
		
		swap s = new swap();
		s.change(a);
		
		Set<ArrayList<Integer>> s1 = new HashSet<>();
		Set<String> s2 = new HashSet<>();
		
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.add(2);
		a1.add(1);
		a1.add(2);
		
		ArrayList<Integer> a2 = new ArrayList<Integer>();
		a2.add(2);
		a2.add(1);
		a2.add(2);
		
		s1.add(a1);
		//a1.add(3);
		s1.add(a2);
		
		System.out.println(s1);
		
		s2.add("ac");
		s2.add("bc");
		
		
	}

	
	void change(int[] a) {
		a[0]=a[1];
		
	}
}
