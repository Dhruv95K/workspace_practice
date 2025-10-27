import java.util.HashMap;
import java.util.Map;

public class LRU<K,V> {
	private Node head,tail;
	private int size,capacity;
	private Map<K,Node> map;
	
	class Node{
		K key;
		V val;
		Node next;
		Node prev;
		
		Node(K key,V val){
			this.key = key;
			this.val = val;
			this.next = null;
			this.prev = null;
		}
	}
	
	public LRU(int capacity) {
		this.head = this.tail = null;
		this.map = new HashMap<>();
		this.size = 0;
		this.capacity = capacity;
	}
	
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	
	public int getSize() {
		return this.size;
	}
	
	public void put(K key,V val) {
		if(map.get(key) == null) {
			if(this.size == this.capacity) {
				deleteTail();
			}
			Node newNode = new Node(key, val);
			map.put(key, newNode);
			addAtHead(newNode);
			this.size++;
		}
		else {
			Node oldNode = map.get(key);
			oldNode.val = val;
			moveToHead(oldNode);
		}
	}

	public V get(K key) {
		if(!map.containsKey(key))
			return null;
		
		Node node = map.get(key);
		moveToHead(node);
		return node.val;
		
	}
	
	private void moveToHead(Node node) {
		delete(node);
		addAtHead(node);
	}
	
	private void addAtHead(Node node) {
		if(head == null)
			head = tail = node;
		else {
			node.next = head;
			head.prev = node;
			head = node;
		}
	}

	private void delete(Node node) {
		if(node == head) {
			deleteHead();
			return;
		}
		if(node == tail) {
			tail = tail.prev;
			tail.next = null;
			return;
		}
		
		node.prev.next = node.next;
		if(node.next != null )
			node.next.prev = node.prev;
	}

	private void deleteHead() {
		if(head == null)
			return;
		
		head = head.next;
		if(head == null)
			tail = null;
		else
			head.prev = null;
	}
	

	private void deleteTail() {
		if(tail == null)
			return;
		map.remove(tail.key);
		tail = tail.prev;
		if(tail == null)
			head = null;
		else
			tail.next = null;
		size--;
	}

	public void print() {
		Node cur = head;
		while(cur != null) {
			System.out.println(cur.key + " " + cur.val);
			cur = cur.next;
		}
	}
	
	public static void main(String[] args) {
		LRU<Integer,Integer> cache = new LRU<Integer, Integer>(2);
		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(2, 3);
		cache.put(4, 1);
//		cache.put(1, "Dhruv");
//		cache.put(2, "Parth");
//		cache.put(3, "Prajakta");
//		cache.put(4, "Roopal");
//		cache.put(5, "KJS");
		
//		cache.put(6, "Devika");
//		cache.put(2, "Parth2");
		
		System.out.println("Get from cache " + cache.get(1));
		System.out.println("Get from cache " + cache.get(2));
		
		cache.print();
		
	}

}
