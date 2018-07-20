package com.dsa.linkedList;

/**
 * Created by nayan.kakati on 5/20/18.
 */
public class LinkedListInsertion {
	Node head;

	public static void main(String[] args) {
		LinkedListInsertion linkedListInsertion = new LinkedListInsertion();
		Node first =  new Node(1);
		linkedListInsertion.head = first;
		Node n1 =  new Node(2);
		first.next = n1;
		Node n2 = new Node(3);
		n1.next = n2;
		print(linkedListInsertion.head);
		// 1. Insertion at head
		Node n0 = new Node(0);
		n0.next = linkedListInsertion.head;
		linkedListInsertion.head = n0;
		print(linkedListInsertion.head);

		// 2. Insertion after a node
		Node n4 = new Node(4);
		n4.next = n1.next;
		n1.next = n4;
		print(linkedListInsertion.head);
		// 3. Insertion at End
		Node n5 = new Node(5);
		Node endNode = getLastNode(linkedListInsertion);
		endNode.next = n5;
		print(linkedListInsertion.head);
	}

	private static Node getLastNode(LinkedListInsertion ll) {
		Node node = ll.head;
		while (node.next != null) {
			node = node.next;
		}
		return node;
	}

	 public static void print(Node node) {
		 System.out.println();
		 Node n = node;
		 while (n != null) {
			 System.out.print(n.data + " ");
			 n = n.next;
		 }
	}
}
