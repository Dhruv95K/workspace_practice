package binarySearch;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 852. Peak Index in a Mountain Array
Let's call an array A a mountain if the following properties hold:

A.length >= 3
There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
Given an array that is definitely a mountain, 
return any i such that A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
	
Example 1:
	Input: [0,1,0]
	Output: 1

Example 2:
	Input: [0,2,1,0]
	Output: 1
	
Note:
1. 3 <= A.length <= 10000
2. 0 <= A[i] <= 10^6
3. A is a mountain, as defined above.

*/
public class PeakIndexInAMountainArray852 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(input[i]);
		}

		int index = peakIndexInMountainArray(arr);

		System.out.println(index);
	}

	public static int peakIndexInMountainArray(int[] A) {

		int l = 0, r = A.length - 1;
		int mid = 0;

		while (l <= r) {
			mid = l + (r - l) / 2;
			if ((mid == 0 || A[mid] > A[mid - 1]) && (mid == A.length - 1 || A[mid] >= A[mid + 1]))
				return mid;
			else if (mid > 0 && A[mid - 1] >= A[mid])
				r = mid - 1;
			else
				l = mid + 1;
		}
		
		return mid;

	}
}
