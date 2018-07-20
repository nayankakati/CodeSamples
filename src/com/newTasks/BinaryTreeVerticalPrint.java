package com.newTasks;

/**
 * Created by nayan.kakati on 2/25/18.
 */
public class BinaryTreeVerticalPrint {

	Node root;
	public class Values {
		int min,max;
	}

	Values val = new Values();
	void findMinMax(Node node, Values min, Values max, int hd)
	{
		// Base case
		if (node == null)
			return;

		// Update min and max
		if (hd < min.min)
			min.min = hd;
		else if (hd > max.max)
			max.max = hd;

		// Recur for left and right subtrees
		findMinMax(node.left, min, max, hd - 1);
		findMinMax(node.right, min, max, hd + 1);
	}

	// A utility function to print all nodes on a given line_no.
	// hd is horizontal distance of current node with respect to root.
	void printVerticalLine(Node node, int line_no, int hd)
	{
		// Base case
		if (node == null)
			return;

		// If this node is on the given line number
		if (hd == line_no)
			System.out.print(node.data + " ");

		// Recur for left and right subtrees
		printVerticalLine(node.left, line_no, hd - 1);
		printVerticalLine(node.right, line_no, hd + 1);
	}

	// The main function that prints a given binary tree in
	// vertical order
	void verticalOrder(Node node)
	{
		// Find min and max distances with resepect to root
		findMinMax(node, val, val, 0);

		// Iterate through all possible vertical lines starting
		// from the leftmost line and print nodes line by line
		for (int line_no = val.min; line_no <= val.max; line_no++)
		{
			printVerticalLine(node, line_no, 0);
			System.out.println("");
		}
	}

	// Driver program to test the above functions
	public static void main(String args[])
	{
		BinaryTreeVerticalPrint tree = new BinaryTreeVerticalPrint();

        /* Let us construct the tree shown in above diagram */
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(6);
		tree.root.right.right = new Node(7);
		tree.root.right.left.right = new Node(8);
		tree.root.right.right.right = new Node(9);

		System.out.println("vertical order traversal is :");
		tree.verticalOrder(tree.root);
	}
}
