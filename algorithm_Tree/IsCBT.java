package algorithm_Tree;

import java.util.Queue;
import java.util.LinkedList;

// 判断一棵二叉树是否是完全二叉树 
public class IsCBT {

	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	// 判断二叉树是否是完全二叉树
	public static boolean isCBT(Node head) {
		/*
			按层遍历 两种情况: 
				1、有右节点无左节点 直接返回false
				2、有左节点无右节点或者左右节点都没有 那么如果接下来的节点都是叶节点就直接返回true 否则返回false
		*/
		if (head == null) {
			return true;
		}
		Queue<Node> queue = new LinkedList<Node>();
		boolean leaf = false;		// 标志情况2是否发生
		Node l = null;
		Node r = null;
		queue.offer(head);
		while (!queue.isEmpty()) {
			head = queue.poll();
			l = head.left;
			r = head.right;
			if (l == null && r != null) {
				// 情况1 左空右不空
				return false;
			}
			if (leaf && (l != null || r != null)) {
				// 情况2
				return false;
			}
			if (l != null) {
				queue.offer(l);
			}
			if (r != null) {
				queue.offer(r);
			} else {
				// 开启情况2
				// 实质上就是左右均为空或左不空右空的情况
				leaf = true;
			}
		}
		return true;
	}

	public static void main(String[] args) {

	}
}
