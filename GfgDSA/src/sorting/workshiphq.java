package sorting;

import java.sql.Time;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class TransactionInfo {

	Map<Long, Set<Integer>> info;

	public TransactionInfo() {
		info = new HashMap<>();
	}

	public String addTransaction(Transaction tran) {
		int id = tran.getTransactionId();
		long min = getMinutes(tran.time);

		long key = min;

		if (info.get(key) == null) {
			info.put(key, new HashSet<>());
		}

		for (long k : info.keySet()) {
			if (info.get(k).contains(id))
				return "DUPLICATE";
		}
		
		info.get(key).add(id);
		return "UNIQUE";
	}

	public void purge(long t) {
		long min = getMinutes(t);

		long key = min;
		long checkKey = key - 60;

		if (info.get(checkKey) != null)
			info.put(checkKey, null);
	}

	public long getMinutes(long time) {
		return time / 60000L;
	}

}

class Transaction {
	int id;
	long time;

	public Transaction(int id, long currTime) {
		this.id = id;
		this.time = currTime;
	}

	public int getTransactionId() {
		return this.id;
	}
}

public class workshiphq {

	public static void main(String[] args) {

		long currTime = System.currentTimeMillis();

		Transaction t1 = new Transaction(1, currTime - 20 * 60000);
		Transaction t2 = new Transaction(2, currTime - 25 * 60000);
		Transaction t3 = new Transaction(3, currTime - 25 * 60000);
		Transaction t4 = new Transaction(4, currTime - 25 * 60000);
		Transaction t5 = new Transaction(1, currTime - 35 * 60000);
		Transaction t6 = new Transaction(6, currTime - 60 * 60000);
		Transaction t7 = new Transaction(7, currTime - 60 * 60000);

		TransactionInfo tranInfo = new TransactionInfo();
		System.out.println(tranInfo.addTransaction(t1));
		System.out.println(tranInfo.addTransaction(t2));
		System.out.println(tranInfo.addTransaction(t3));
		System.out.println(tranInfo.addTransaction(t4));
		System.out.println(tranInfo.addTransaction(t5));
		System.out.println(tranInfo.addTransaction(t6));
		System.out.println(tranInfo.addTransaction(t7));

		System.out.println(tranInfo.info);
		
		tranInfo.purge(currTime);
		
		System.out.println(tranInfo.info);

	}

}
