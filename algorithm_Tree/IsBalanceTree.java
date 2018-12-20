package algorithm_Tree;

// 判断一个二叉树是否是平衡二叉树
public class IsBalanceTree {
	public static class Node {
		public int value;
		public Node left;
		public Node right;

		public Node(int data) {
			this.value = data;
		}
	}
	
	// 返回数据
	public static class ReturnData{
		public boolean isB;
		public int h;
		
		public ReturnData(boolean isB, int h){
			this.isB = isB;
			this.h = h;
		}
	}
	
	// 判断一颗二叉树是否是平衡二叉树
	public static boolean isB(Node head){
		return process(head).isB;
	}
	
	// 递归求解返回数据过程 => 列举多种可能性
	// 不是平衡二叉树的情况: 1、左子树不是平衡二叉树  2、右子树不是平衡二叉树  3、左子树和右子树的高度差大于1
	// 其他情况均是平衡二叉树: 空二叉树、不是以上三种情况的非空二叉树
	public static ReturnData process(Node head){
		if(head==null){
			return new ReturnData(true, 0);
		}
		ReturnData leftData = process(head.left);
		if(!leftData.isB){
			return new ReturnData(false, 0);
		}
		ReturnData rightData = process(head.right);
		if(!rightData.isB){
			return new ReturnData(false, 0);
		}
		if(Math.abs(leftData.h - rightData.h) > 1){
			return new ReturnData(false, 0);
		}
		// Math.max(leftData.h, rightData.h) + 1 -> 子树父节点的高度
		return new ReturnData(true, Math.max(leftData.h, rightData.h) + 1);
	}
	
	// 判断一颗二叉树是否是平衡二叉树
	public static boolean isBalance(Node head) {
		boolean[] res = new boolean[1];
		res[0] = true;
		getHeight(head, 1, res);
		return res[0];
	}
	
	//  取得树的高度
	public static int getHeight(Node head, int level, boolean[] res) {
		// head: 头节点 	level: 层数	 res: 结果数组
		if (head == null) {
			return level;
		}
		// 左边高度
		int lH = getHeight(head.left, level + 1, res);
		if (!res[0]) {
			return level;
		}
		// 右边高度
		int rH = getHeight(head.right, level + 1, res);
		if (!res[0]) {
			return level;
		}
		// 左边右边高度相差大于1
		if (Math.abs(lH - rH) > 1) {
			res[0] = false;
		}
		// 返回左右子树的高度最大值
		return Math.max(lH, rH);
	}
	
	// for test
	public static void main(String[] args) {
		Node head = new Node(1);
		head.left = new Node(2);
		head.right = new Node(3);
		head.left.left = new Node(4);
		head.left.right = new Node(5);
		head.right.left = new Node(6);
		head.right.right = new Node(7);
		System.out.println(isBalance(head));
		System.out.println(isB(head));
		
		Node t = new Node(1);
		t.left = new Node(2);
		t.left.left = new Node(3);
		System.out.println(isBalance(t));
		System.out.println(isB(t));
	}
	
}
