/**
 * Fast linked list is just like usual double linked list except 
 * this one support fast (constant time) insertion and deletion operation.
 * Also you can insert only after the current lists index position and delete
 * nodes only in this position.
 */

package fastLinkedList;

public class FastLinkedList<T> {

	private int length;
	private int currentPos; // Keep track current node number in the list. 
	private Node currentNode;
	private Node sentinel;

	/* FastLinkedList invariants:
     * 1) list length equals number items except sentinel;
     * 2) added item follow after previos current and before previos current next;
     * 3) sentinel.next is always first item and sentinel.prev is always last item;
     * 4) after deleting currentNode equals currentNode.prev and currentNode.next equals
     * previous currentNode.next;
     * 5) Position very first item is 1 and last item is length.
	 */

	public FastLinkedList() {
		sentinel = new Node(null);
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		length = 0;
		currentPos = 0;
		currentNode = sentinel;
	}

	public boolean isEmpty() {
		return length() == 0;
	}

	public void insert(T data) {
		Node insertedNode = new Node(data);
		insertedNode.prev = currentNode;
		insertedNode.next = currentNode.next;
		currentNode.next.prev = insertedNode;
		currentNode.next = insertedNode;

		currentNode = insertedNode;
		++length;
		++currentPos;
	}

	public void remove() {
		if(currentPos != 0) {
			Node removedNode = currentNode;
			currentNode = removedNode.prev;
			currentNode.next = removedNode.next;
			removedNode.next.prev = currentNode;
			--currentPos;
			--length;
		}
	}

	public T getData() {
		return currentNode.getItem();
	}

	public int getCurrentPos() {
		return currentPos;
	}

	public void setCurrentPos(int index) {
		if(index >= 0 && index <= length()) {
			currentPos = index;
			Node runner = sentinel.next;
			while(runner != sentinel && index > 1) {
				runner = runner.next;
				--index;
			}
			currentNode = runner;
		}
	}

	public int length() {
		return length;
	}

	private class Node {
		private T item;
		Node prev, next;

		Node(T data, Node prev, Node next) {
			item = data;
			this.prev = prev;
			this.next = next;
		}

		Node(T data) {
			this(data, null, null);
		}

		T getItem() {
			return item;
		}
	}

}
