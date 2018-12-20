package algorithm_Tree;

import java.util.Stack;

// 判断一棵二叉树是否是搜索二叉树 
// 思路: 借助中序遍历的非递归实现来做(最简单方法)
public class IsBST {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	// 借助非递归中序遍历实现 判断一棵二叉树是否是搜索二叉树
	public static boolean isBST(Node head) {
		int pre = Integer.MIN_VALUE;
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			while (!stack.isEmpty() || head != null) {
				if (head != null) {
					stack.push(head);
					head = head.left;
				} else {
					head = stack.pop();
					// 将当前节点和之前的数比较 如果大于说明满足搜索二叉树条件 否则不满足
					if (head.value > pre) {
						pre = head.value;
					} else {
						return false;
					}
					head = head.right;
				}
			}
		}

		return true;
	}

	// 借助递归中序遍历实现 判断一棵二叉树是否是搜索二叉树
	private static int pre = Integer.MIN_VALUE;
	private static boolean flag;
	public static void isBST2(Node head) {
		if (head == null) {
			return;
		}
		isBST2(head.left);
		// 将当前节点和之前的数比较 如果大于说明满足搜索二叉树条件 否则不满足
		if (head.value > pre) {
			pre = head.value;
		} else {
			flag = false;
			return;
		}

		isBST2(head.right);

	}

	public static void main(String[] args) {
		Node head = new Node(5);
		head.left = new Node(3);
		head.left.left = new Node(1);
		head.left.right = new Node(4);
		head.right = new Node(7);
		head.right.left = new Node(6);
		head.right.right = new Node(9);
		System.out.println(isBST(head));
		flag = true;
		isBST2(head);
		System.out.println(flag);

		Node head2 = new Node(5);
		head2.left = new Node(3);
		head2.left.left = new Node(1);
		head2.left.right = new Node(4);
		head2.right = new Node(7);
		head2.right.left = new Node(8);
		head2.right.right = new Node(9);
		System.out.println(isBST(head2));
		flag = true;
		isBST2(head2);
		System.out.println(flag);

	}

}
