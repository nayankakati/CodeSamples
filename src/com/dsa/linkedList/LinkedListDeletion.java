package com.dsa.linkedList;

/**
 * Created by nayan.kakati on 5/27/18.
 */
public class LinkedListDeletion {
	static Node head;

	public static void main(String[] args) {
		LinkedListDeletion linkedListDeletion = new LinkedListDeletion();
		Node first =  new Node(1);
		linkedListDeletion.head = first;
		Node n1 =  new Node(2);
		first.next = n1;
		Node n2 = new Node(3);
		n1.next = n2;
		Node n3 = new Node(4);
		n2.next = n3;
		Node n4 = new Node(5);
		n3.next = n4;
		n4.next = null;
		lengthOfLinkedList(head);
		print(linkedListDeletion.head);
		deleteNodeWithKey(head, 3);
		print(linkedListDeletion.head);
		deleteNodeWithPosition(head, 2);
		print(linkedListDeletion.head);
	}

	private static void deleteNodeWithPosition(Node node , int pos){
		int count = 0;
		Node temp = node;
		Node prev = null;

		if(pos == 0) {
			head = temp.next;
		}

		while (temp != null && count != pos) {
			prev = temp;
			temp = temp.next;
			count++ ;
		}
		prev.next = temp.next;
	}
	private static void deleteNodeWithKey(Node node, int key) {
		Node temp = node;
		Node prev = null;
		if(node != null && node.data == key) {
			head = temp.next;
			return;
		}

		while (temp !=null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		prev.next = temp.next;

		System.out.println("-----------------");
	}
	public static void print(Node node) {
		Node n = node;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}
		System.out.println("-----------------");
	}

	public static int lengthOfLinkedList(Node node) {
		int length = 0 ;
		Node n = node;
		while (n != null) {
			n = n.next;
			length ++;
		}
		System.out.println("-----------------");
		return length;
	}
}
