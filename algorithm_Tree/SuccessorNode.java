package algorithm_Tree;

/*
 在二叉树中找到一个节点的后继节点
【题目】 现在有一种新的二叉树节点类型如下：
public class Node { 
	public int value; 
	public Node left;
	public Node right; 
	public Node parent;
	
	public Node(int data) { this.value = data; }
}

该结构比普通二叉树节点结构多了一个指向父节点的parent指针。假设有一 棵Node类型的节点组成的二叉树，树中每个节点的parent指针
都正确地指向 自己的父节点，头节点的parent指向null。只给一个在二叉树中的某个节点 node，请实现返回node的后继节点的函数。
在二叉树的中序遍历的序列中， node的下一个节点叫作node的后继节点
*/
public class SuccessorNode {
	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node parent;

		public Node(int data) {
			this.value = data;
		}
	}
	
	// 找到节点的后继节点
	public static Node getSuccessorNode(Node node) {
		if (node == null) {
			return node;
		}
		if (node.right != null) {
			// 节点有右子树
			// 找到右子树上最左的节点
			return getLeftMost(node.right);
		} else {
			// 节点没有右子树
			Node parent = node.parent;
			while (parent != null && parent.left !=  node) {
				node = parent;
				parent = node.parent;
			}
			return parent;
		}
	}

	// 找到右子树上最左的节点
	public static Node getLeftMost(Node node) {
		if (node == null) {
			return node;
		}
		while (node.left != null) {
			node = node.left;
		}

		return node;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.parent = head;
		head.right.parent = head;
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.left.left.parent = head.left;
		head.left.right.parent = head.left;
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		head.right.left.parent = head.right;
		head.right.right.parent = head.right;
		
		// 最后一个节点的情况
		System.out.println(getSuccessorNode(head.right.right));				// 7的后继节点是空
		
		// 有右子树的情况:
		System.out.println(getSuccessorNode(head).value);					// 1的后继节点是6
		
		// 没有右子树的情况:
		System.out.println(getSuccessorNode(head.right.left).value);		// 6的后继节点是3
		
		
	}
}
