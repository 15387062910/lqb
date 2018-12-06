package template;

import java.util.*;

// 链表相关模板
public class LinkListTemplate {
	public static class Node {
		// 单向链表的节点
		public int value;
		public Node next;
		public Node(int data) {
			this.value = data;
		}
	}

	public static class DoubleNode {
		// 双向链表的节点
		public int value;
		public DoubleNode last;		// 前一个节点
		public DoubleNode next;		// 后一个节点
		
		public DoubleNode(int data) {
			this.value = data;
		}
	}
	
	public static void printLinkedList(Node node) {
		// 打印单向链表
		System.out.print("Linked List: ");
		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}	
		
	public static void printDoubleLinkedList(DoubleNode head) {
		// 打印双向链表
		System.out.print("Double Linked List: ");
		DoubleNode end = null;
		while (head != null) {
			System.out.print(head.value + " ");
			end = head;
			head = head.next;
		}
		System.out.print("| ");
		while (end != null) {
			System.out.print(end.value + " ");
			end = end.last;
		}
		System.out.println();
	}
	
	public static Node reverseList(Node head) {
		// 反转单向链表
		Node pre = null;
		Node next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			pre = head;
			head = next;
		}
		return pre;
	}
			
	public static DoubleNode reverseList(DoubleNode head) {
		// 反转双向链表
		DoubleNode pre = null;
		DoubleNode next = null;
		while (head != null) {
			next = head.next;
			head.next = pre;
			head.last = next;
			pre = head;
			head = next;
		}
		return pre;
	}
	
	public static void printCommonPart(Node head1, Node head2) {
		// 打印两个有序链表的公共部分
		System.out.print("Common Part: ");
		while (head1 != null && head2 != null) {
			if (head1.value < head2.value) {
				head1 = head1.next;
			} else if (head1.value > head2.value) {
				head2 = head2.next;
			} else {
				System.out.print(head1.value + " ");
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		System.out.println();
	}
	
	public static int getLinkListLength(Node head){
		// get the length of linklist
		int length = 0;
		while(head!=null){
			length++;
			head = head.next;
		}
		
		return length;
	}
	
	public static int[] LinkListToArray(Node head){
		// convert the linklist to array
		if(head == null){
			return null;
		}
		int length = getLinkListLength(head);
		int[] arr = new int[length];
		int cur = 0;
		while(head!=null){
			arr[cur++] = head.value;
			head = head.next;
		}
		
		return arr;
	}
	
	public static Node ArrayToLinkList(int[] arr) {
		// convert the array to linklist
		if (arr == null) {
			return null;
		}
		Node head = new Node(arr[0]);
		Node n = head;
		for (int i = 1; i < arr.length; i++) {
			n.next = new Node(arr[i]);
			n = n.next;
		}
		return head;
	}
	
	// 按顺序合并两个链表(每个都可能为null)  eg: 1->2->3 4->5->6 这两个链表经过下面两个函数合并之后是1->2->3->4->5->6
	public static Node mergeLinkList(Node head1, Node head2) {
		if (head1 == null && head2 == null) {
			return null;
		} else if (head1 == null) {
			return head2;
		} else if (head2 == null) {
			return head1;
		} else {
			Node head = head1;
			Node tail = head;
			Node tail_a = head1.next;
			while(tail_a != null){
				tail.next = tail_a;
				tail = tail_a;
				tail_a = tail_a.next;
			}
			Node tail_b = head2;
			while(tail_b != null){
				tail.next = tail_b;
				tail = tail_b;
				tail_b = tail_b.next;
			}
			
			return head;
		}
	}
	
	public static Node CopyLinkList(Node head){
		// 复制链表 -> 使用hash表实现
		if(head==null){
			return null;
		}
		HashMap<Node, Node> map = new HashMap<Node, Node>();
		Node cur = head;
		while(cur!=null){
			map.put(cur, new Node(cur.value));
			cur = cur.next;
		}
		cur = head;
		while(cur!=null){
			map.get(cur).next = map.get(cur.next);
			cur = cur.next;
		}
		
		return map.get(head);
	}
	
	public static Node CopyLinkList2(Node head){
		// 复制链表 -> 不用hash表实现
		if(head==null){
			return null;
		}
		Node cur = head;
		Node next = null;
		// 1 -> 2 -> 3 => 1 -> 1` -> 2 -> 2` -> 3 -> 3`
		while(cur!=null){
			next = cur.next;
			cur.next = new Node(cur.value);
			cur.next.next = next;
			cur = next;
		}
		// split
		Node res = head.next;
		Node curCopy = null;
		cur = head;
		while(cur!=null){
			next = cur.next.next;
			curCopy = cur.next;
			cur.next = next;
			curCopy.next = next != null ? next.next : null;
			cur = next;
		}
		
		return res;
	}
	
	public static Node getLoopNode(Node head){
		// 判断单链表成环          eg: 1 -> 2 -> 3 -> 5 -> 7 -> 3	 注意: 最后一个3是中间那个3 
		/*
		 * 判断单链表是否有环 无环返回null 有环返回第一个环节点
		 * 思路1:	 	使用hashmap
		 * */
		if (head == null || head.next == null || head.next.next == null) {
			return null;
		}
		Node cur = head;
		HashSet<Node> set = new HashSet<Node>();
		while(cur != null){
			if(set.contains(cur)){
				return cur;
			}
			set.add(cur);
			cur = cur.next;
		}
		
		return null;
	}
	
	public static Node getLoopNode2(Node head){
		// 判断单链表成环2    eg: 1 -> 2 -> 3 -> 5 -> 7 -> 3	 注意: 最后一个3是中间那个3 
		/*
		 * 判断单链表是否有环 无环返回null 有环返回第一个环节点
		 * 思路2: 	用快慢指针实现 -> 快指针一次走两步 慢指针一次走一步 如果有环 两者必在某点相遇
		 * 		          相遇后快指针移到开始head位置 然后快指针和慢指针都一次走一步 两者必在入环处相遇
		 * */
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
	
	public static void main(String[] args) {
		
	}

	
}
