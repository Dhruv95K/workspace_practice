package stacksAndQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class SlidingWindowMaximum {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String inputLine[] = br.readLine().trim().split(", ");
		int n = inputLine.length;
		ArrayList<Integer> A = new ArrayList<>();
		for (int i = 0; i < n; i++) {
		//	arr[i] = Integer.parseInt(inputLine[i]);
			A.add(Integer.parseInt(inputLine[i]));
		}

		System.out.println(slidingMaximum(A,9));

	}
	
	public static ArrayList<Integer> slidingMaximum(List<Integer> A, int B) {
        ArrayList<Integer> res = new  ArrayList<Integer>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for(int i=0;i<B;i++){
            if(q.isEmpty() || A.get(q.getLast()) >= A.get(i))
                q.add(i);
            else{
                while(!q.isEmpty() && A.get(q.getLast()) < A.get(i))
                    q.removeLast();
                q.add(i);
            }    
        }
        
        res.add(A.get(q.peek()));
        
        for(int i=B;i<A.size();i++){
            if(q.getLast() - q.getFirst() == B - 1)
                q.poll();
            while(!q.isEmpty() && A.get(q.getLast()) < A.get(i))
                q.removeLast();
            q.add(i);
            res.add(A.get(q.peek()));
        }
        
        return res;
    }

}
