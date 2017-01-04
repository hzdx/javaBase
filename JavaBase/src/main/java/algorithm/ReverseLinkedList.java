package algorithm;

public class ReverseLinkedList {

	public static void main(String[] args) {
		int[] arr = { 1, 2, 3, 4, 5 };
		Node n = constructLinkedList(arr);
		System.out.println(showLinkedList(n));

		Node newNode = new ListReverser(n).getReverseListHead();
		System.out.println(showLinkedList(newNode));

	}

	static class ListReverser {
		Node head;
		Node newHead;

		public ListReverser(Node head) {
			this.head = head;
		}

		Node getReverseListHead() {
			reverseLinkedList(head);
			return newHead;
		}

		private Node reverseLinkedList(Node node) {
			if (node == null || node.next == null) {
				newHead = node;
				return node;
			}

			Node tail = reverseLinkedList(node.next);
			tail.next = node;
			node.next = null;

			return node;

		}
	}

	public static Node constructLinkedList(int[] arr) {
		if (arr == null || arr.length < 1)
			return null;
		Node first = new Node(arr[0]);
		Node last = first;
		for (int i = 1, len = arr.length; i < len; i++) {
			Node n = new Node(arr[i]);
			last.next = n;
			last = n;
		}
		return first;
	}

	public static String showLinkedList(Node headNode) {
		if (headNode == null) {
			return "null";
		}
		return headNode.val + " -> " + showLinkedList(headNode.next);

	}

	static class Node {
		Node(int val) {
			this.val = val;
		}

		int val;
		Node next;

	}

	void deleteNode(Node node) {
		if (node == null)
			return;

		//处理最后一个节点，这段代码在调用最开始出执行.
//		if (node.next == null) {
//			// 前面一个指向null,
//			node = null;
//		}

		node.val = node.next.val;
		node.next = node.next.next;
	}

	// TODO 判断链表是否有环
	boolean isCircle(Node head) {
		return false;
	}

}
