package dsa.tree;

public class BinaryTreeAlgos {

	private Node root;

	int visible = 0;

	private int minimumDepthOfTree(Node root) {

		if(root == null)
		 return 0;
		if(root.left == null && root.right == null)
			return 1;

		if(root.left == null)
			return minimumDepthOfTree(root.right) + 1;

		if(root.right == null)
			return minimumDepthOfTree(root.left) + 1;

		;
		return Math.min(minimumDepthOfTree(root.left), minimumDepthOfTree(root.right)) + 1;
	}


	private int countAllElementLargerThanRoot(Node root, int maxNodeValue) {

		if(root.data >= maxNodeValue) visible++;
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;

		if(root.left == null)
			return countAllElementLargerThanRoot(root.right, maxNodeValue) ;

		if(root.right == null)
			return countAllElementLargerThanRoot(root.left, maxNodeValue);

		countAllElementLargerThanRoot(root.left, maxNodeValue);
		countAllElementLargerThanRoot(root.right, maxNodeValue);
		return 0;
	}

	public class Res {
		int dat;
	}

	private int findMaxPath(Node root) {
		Res res = new Res();
		res.dat = Integer.MIN_VALUE;
		findMaxPathUtil(root, res);
		return res.dat;
	}

	private int findMaxPathUtil(Node node, Res res) {

		/* Algo
		* 1. Node only
			2. Max path through Left Child + Node
			3. Max path through Right Child + Node
			4. Max path through Left Child + Node + Max path through Right Child*/

		Node root;

		// This function returns overall maximum path sum in 'res'
		// And returns max path sum going through root.
		// Base Case
		if (node == null)
			return 0;

		// l and r store maximum path sum going through left and
		// right child of root respectively
		int l = findMaxPathUtil(node.left, res);
		int r = findMaxPathUtil(node.right, res);

		// Max path for parent call of root. This path must
		// include at-most one child of root
		int max_single = Math.max(Math.max(l, r) + node.data,
			node.data);


		// Max Top represents the sum when the Node under
		// consideration is the root of the maxsum path and no
		// ancestors of root are there in max sum path
		int max_top = Math.max(max_single, l + r + node.data);

		// Store the Maximum Result.
		res.dat= Math.max(res.dat, max_top);

		return max_single;
	}


	public static void main(String args[]) {

		//Problem 1. To find minimum depth of a bTree
		// Tree creation
		BinaryTreeAlgos bTree = new BinaryTreeAlgos();
		bTree.root = new Node(1);
		bTree.root.left = new Node(2);
		bTree.root.right = new Node(3);
		bTree.root.left.left = new Node(4);
		bTree.root.left.right = new Node(5);
		System.out.println("1. Minimum Depth of the tree :: " + bTree.minimumDepthOfTree(bTree.root));
    
		//Problem 2. To find the elements larger than ROOT in a binary tree
		bTree.countAllElementLargerThanRoot(bTree.root, bTree.root.data);
		System.out.println("2. Number of elements larger than Root :: "+ bTree.visible);

		//Problem 3. To find the maximum path in a tree
		BinaryTreeAlgos tree = new BinaryTreeAlgos();
		tree.root = new Node(10);
		tree.root.left = new Node(2);
		tree.root.right = new Node(15);
		tree.root.left.left = new Node(20);
		tree.root.left.right = new Node(1);
		tree.root.right.right = new Node(-25);
		tree.root.right.right.left = new Node(3);
		tree.root.right.right.right = new Node(4);
		System.out.println("3. Maximum path sum in a tree "+ tree.findMaxPath(tree.root));
	}
}

