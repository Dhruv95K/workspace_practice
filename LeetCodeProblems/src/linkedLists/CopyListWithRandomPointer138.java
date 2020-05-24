package linkedLists;

import java.util.HashMap;
import java.util.Map;

/*
138. Copy List with Random Pointer
A linked list is given such that each node contains an additional random pointer which could point to any node in the 
list or null.
Return a deep copy of the list.

*/ 


class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

public class CopyListWithRandomPointer138 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Node copyRandomList(Node head) {
		Map<Node,Node> map = new HashMap<>();
		Node curr = head;
		
		while(curr!=null) {
			Node newNode = new Node();
			newNode.val = curr.val;
			map.put(curr, newNode);
			curr= curr.next;
		}
		
		curr = head;
		Node newHead = map.get(curr);
		
		while(curr!=null) {
			newHead.next = map.get(curr.next);
			newHead.random = map.get(curr.random);
			newHead = newHead.next;
			curr = curr.next;
		}
		
		return map.get(head);
		
	}

}
