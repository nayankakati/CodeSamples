package dsa.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nayan.kakati on 2/26/18.
 */
public class BinaryTreeTopViewPrint {

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

	public void printTopView(Node root)
	{
		// base case
		if (root == null) {  return;  }

		// Creates an empty hashset
		HashSet<Integer> set = new HashSet<>();

		// Create a queue and add root to it
		Queue<QItem> Q = new LinkedList<>();
		Q.add(new QItem(root, 0)); // Horizontal distance of root is 0

		// Standard BFS or level order traversal loop
		while (!Q.isEmpty())
		{
			// Remove the front item and get its details
			QItem qi = Q.remove();
			int hd = qi.hd;
			Node n = qi.node;

			// If this is the first node at its horizontal distance,
			// then this node is in top view
			if (!set.contains(hd))
			{
				set.add(hd);
				System.out.print(n.data + " ");
			}

			// Enqueue left and right children of current node
			if (n.left != null)
				Q.add(new QItem(n.left, hd-1));
			if (n.right != null)
				Q.add(new QItem(n.right, hd+1));
		}
	}

	public static void main(String...args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.right = new Node(4);
		root.left.right.right = new Node(5);
		root.left.right.right.right = new Node(6);
		BinaryTreeTopViewPrint tree = new BinaryTreeTopViewPrint();
		tree.printTopView(root);
	}
}
