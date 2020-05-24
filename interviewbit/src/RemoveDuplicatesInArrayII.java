import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatesInArrayII {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		List<Integer> list = new ArrayList<>();
		
		String[] input = br.readLine().split(" ");
		for(int i = 0;i<n;i++)
			list.add(Integer.parseInt(input[i]));
		
		System.out.println(removeDuplicates(list));
		System.out.println(list);

	}
	
	public static int removeDuplicates(List<Integer> list) {
	    int n = list.size();
	    int j = 0;
	    for(int i = 0;i<n;i++){
	        if(i<n-2 && (int)list.get(i) == (int)list.get(i+2))
	            continue;
	            
	        list.set(j,list.get(i));
	        j++;
	    }
	    
	    return j;
	}

}
