package algorithm_linklist;

// 两个链表相交问题
/*
 	在本题中，单链表可能有环，也可能无环。给定两个 单链表的头节点 head1和head2，
	这两个链表可能相交，也可能 不相交。请实现一个函数， 如果两个链表相交，请返回相交的 第一个节点；如果不相交，返回null 即可。 
	要求：如果链表1长度为N，链表2长度为M 时间复杂度O(N+M)，额外空间复杂度O(1)
*/
public class FindFirstIntersectNode {
	
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}
	
	public static Node getLoopNode(Node head){
		// 判断单链表是否成环 成环返回环的第一个节点 否则返回null
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node n1 = head.next; 		// n1 -> slow
		Node n2 = head.next.next; 	// n2 -> fast
		while (n1 != n2) {
			if (n2.next == null || n2.next.next == null) {
				return null;
			}
			n2 = n2.next.next;
			n1 = n1.next;
		}
		n2 = head; // n2 -> walk again from head
		while (n1 != n2) {
			n1 = n1.next;
			n2 = n2.next;
		}
		return n1;
	}
	
	public static Node getIntersectNode(Node head1, Node head2){
		if(head1 == null && head2 == null){
			return null;
		}
		Node loop1 = getLoopNode(head1);
		Node loop2 = getLoopNode(head2);
		if(loop1 == null && loop2 == null){
			// 两个无环链表的相交问题
			return noloop(head1, head2);
		}
		if(loop1 != null && loop2 != null){
			// 两个有环链表的相交问题
			return bothLoop(head1, loop1, head2, loop2);
		}
		// 两个链表中一个有环 一个无环 不可能相交
		return null;
	}
	
	public static Node noloop(Node head1, Node head2){
		// 两个无环链表的相交问题
		// 1 不可能相交
		if(head1 == null || head2 == null){
			return null;
		}
		
		// 2 可能相交
		Node cur1 = head1;
		Node cur2 = head2;
		
		// n代表两个链表长度的差值关系
		int n = 0;
		while (cur1.next != null) {
			n++;
			cur1 = cur1.next;
		}
		while (cur2.next != null) {
			n--;
			cur2 = cur2.next;
		}
		// 两个无环链表最后一个节点不相等 一定不相交
		if (cur1 != cur2) {
			return null;
		}
		// 两个无环链表最后一个节点相等 一定相交
		// 定位谁是长链表 谁是短链表
		cur1 = n > 0 ? head1 : head2;
		cur2 = cur1 == head1 ? head2 : head1;
		// 移动长链表的cur
		n = Math.abs(n);
		while (n != 0) {
			n--;
			cur1 = cur1.next;
		}
		// cur1和cur2相等的位置就是第一次相交的位置
		while (cur1 != cur2) {
			cur1 = cur1.next;
			cur2 = cur2.next;
		}
		return cur1;
	}
	
	public static Node bothLoop(Node head1, Node loop1, Node head2, Node loop2){
		Node cur1 = null;
		Node cur2 = null;
		if (loop1 == loop2) {
			// 类似上述无环链表相交的情况
			cur1 = head1;
			cur2 = head2;
			int n = 0;
			while (cur1 != loop1) {
				n++;
				cur1 = cur1.next;
			}
			while (cur2 != loop2) {
				n--;
				cur2 = cur2.next;
			}
			// 定位谁是长链表 谁是短链表
			cur1 = n > 0 ? head1 : head2;
			cur2 = cur1 == head1 ? head2 : head1;
			// 移动长链表的cur
			n = Math.abs(n);
			while (n != 0) {
				n--;
				cur1 = cur1.next;
			}
			// cur1和cur2相等的位置就是第一次相交的位置
			while (cur1 != cur2) {
				cur1 = cur1.next;
				cur2 = cur2.next;
			}
			return cur1;
		} else {
			cur1 = loop1.next;
			while (cur1 != loop1) {
				if (cur1 == loop2) {
					// 相交
					return loop1;
				}
				cur1 = cur1.next;
			}
			// 根本不相交
			return null;
		}
	}
	
	public static void main(String[] args) {
		
	}
}
