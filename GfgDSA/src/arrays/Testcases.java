package arrays;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Testcases {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Scanner sc  = new Scanner(System.in);
		
/*		int T = sc.nextInt();
		
		while(T-->0) {
			int N = sc.nextInt();
			
			System.out.println(N);
		}
		
		String[] a = {"1","2","3"};
		
		Arrays.sort(a,new Comparator<String>() {

			@Override
			public int compare(String arg0, String arg1) {
				// TODO Auto-generated method stub
				return 0;
			}
			
		
		});*/
		
		
		SimpleDateFormat dateFormatter = new SimpleDateFormat();
		dateFormatter = new SimpleDateFormat("ddMMyyyy");
		String l_str = "2141995";
		try {
			dateFormatter.parse(l_str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
