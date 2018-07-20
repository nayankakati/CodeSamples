package com.dsa.linkedList;

/**
 * Created by nayan.kakati on 5/19/18.
 */
public class LinkedList {
	Node head;

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		Node first =  new Node(1);
		linkedList.head = first;
		Node n1 =  new Node(2);
		first.next = n1;
		Node n2 = new Node(3);
		n1.next = n2;

		Node n = linkedList.head;
		while (n != null) {
			System.out.print(n.data + " ");
			n = n.next;
		}
	}
}
