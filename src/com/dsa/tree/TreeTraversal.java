package dsa.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by nayan.kakati on 6/28/18.
 */
public class TreeTraversal {
	TreeNode root;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeTraversal treeTraversal =  new TreeTraversal();
		treeTraversal.root = root;
		TreeNode tree = getTree(root);
		printTreeInLevelOrder(root);
		System.out.println();
		printPreOrderTree(root);
	}

	private static void printPreOrderTree(TreeNode root) {
		//using stack do it in 10 minutes tmrw in office
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode pop = stack.pop();
			System.out.print(pop.data);

			if(pop.right != null) stack.push(pop.right);
			if(pop.left != null) stack.push(pop.left);
		}
	}

	private static void printTreeInLevelOrder(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList();
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode node = queue.poll();
			System.out.print(node.data);
			if(node.left !=null) queue.add(node.left);
			if(node.right !=null) queue.add(node.right);
		}
	}

	private static TreeNode getTree(TreeNode root) {
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		root.left = n2;
		root.right = n3;

		TreeNode n6 = new TreeNode(6);
		n3.left = n6;

		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		n2.left = n4;
		n2.right = n5;

		TreeNode n7 = new TreeNode(7);
		n4.right = n7;
		return root;
	}
}
