package dsa.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by nayan.kakati on 7/1/18.
 */
public class TreeView {
	TreeNode root;

	public static void main(String[] args) {
		TreeView treeView = new TreeView();
		treeView.root = new TreeNode(1);
		TreeNode tree = getTree(treeView.root);
		printTopViewOfATree(treeView.root);
		System.out.println();
		printTopViewOfATreeUsingMap(treeView.root);
		System.out.println();
		printLeftViewOfATree(treeView.root);
		System.out.println();
		printRightViewOfABinaryTree(treeView.root);
		System.out.println();
		printBottomViewOfABinaryTree(treeView.root);
	}

	private static void printBottomViewOfABinaryTree(TreeNode root) {
		Map<Integer, QNode> map = new HashMap<>();
		Queue<QNode> queue = new LinkedList<>();
		queue.add(new QNode(root, 0));

		while (!queue.isEmpty()) {
			QNode node = queue.remove();
			int hd = node.d;
			map.put(hd, node);
			if(node.treeNode.left != null)
				queue.add(new QNode(node.treeNode.left, hd-1));
			if(node.treeNode.right != null)
				queue.add(new QNode(node.treeNode.right, hd+1));
		}
		map.values().forEach(n -> System.out.print(n.treeNode.data));
	}
	private static void printRightViewOfABinaryTree(TreeNode root) {
		Map<Integer, QNode> map = new HashMap<>();
		Queue<QNode> queue = new LinkedList<>();
		queue.add(new QNode(root, 0));
		while (!queue.isEmpty()) {
			QNode node = queue.remove();
			int level = node.d;
			map.put(level, node);
			if(node.treeNode.left != null)
				queue.add(new QNode(node.treeNode.left, level+1));
			if(node.treeNode.right != null)
				queue.add(new QNode(node.treeNode.right, level+1));
		}
		map.values().forEach(n -> System.out.print(n.treeNode.data));
	}

	private static void printLeftViewOfATree(TreeNode root) {
		Map<Integer, QNode> map = new HashMap<>();
		Queue<QNode> queue = new LinkedList<>();
		queue.add(new QNode(root, 0));
		while (!queue.isEmpty()) {
			QNode node = queue.remove();
			int level = node.d;
			if(map.get(level) == null) {
				System.out.print(node.treeNode.data);
				map.put(level, node);
			}
			if(node.treeNode.left != null)
				queue.add(new QNode(node.treeNode.left, level+1));
			if(node.treeNode.right != null)
				queue.add(new QNode(node.treeNode.right, level+1));

		}
	}

	private static void printTopViewOfATreeUsingMap(TreeNode root) {
		Map<Integer, QNode> map = new TreeMap<>();
		Queue<QNode> queue = new LinkedList<>();
		queue.add(new QNode(root, 0));

		while (!queue.isEmpty()) {
			QNode node = queue.remove();
			int hd = node.d;
				map.putIfAbsent(hd, node);
			if(node.treeNode.left != null)
				queue.add(new QNode(node.treeNode.left, hd-1));
			if(node.treeNode.right != null)
				queue.add(new QNode(node.treeNode.right, hd+1));
		}
		map.values().forEach(n -> System.out.print(n.treeNode.data));
	}

	private static void printTopViewOfATree(TreeNode root) {
		Set<Integer> set = new HashSet<>();
		Queue<QNode> queue = new LinkedList<>();

		queue.add(new QNode(root, 0));

		while (!queue.isEmpty()) {
			QNode node = queue.remove();
			int hd = node.d;
			if(!set.contains(hd)) {
				System.out.print(node.treeNode.data);
				set.add(hd);
			}
			if(node.treeNode.left != null)
				queue.add(new QNode(node.treeNode.left, hd-1));
			if(node.treeNode.right != null)
				queue.add(new QNode(node.treeNode.right, hd+1));
		}
	}

	private static TreeNode getTree(TreeNode root) {
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		root.left = n2;
		root.right = n3;

		n2.left = new TreeNode(4);
		n2.right = new TreeNode(5);

		n3.left = new TreeNode(6);
		n3.right = new TreeNode(7);
		return root;
	}
}
