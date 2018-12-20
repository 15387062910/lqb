package algorithm_Tree;

// Given a binary tree, find its maximum depth.

// The maximum depth is the number of nodes along the longest path 
// from the root node down to the farthest leaf node.
public class GetMaximumDepthTree {
	public static class TreeNode {
		int value;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			value = x;
		}
	}
	
	public int maxDepth(TreeNode root){
		if(root == null){
			return 0;
		}
		return Math.max(this.maxDepth(root.left), this.maxDepth(root.right)) + 1;
	}
	
	// ============================= 
	// 		test
	public static void printTree(TreeNode head) {
		System.out.println("Binary Tree:");
		printInOrder(head, 0, "H", 17);
		System.out.println();
	}
	
	public static void printInOrder(TreeNode head, int height, String to, int len) {
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
		GetMaximumDepthTree test = new GetMaximumDepthTree();
		TreeNode head = new TreeNode(1);
		head.left = new TreeNode(2);
		head.right = new TreeNode(3);
		head.left.left = new TreeNode(4);
		head.left.right = new TreeNode(5);
		System.out.println("The tree: ");
		printTree(head);
		System.out.println("The maximum depth of tree is: " + test.maxDepth(head));
		
	}
	
}
