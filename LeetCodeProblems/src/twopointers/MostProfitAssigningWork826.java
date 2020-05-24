package twopointers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
826. Most Profit Assigning Work
We have jobs: difficulty[i] is the difficulty of the ith job, and profit[i] is the profit of the ith job. 
Now we have some workers. worker[i] is the ability of the ith worker, which means that this worker can only complete a job with 
difficulty at most worker[i]. 
Every worker can be assigned at most one job, but one job can be completed multiple times.
For example, if 3 people attempt the same job that pays $1, then the total profit will be $3.  If a worker cannot 
complete any job, his profit is $0.
What is the most profit we can make?

Example 1:
	Input: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
	Output: 100 
	Explanation: Workers are assigned jobs of difficulty [4,4,6,6] and they get profit of [20,20,30,30] seperately.

Notes:
	1. 1 <= difficulty.length = profit.length <= 10000
	2. 1 <= worker.length <= 10000
	3. difficulty[i], profit[i], worker[i]  are in range [1, 10^5]
*/

public class MostProfitAssigningWork826 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] difficulty = new int[n];
		int[] profit = new int[n];

		int m = Integer.parseInt(br.readLine());
		int[] worker = new int[m];

		String[] input = br.readLine().split(",");
		for (int i = 0; i < n; i++)
			difficulty[i] = Integer.parseInt(input[i]);

		for (int i = 0; i < n; i++)
			profit[i] = Integer.parseInt(input[i]);

		for (int i = 0; i < m; i++)
			worker[i] = Integer.parseInt(input[i]);

		System.out.println(maxProfitAssignment(difficulty, profit, worker));

	}

	public static int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
		int n = difficulty.length;
		Job[] jobs = new Job[n];

		for (int i = 0; i < n; i++)
			jobs[i] = new Job(difficulty[i], profit[i]);

		Arrays.sort(jobs, new Comparator<Job>() {
			public int compare(Job o1, Job o2) {
				return o1.diff - o2.diff;
			}
		});
		Arrays.sort(worker);

		int ans = 0;
		int job_index = 0,best = 0;
		for (int i = 0; i < worker.length; i++) {
			while (job_index < n && jobs[job_index].diff <= worker[i])
				best = Math.max(best, jobs[job_index++].profit);
			ans += best;
		}

		return ans;
	}

}

class Job {
	int diff;
	int profit;

	public Job(int diff, int profit) {
		this.diff = diff;
		this.profit = profit;
	}
}
