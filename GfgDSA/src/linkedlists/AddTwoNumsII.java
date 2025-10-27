package linkedlists;

public class AddTwoNumsII {
	class node {
		int val;
		node next;

		public node(int val) {
			this.val = val;
		}
	}

	// Function to print linked list
	void printlist(node head) {
		while (head != null) {
			System.out.print(head.val + " ");
			head = head.next;
		}
	}

	node head1, head2, result;
	int carry;

	/* A utility function to push a value to linked list */
	void push(int val, int list) {
		node newnode = new node(val);
		if (list == 1) {
			newnode.next = head1;
			head1 = newnode;
		} else if (list == 2) {
			newnode.next = head2;
			head2 = newnode;
		} else {
			newnode.next = result;
			result = newnode;
		}

	}

	public void addLists() {
		if (head1 == null) {
			result = head2;
			return;
		}

		if (head2 == null) {
			result = head1;
			return;
		}

		int l1 = getLength(head1);
		int l2 = getLength(head2);

		if (l1 == l2)
			addSameSize(head1, head2);
		else {
			if (l1 < l2) {
				node temp = head1;
				head1 = head2;
				head2 = temp;
			}

			int diff = Math.abs(l1 - l2);
			node curr = head1;

			while (diff-- > 0)
				curr = curr.next;

			addSameSize(curr, head2);

			propagateCarry(head1, curr);
		}

		if (carry > 0) {
			node newNode = new node(carry);
			newNode.next = result;
			result = newNode;
		}

	}

	private void propagateCarry(node head1, node curr) {
		if (head1 != curr) {
			propagateCarry(head1.next, curr);
			int sum = head1.val + carry;
			carry = sum / 10;
			sum = sum % 10;

			node newNode = new node(sum);
			newNode.next = result;
			result = newNode;
		}
	}

	private void addSameSize(node head1, node head2) {
		if (head1 == null)
			return;

		addSameSize(head1.next, head2.next);

		int sum = head1.val + head2.val + carry;
		carry = sum / 10;
		sum = sum % 10;

		node newNode = new node(sum);
		newNode.next = result;
		result = newNode;

	}

	private int getLength(node head) {
		int l = 0;
		while (head != null) {
			l++;
			head = head.next;
		}
		return l;
	}

	public static void main(String args[]) {
		AddTwoNumsII list = new AddTwoNumsII();
		list.head1 = null;
		list.head2 = null;
		list.result = null;
		list.carry = 0;
		int arr1[] = { 9, 9, 9 };
		int arr2[] = { 1, 8 };

		// Create first list as 9->9->9
		for (int i = arr1.length - 1; i >= 0; --i)
			list.push(arr1[i], 1);

		// Create second list as 1->8
		for (int i = arr2.length - 1; i >= 0; --i)
			list.push(arr2[i], 2);

		list.addLists();

		list.printlist(list.result);
	}
}
