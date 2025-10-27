
public class HashMap<K, V> {

	static class Entry<K, V> {
		Entry next;
		K key;
		V value;

		Entry(K key, V val) {
			this.key = key;
			this.value = val;
		}
	}

	private final Entry[] table;
	private final int capacity;
	private final int buckets;
	private final double loadFactor = 0.75;
	private int size;

	public HashMap(int capacity) {
		this.buckets = 100;
		this.table = new Entry[buckets];
		this.capacity = capacity;
		this.size = 0;
	}

	public HashMap() {
		this.buckets = 100;
		this.table = new Entry[buckets];
		this.capacity = 16;
		this.size = 0;
	}

	public V get(K key) {
		int bucket = key.hashCode() % buckets;
		if (table[bucket] == null) {
			return null;
		}

		return (V) findValue(table[bucket], key).value;
	}

	private Entry findValue(Entry head, K key) {
		while (head != null) {
			if (head.key.equals(key))
				return head;
			head = head.next;
		}

		return null;
	}

	public void put(K key, V val) {
		int bucket = key.hashCode() % buckets;
		if (table[bucket] == null) {
			table[bucket] = new Entry(key, val);
		} else {
			Entry head = table[bucket];
			Entry existingEntry = findValue(head, key);
			if (existingEntry == null) {
				Entry newEntry = new Entry(key, val);
				newEntry.next = table[bucket];
				table[bucket] = newEntry;
			} else {
				existingEntry.value = val;
			}
		}
	}

	public void delete(K key) {
		int bucket = key.hashCode() % buckets;
		if (table[bucket] != null) {
			if (table[bucket].key.equals(key)) {
				table[bucket] = table[bucket].next;
				return;
			} else {
				Entry head = table[bucket];
				while (head != null && head.next != null) {
					if (head.next.key.equals(key)) {
						head.next = head.next.next;
						return;
					}
					head = head.next;
				}
				// if(head.key.equals(obj))
			}
		}

		System.out.println("key does not exist");
	}

	public void print() {
		for (Entry pair : table) {
			while (pair != null) {
				System.out.print("[ " + pair.key + ", " + pair.value + " ],");
				pair = pair.next;
			}
		}
		System.out.println();
	}

	public static void main(String[] args) {
		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(2, 2);
		map.put(1, 1);
		map.put(3, 3);
		map.put(1001, 1001);
		map.put(2001, 2001);
		map.put(3001, 3001);
		map.put(4001, 4001);
		map.put(3001, 11);
		map.print();

		System.out.println(map.get(4001));
		System.out.println(map.get(2001));
		System.out.println(map.get(3001));
		System.out.println(map.get(1001));
		System.out.println(map.get(1));

		map.delete(4001);
		map.delete(1);
		map.print();

	}

}
