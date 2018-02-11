import java.util.ArrayDeque;
import java.util.Queue;

public class BSTTest {
	int test;

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.add(50);
		tree.add(20);
		tree.add(30);
		tree.add(40);
		tree.add(60);
		tree.add(70);
		tree.add(80);
		// tree.printAll();
		// System.out.println(tree.search(40));
		// System.out.println(tree.search(30));
		// Node node = tree.root;
		System.out.println(tree.maxHeight());
		tree.breadthFirst();

	}
}

/**
 * Binary Search Tree
 * 
 * @author denisimon
 * 
 */
class Tree {
	Node root;

	// Node of a tree
	private class Node {
		int data;
		Node left;
		Node right;

		public Node(int data, Node left, Node right) {
			super();
			this.data = data;
			this.left = left;
			this.right = right;
		}

	}

	/**
	 * Adding data into the tree Without using recursion
	 * 
	 * @param data
	 */
	public void add(int data) {

		Node search = root;
		Node node = new Node(data, null, null);
		if (search == null) {
			root = node;
			return;
		}
		while (search != null) {
			// System.out.println("Deni"+search.data);
			if (search.data > node.data) {
				if (search.left == null) {
					search.left = node;
					// System.out.println("Added " + node.data + " as the left of " + search.data);
					break;
				}
				search = search.left;
			} else if (search.data < node.data) {
				if (search.right == null) {
					search.right = node;
					// System.out.println("Added " + node.data + " as the right of " + search.data);
					break;
				}
				search = search.right;
			}
		}
	}

	/**
	 * This method was initially designed to search data without recursion That part
	 * is commented out now. It will just call the function using recursion
	 * 
	 * @param data
	 * @return
	 */
	public boolean search(int data) {
		// Node search=root;
		// //System.out.println("Deni2"+" "+root.data);
		// if(search==null)
		// return false;
		// while(search!=null) {
		// if(search.data==data) {
		// return true;
		// }
		// else if(data<search.data) {
		// search=search.left;
		// System.out.println("going to left"+data+" "+root.data);
		// }
		// else if(data>search.data) {
		// search=search.right;
		// System.out.println("going to right"+data+" "+root.data);
		// }
		//
		// }
		return search(root, data);
	}

	/**
	 * This function uses recursion to search in a tree
	 * 
	 * @param root
	 * @param data
	 * @return
	 */
	public boolean search(Node root, int data) {

		if (root == null)
			return false;
		if (root.data == data)
			return true;
		if (data < root.data)
			return search(root.left, data);
		else if (data > root.data)
			return search(root.right, data);
		return false;
	}

	/**
	 * Print all elements in the tree
	 */
	public void printAll() {
		Node node = root;
		while (node != null) {
			System.out.println(node.data);
			node = node.left;
		}
	}

	/**
	 * To print the maximum height of a tree This method calls a private method
	 * which uses recursion to find the maximum tree height
	 * 
	 * @return
	 */
	public int maxHeight() {

		return maxheight(root);
	}

	private int maxheight(Node root) {
		if (root == null)
			return -1;
		return 1 + Math.max(maxheight(root.left), maxheight(root.right));

	}
	
	/**
	 * Minimum element in a BST will be its left most node
	 * @return
	 */
	public int minElement() {
		Node min=root;
		int out=-1;
		while(min!=null) {
			out=min.data;
			min=min.left;
		}
		return out;
	}
	
	/**
	 * Maximum element in a BST will be its right most node
	 * @return
	 */
	public int maxElement() {
		Node max=root;
		int out=-1;
		while(max!=null) {
			out=max.data;
			max=max.right;
		}
		return out;
	}
	
	/**
	 * Prints tree in level order
	 */
	public void breadthFirst() {
		Queue<Node> queue = new ArrayDeque<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			if(queue.peek().left!=null)
				queue.add(queue.peek().left);
			if(queue.peek().right!=null)
				queue.add(queue.peek().right);
			System.out.println(queue.poll().data);
		}
	}
}
