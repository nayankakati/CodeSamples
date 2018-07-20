package com.dsa.linkedList;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by nayan.kakati on 6/24/18.
 */
public class LinkedListTraversalAndChecks {

	Node head;

	public static void main(String[] args) {
		findMiddleOfLinkedList(getLinkedListTraversalAndChecks().head);
		findIfLoopPresent(getLoopedLinkedListTraversalAndChecks().head);
		detectLoop(getLoopedLinkedListTraversalAndChecks().head);
		detectLoopAndCount(getLoopedLinkedListTraversalAndChecks().head);
		checkPallindrome(getPallindromeList().head);
		checkPallindrome(getLinkedListTraversalAndChecks().head);
		removeDuplicateElementFromSortedList(getDuplicatedSortedList().head);
	}

	private static void removeDuplicateElementFromSortedList(Node head) {
		Node current = head;
		print(head);
		while (current != null) {
			if(current.data == current.next.data) {
				Node storeCurrent = current.next.next;
				current.next = null;
				current.next = storeCurrent;
				break;
			}
			current = current.next;
		}
		print(head);
	}

	private static void checkPallindrome(Node head) {
		// Another way in S(1) is to find the middle element then reverse the second half and comapre with the first half
		Stack<Node> stack = new Stack<>();
		Node temp = head;
		while (temp != null) {
			stack.push(temp);
			temp = temp.next;
		}

		temp = head;
		while (temp != null) {

			Node pop = stack.pop();
			if(pop.data != temp.data) {
				System.out.println("Linked List is not a pallindrome");
				return;
			}
			temp = temp.next;
		}
		System.out.println("Linked List is a Pallindrome");
	}

	private static void detectLoopAndCount(Node head) {
		Node loopStartNode = findIfLoopPresent(head);
		int count = 1;
		Node ptr = loopStartNode.next;
		while (ptr != loopStartNode) {
			count++;
			ptr = ptr.next;
		}
		System.out.println("Length of the loop is "+ count);
	}

	private static Node findIfLoopPresent(Node head) {
		int count =0;
		Map<Node, Integer> hash = new HashMap<>();
		Node ptr = head;
		while (ptr != null) {
			count++;
			Integer temp = hash.get(ptr);
			if(temp != null) {
				System.out.println("Loop detected ---> at node  "+ ptr.data + " and iteration in " + count);
				return ptr;
			}
			hash.put(ptr, ptr.data);
			ptr = ptr.next;
		}
		return null;
	}

	private static Node detectLoop(Node head) {
		int count = 0;
		Node slow_p = head, fast_p = head;
		while (slow_p != null && fast_p != null && fast_p.next != null) {
			count++;
			slow_p = slow_p.next;
			fast_p = fast_p.next.next;
			if (slow_p == fast_p) {
				System.out.println("Found loop " + "and iteration in " + count);
				return slow_p;
			}
		}
		return null;
	}

	private static void findMiddleOfLinkedList(Node head) {
		Node ptr_1 = head;
		Node ptr_2 = head;

		while (ptr_2 != null && ptr_2.next != null) {
			ptr_1 = ptr_1.next;
			ptr_2 = ptr_2.next.next;
		}
		System.out.println(ptr_1.data);
	}

	private static LinkedListTraversalAndChecks getLinkedListTraversalAndChecks() {
		LinkedListTraversalAndChecks linkedListTraversalAndChecks = new LinkedListTraversalAndChecks();
		Node first =  new Node(1);
		linkedListTraversalAndChecks.head = first;
		Node n1 =  new Node(2);
		first.next = n1;
		Node n2 = new Node(3);
		n1.next = n2;
		Node n3 = new Node(4);
		n2.next = n3;
		Node n4 = new Node(5);
		n3.next = n4;
		Node n5 = new Node(6);
		n4.next = n5;
		return linkedListTraversalAndChecks;
	}

	private static LinkedListTraversalAndChecks getLoopedLinkedListTraversalAndChecks() {
		LinkedListTraversalAndChecks linkedListTraversalAndChecks = new LinkedListTraversalAndChecks();
		Node first =  new Node(1);
		linkedListTraversalAndChecks.head = first;
		Node n1 =  new Node(2);
		first.next = n1;
		Node n2 = new Node(3);
		n1.next = n2;
		Node n3 = new Node(4);
		n2.next = n3;
		Node n4 = new Node(5);
		n3.next = n4;
		n4.next = n2;
		return linkedListTraversalAndChecks;
	}

	private static LinkedListTraversalAndChecks getPallindromeList() {
		LinkedListTraversalAndChecks linkedListTraversalAndChecks = new LinkedListTraversalAndChecks();
		Node first =  new Node(1);
		linkedListTraversalAndChecks.head = first;
		Node n1 =  new Node(2);
		first.next = n1;
		Node n2 = new Node(3);
		n1.next = n2;
		Node n3 = new Node(2);
		n2.next = n3;
		Node n4 = new Node(1);
		n3.next = n4;
		n4.next = null;
		return linkedListTraversalAndChecks;
	}

	private static LinkedListTraversalAndChecks getDuplicatedSortedList() {
		LinkedListTraversalAndChecks linkedListTraversalAndChecks = new LinkedListTraversalAndChecks();
		Node first =  new Node(1);
		linkedListTraversalAndChecks.head = first;
		Node n1 =  new Node(2);
		first.next = n1;
		Node n2 = new Node(3);
		n1.next = n2;
		Node n3 = new Node(3);
		n2.next = n3;
		Node n4 = new Node(4);
		n3.next = n4;
		n4.next = null;
		return linkedListTraversalAndChecks;
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
