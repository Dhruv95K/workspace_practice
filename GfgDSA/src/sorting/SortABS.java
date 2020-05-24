package sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortABS {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int n = Integer.parseInt(inputLine[0]);
		    int x = Integer.parseInt(inputLine[1]);
		    
		    int arr[] =  new int[n];
		    inputLine = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    new SortABS().sortABS(arr,n, x);
		    System.out.println();
		}
	}

	static void sortABS(int arr[], int n,int k)
    {
        List<Integer> list = new ArrayList<Integer>();
        for(int i:arr)
        	list.add(i);
        
        Collections.sort(list, new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				// TODO Auto-generated method stub
				if(Math.abs(a-k)<=Math.abs(b-k))
					return -1;
				else if(Math.abs(a-k)==Math.abs(b-k))
					return 0;
				else
					return 1;
			}
		});
        
        StringBuilder sb = new StringBuilder();
        for(int i : list)
        	sb.append(i+" ");
        
        System.out.print(sb);
    }
	
}

