package com.newTasks;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

/**
 * Created by nayan.kakati on 2/26/18.
 */
public class BinaryTreeBottomViewPrint {


	class QItem
	{
		Node node;
		int hd;
		public QItem(Node n, int h)
		{
			node = n;
			hd = h;
		}
	}

	public void printBottomViewTree(Node root) {

		Map<Integer, Integer> map = new TreeMap<>();
		Queue<QItem> queue = new LinkedList<>();

		QItem item = new QItem(root, 0);
		queue.add(item);

		while (!queue.isEmpty()) {
			QItem temp = queue.remove();
			map.put(temp.hd, temp.node.data);

			if(temp.node.left != null) {
				queue.add(new QItem(temp.node.left, temp.hd - 1));
			}
			if(temp.node.right != null) {
				queue.add(new QItem(temp.node.right, temp.hd + 1));
			}
		}

	}
	public static void main(String...args) {
// get values from map
	}
}
