//Given the root node of a binary search tree (BST) and a value. You need to find the node in the BST that the node's value equals the given value. Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
//
//For example, 
//
//Given the tree:
//        4
//       / \
//      2   7
//     / \
//    1   3
//
//And the value to search: 2

class Node {
	int data;
	Node left;
	Node right;

	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}

}
public class SearchInBST {
	
	static Node varNode;

	public Node createNode(int data) {
		Node dataNode = new Node();
		dataNode.data = data;
		dataNode.left = null;
		dataNode.right = null;
		return dataNode;
	}

	public Node createBst(int data, Node node) {

		if (node == null) {
			return this.createNode(data);
		} else if (node.data > data) {
			node.left = createBst(data, node.left);
		} else if (node.data < data) {
			node.right = createBst(data, node.right);
		}

		return node;
	}

	public void search(Node node, int key) {

		if (node == null)
			return;
		
		// printNode(node.left);
		search(node.left, key);
//		if (node.left == null && node.right == null) {
//			System.out.println(node.data);
//		}
		if (node.data == key) {
			varNode = node;

		}
		search(node.right, key);

	}

	public void printNode(Node node) {
		if (node == null)
			return;

		printNode(node.left);
		System.out.println(node.data);
		printNode(node.right);
	}

	public static void main(String[] args) {

		Node node = null;
		SearchInBST bst = new SearchInBST();
		node = bst.createBst(5, node);
		node = bst.createBst(10, node);
		node = bst.createBst(4, node);
		node = bst.createBst(11, node);
		node = bst.createBst(8, node);
		node = bst.createBst(3, node);
		int key = 2;
		bst.search(node, key);
		if(varNode==null) {
			System.out.println("[]");
		}
		bst.printNode(varNode);

	}

}
