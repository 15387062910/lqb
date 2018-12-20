package algorithm_Tree;

import java.util.*;

public class SerializeAndReconstructTree {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	// 以先序遍历的方式序列化二叉树(递归)
	public static String serialByPre(Node head) {
		if (head == null) {
			return "#_";
		}
		String res = head.value + "_";
		res += serialByPre(head.left);
		res += serialByPre(head.right);
		return res;
	}
	
	// 以按层遍历的方式序列化(非递归)
	public static String serialByLevel(Node head) {
		if (head == null) {
			return "#_";
		}
		String res = head.value + "_";
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			// 处理左边
			if (head.left != null) {
				res += head.left.value + "_";
				queue.offer(head.left);
			} else {
				res += "#_";
			}
			// 处理右边
			if (head.right != null) {
				res += head.right.value + "_";
				queue.offer(head.right);
			} else {
				res += "#_";
			}
		}
		return res;
	}
	
	// 实现先序遍历反序列化二叉树
	public static Node reconPreOrder(Queue<String> queue) {
		String value = queue.poll();
		if (value.equals("#")) {
			return null;
		}
		Node head = new Node(Integer.valueOf(value));
		head.left = reconPreOrder(queue);
		head.right = reconPreOrder(queue);
		return head;
	}
	
	// 将字符串分割转换成数组然后存入队列中然后调用反序列化函数
	public static Node reconByString(String str) {
		String[] values = str.split("_");
		// 保存分割出来的节点值
		Queue<String> queue = new LinkedList<String>();
		for (int i = 0; i != values.length; i++) {
			queue.offer(values[i]);
		}

		return reconPreOrder(queue);
	}
	
	// 根据节点值生成节点
	public static Node generateNodeByString(String val) {
		if (val.equals("#")) {
			return null;
		}
		return new Node(Integer.valueOf(val));
	}
	
	// 实现按层遍历反序列化二叉树
	public static Node reconByLevelString(String levelStr) {
		String[] values = levelStr.split("_");
		int index = 0;
		Node head = generateNodeByString(values[index++]);
		Queue<Node> queue = new LinkedList<Node>();
		if (head != null) {
			queue.offer(head);
		}
		Node node = null;
		while (!queue.isEmpty()) {
			node = queue.poll();
			node.left = generateNodeByString(values[index++]);
			node.right = generateNodeByString(values[index++]);
			if (node.left != null) {
				queue.offer(node.left);
			}
			if (node.right != null) {
				queue.offer(node.right);
			}
		}
		return head;
	}
	
	// for test -- print tree
	public static void printTree(Node head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}

	public static void printInOrder(Node head, int height, String to, int len) {
		if (head == null) {
			return;
		}
		printInOrder(head.right, height + 1, "v", len);
		String val = to + head.value + to;
		int lenM = val.length();
		int lenL = (len - lenM) / 2;
		int lenR = len - lenM - lenL;
		val = getSpace(lenL) + val + getSpace(lenR);
		System.out.println(getSpace(height * len) + val);
		printInOrder(head.left, height + 1, "^", len);
	}

	public static String getSpace(int num) {
		String space = " ";
		StringBuffer buf = new StringBuffer("");
		for (int i = 0; i < num; i++) {
			buf.append(space);
		}
		return buf.toString();
	}
	
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.right.right = new Node(5);
		printTree(head);
		
		// 前序遍历方式序列化和反序列化
		System.out.println("==============================================================");
		String pre = serialByPre(head);
		System.out.println("serialize tree by pre-order: " + pre);
		head = reconByString(pre);
		System.out.print("reconstruct tree by pre-order, ");
		printTree(head);

		// 按层遍历方式序列化和反序列化
		System.out.println("==============================================================");
		String level = serialByLevel(head);
		System.out.println("serialize tree by level-order: " + level);
		head = reconByLevelString(level);
		System.out.print("reconstruct tree by level-order, ");
		printTree(head);
		
	}
	
}
