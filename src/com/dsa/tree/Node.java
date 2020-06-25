package dsa.tree;

/**
 * Created by nayan.kakati on 2/19/18.
 */
public class Node {

	int data;
	Node left, right, nextRight;
	Node(int item) {
		data = item;
		left = right = nextRight = null;
	}
}
