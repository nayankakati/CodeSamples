package com.newTasks;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nayan.kakati on 2/27/18.
 */
public class BinaryTreeRightView {

	static  void printRightView(Node root) {
		if(root == null) return;

		Queue<Node> Q = new LinkedList<>();
		Q.add(root);

		while (!Q.isEmpty()) {
			int n = Q.size();
			for(int i =1; i<=n; i++) {
				Node temp = Q.poll();
				if(i == n)
					System.out.println(temp.data);

				if(temp.left != null)
					Q.add(temp.left);

				if(temp.right != null)
					Q.add(temp.right);
			}
		}
	}

	public static void main(String...args) {
		Node root = new Node(10);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(7);
		root.left.right = new Node(8);
		root.right.right = new Node(15);
		root.right.left = new Node(12);
		root.right.right.left = new Node(14);
		printRightView(root);
	}
}
