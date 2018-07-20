package com.newTasks;

import java.util.Map;
import java.util.TreeMap;
import java.util.Vector;

/**
 * Created by nayan.kakati on 2/26/18.
 */
public class BinaryTreeVerticalPrintEfficient {

	Node root;

	public static void getVertical(Node node, TreeMap<Integer, Vector<Integer>> map, int hd ) {
		if(node == null) return;

		Vector<Integer> hds = map.get(hd);
			if(hds == null) {
			hds = new Vector<>();
			hds.add(node.data);
		} else {
			hds.add(node.data);
		}
		map.put(hd,hds);

		getVertical(node.left, map,hd-1);
		getVertical(node.right, map, hd+1);
	}
	public static void printBTVertical(Node root) {
		TreeMap<Integer, Vector<Integer>> map = new TreeMap<>();
		int hd = 0;
		getVertical(root, map, hd);
			for(Map.Entry<Integer, Vector<Integer>> entry : map.entrySet()) {
				System.out.println(entry.getValue());
		}
	}
	public static void main(String...args) {
		/*Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.left.right = new Node(8);
		root.right.right.right = new Node(9);*/
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(5);
		root.left.right.right.right = new Node(6);
		printBTVertical(root);
	}
}
