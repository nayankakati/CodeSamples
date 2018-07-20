package com.dsa.linkedList;

/**
 * Created by nayan.kakati on 5/19/18.
 */
public class Node {
	Node next;
	int data;

	public Node(int data) {
		this.data = data;
		next = null;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}
