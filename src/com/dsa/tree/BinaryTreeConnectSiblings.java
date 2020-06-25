package dsa.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by nayan.kakati on 2/27/18.
 */
public class BinaryTreeConnectSiblings {

	static void connect(Node root) {
		Queue<Node> Q =  new LinkedList<>();
		Q.add(root);
		Q.add(null);

		while (!Q.isEmpty()) {
			Node p = Q.peek();
			Q.remove();
			if(p != null) {
				p.nextRight = Q.peek();

				if(p.left != null)
					Q.add(p.left);
				if(p.right != null)
					Q.add(p.right);
			} else if(!Q.isEmpty())
				Q.add(null);
		}
	}
	public static void main(String...args) {
		Node root = new Node(10);
		root.left = new Node(8);
		root.right = new Node(2);
		root.left.left = new Node(3);
		root.right.right = new Node(90);

		// Populates nextRight pointer in all nodes
		connect(root);

		// Let us check the values of nextRight pointers
		System.out.println("Following are populated nextRight pointers in \n" +
			"the tree (-1 is printed if there is no nextRight)");
		System.out.println("nextRight of "+ root.data +" is "+
			((root.nextRight != null) ? root.nextRight.data : -1));
		System.out.println("nextRight of "+ root.left.data+" is "+
			((root.left.nextRight != null) ? root.left.nextRight.data : -1));
		System.out.println("nextRight of "+ root.right.data+" is "+
			((root.right.nextRight != null) ? root.right.nextRight.data : -1));
		System.out.println("nextRight of "+  root.left.left.data+" is "+
			((root.left.left.nextRight != null) ? root.left.left.nextRight.data : -1));
		System.out.println("nextRight of "+  root.right.right.data+" is "+
			((root.right.right.nextRight != null) ? root.right.right.nextRight.data : -1));
	}
}
