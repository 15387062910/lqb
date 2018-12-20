package algorithm_Tree;

// 已知一棵完全二叉树，求其节点的个数
// 要求：时间复杂度低于O(N)，N为这棵树的节点个数
public class CompleteTreeNodeNumber {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}

	// 主逻辑函数
	public static int nodeNum(Node head) {
		if (head == null) {
			return 0;
		}
		return bs(head, 1, mostLeftLevel(head, 1));
	}
	
	// 递归过程
	public static int bs(Node node, int level, int h) {
		// node: 当前节点		level: 当前节点位于第几层		h:  树的层数
		if (level == h) {
			return 1;
		}
		if (mostLeftLevel(node.right, level + 1) == h) {
			// 当前节点的右子树可以到最后一层
			// 此时左子树满
			return (1 << (h - level)) + bs(node.right, level + 1, h);
		} else {
			// 当前节点的右子树不可以到最后一层
			// 此时右子树满
			return (1 << (h - level - 1)) + bs(node.left, level + 1, h);
		}
	}

	// 返回当前节点的最左子节点位于的层数
	public static int mostLeftLevel(Node node, int level) {
		while (node != null) {
			level++;
			node = node.left;
		}
		return level - 1;
	}

	public static void main(String[] args) {
		
	}

}
