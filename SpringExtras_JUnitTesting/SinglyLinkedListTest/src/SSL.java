
public class SSL {

	public Node head;

	public SSL() {
		this.head = null;
	}

	public SSL(int value) {
		this.head = new Node(value);
	}

	public void add(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			head = newNode;
		} else {
			Node runner = head;
			while (runner.next != null) {
				runner = runner.next;
			}
			runner.next = newNode;
		}
	}

	public void remove() {
		Node runner = this.head;

		while (runner.next != null) {
			if (runner.next.next == null) {
				runner.next = new Node();
			}
			runner = runner.next;
		}
	}

	public void printValues() {
		String values = "";
		Node runner = this.head;
		while (runner.next != null) {
			values += runner.value + " --> ";
			runner = runner.next;
		}
		System.out.println(values);
	}

	public Node find(int value) {
		if (head == null)
			return head;
		Node runner = head;
		while (runner.next != null) {
			if (runner.value == value) {
				return runner;
			}
			runner = runner.next;
		}
		return runner;
	}

	public void removeAt(int position) {
		if (head == null)
			return;
		Node temp = head;

		if (position == 0) {
			head = temp.next;
			return;
		}

		// Find previous node of the node to be deleted
		for (int i = 0; temp != null && i < position - 1; i++)
			temp = temp.next;

		// If position is more than number of nodes
		if (temp == null || temp.next == null)
			return;

		Node next = temp.next.next;

		temp.next = next;
	}
	
	public void removeFront() {
		if(head != null) {
			head = head.next;
		}
	}

}
