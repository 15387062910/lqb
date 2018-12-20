package algorithm_Tree;

import java.util.*;

// 6种遍历二叉树： 递归非递归  * 前序中序后序
public class TreeTraversal {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	// 递归先序遍历
	public static void preOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		System.out.print(head.value + " ");
		preOrderRecur(head.left);
		preOrderRecur(head.right);
	}

	// 递归中序遍历
	public static void inOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		inOrderRecur(head.left);
		System.out.print(head.value + " ");
		inOrderRecur(head.right);
	}

	// 递归后序遍历
	public static void posOrderRecur(Node head) {
		if (head == null) {
			return;
		}
		posOrderRecur(head.left);
		posOrderRecur(head.right);
		System.out.print(head.value + " ");
	}

	// 非递归先序遍历
	public static void preOrderUnRecur(Node head) {
		System.out.print("pre-order: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.add(head);
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.print(head.value + " ");
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}

		System.out.println();
	}

	// 非递归中序遍历
	public static void inOrderUnRecur(Node head) {
		System.out.print("in-order: ");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					System.out.print(head.value + " ");
					head = head.right;
				}
			}
		}

		System.out.println();
	}

	// 非递归后序遍历
	public static void posOrderUnRecur(Node head) {
		System.out.print("pos-order: ");
		if (head != null) {
			Stack<Node> s1 = new Stack<Node>();
			Stack<Node> s2 = new Stack<Node>();
			s1.push(head);
			while (!s1.isEmpty()) {
				head = s1.pop();
				s2.push(head);
				if (head.left != null) {
					s1.push(head.left);
				}
				if (head.right != null) {
					s1.push(head.right);
				}
			}

			while (!s2.isEmpty()) {
				System.out.print(s2.pop().value + " ");
			}

		}

		System.out.println();
	}

	// 非递归按层遍历 -> 队列实现
	public static void levelOrderUnRecur(Node head) {
		System.out.print("level-order: ");
		if (head != null) {
			Queue<Node> que = new LinkedList<Node>();
			que.offer(head);
			while (!que.isEmpty()) {
				head = que.poll();
				System.out.print(head.value + " ");
				if (head.left != null) {
					que.offer(head.left);
				}
				if (head.right != null) {
					que.offer(head.right);
				}
			}
		}

		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);

		// test 递归先序遍历
		System.out.print("pre-order: ");
		preOrderRecur(head);
		System.out.println();

		// test 递归中序遍历
		System.out.print("in-order: ");
		inOrderRecur(head);
		System.out.println();

		// test 递归后序遍历
		System.out.print("pos-order: ");
		posOrderRecur(head);
		System.out.println();

		// test 非递归先序遍历
		preOrderUnRecur(head);

		// test 非递归中序遍历
		inOrderUnRecur(head);

		// test 非递归后序遍历
		posOrderUnRecur(head);

		// test 非递归按层遍历
		levelOrderUnRecur(head);
	}

}
