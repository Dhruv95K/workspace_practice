package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationSum {

	static ArrayList<ArrayList<Integer>> res = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		while (t-- > 0) {
			String str[] = br.readLine().trim().split(" ");
			int n = Integer.parseInt(str[0]);
			ArrayList<Integer> list = new ArrayList<>();
			str = br.readLine().trim().split(" ");
			for (int i = 0; i < n; i++)
				list.add(Integer.parseInt(str[i]));
			str = br.readLine().trim().split(" ");
			int sum = Integer.parseInt(str[0]);

			res = new Sum().combinationSum(list, sum);
			if (res.size() == 0) {
				System.out.print("Empty");
			}

			// Print all combinations stored in res.
			for (int i = 0; i < res.size(); i++) {
				if (res.size() > 0) {
					System.out.print("(");
					List<Integer> ij = res.get(i);
					for (int j = 0; j < ij.size(); j++) {

						System.out.print(ij.get(j));
						if (j < ij.size() - 1)
							System.out.print(" ");
					}
					System.out.print(")");
				}
			}
			System.out.println();
			res.clear();
		}
	}

}

class Sum {
	static ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
		CombinationSum.res.clear();
		ArrayList<Integer> temp = new ArrayList<>();
		Collections.sort(A);
		
		combinationSum(A, B, 0, temp);

		return CombinationSum.res;
	}

	private static void combinationSumNonUnique(ArrayList<Integer> a, int b, int i, ArrayList<Integer> temp) {
		
		if (b == 0) {
			CombinationSum.res.add(new ArrayList<>(temp));
			return;
		}
		
		if (b < 0 || i == a.size()) {
			return;
		}
		
		temp.add(a.get(i));
		combinationSumNonUnique(a, b-a.get(i),i,temp);
		temp.remove(temp.size()-1);
		
		combinationSumNonUnique(a, b,i+1,temp);
	}
	
	public static void combinationSum(ArrayList<Integer> a, int target,int ind,ArrayList<Integer> temp){
	    if(target<0)
	        return;
	    
	    if(target == 0){
	    	CombinationSum.res.add(new ArrayList<Integer>(temp));
	        return;
	    }
	    
	    for(int i = ind;i<a.size();i++){
	        if(i>ind && a.get(i) == a.get(i-1))
	            continue;
	        
	        temp.add(a.get(i));
	        combinationSum(a,target-a.get(i),i,temp);
	        temp.remove(temp.size()-1);
	    }
	}
}
