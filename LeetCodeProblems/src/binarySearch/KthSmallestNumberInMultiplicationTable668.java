package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
668. Kth Smallest Number in Multiplication Table
Nearly every one have used the Multiplication Table. But could you find out the k-th smallest number quickly from the 
multiplication table?
Given the height m and the length n of a m * n Multiplication Table, and a positive integer k, you need to return the 
k-th smallest number in this table.

Example 1:
	Input: m = 3, n = 3, k = 5
	Output: 
	Explanation: 
	The Multiplication Table:
	1	2	3
	2	4	6
	3	6	9
	
	The 5-th smallest number is 3 (1, 2, 2, 3, 3).
	
Example 2:
	Input: m = 2, n = 3, k = 6
	Output: 
	Explanation: 
	The Multiplication Table:
	1	2	3
	2	4	6
	
	The 6-th smallest number is 6 (1, 2, 2, 3, 4, 6).
	
Note:
	1. The m and n will be in the range [1, 30000].
	2. The k will be in the range [1, m * n]
*/
public class KthSmallestNumberInMultiplicationTable668 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());

		System.out.println(findKthNumber(n, a, b));

	}

	public static int findKthNumber(int m, int n, int k) {
		int l = 1, r = 900000000;
		int ans = -1;

		while (l <= r) {
			int mid = l + (r - l) / 2;
			int count = lessThanOrEqual(m, n, mid);
			if (count >= k) {
				ans = mid;
				r = mid - 1;
			} else
				l = mid + 1;
		}
		
		return ans;
	}

	private static int lessThanOrEqual(int m, int n, int mid) {
		int count = 0;

		for (int i = 1; i <= m; i++) {
			count += Math.min(mid / i, n);
		}

		return count;
	}
	
	//timeout
	public int findKthNumberUsingHeap(int m, int n, int k) {
        PriorityQueue<Node> heap = new PriorityQueue<Node>(m,
            Comparator.<Node> comparingInt(node -> node.val));

        for (int i = 1; i <= m; i++) {
            heap.offer(new Node(i, i));
        }

        Node node = null;
        for (int i = 0; i < k; i++) {
            node = heap.poll();
            int nxt = node.val + node.root;
            if (nxt <= node.root * n) {
                heap.offer(new Node(nxt, node.root));
            }
        }
        return node.val;
    }
	
	

}

class Node {
    int val;
    int root;
    public Node(int v, int r) {
        val = v;
        root = r;
    }
}
