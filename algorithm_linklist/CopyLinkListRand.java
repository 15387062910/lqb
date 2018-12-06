package algorithm_linklist;

import java.util.*;

// 
/* 一种特殊的链表节点类描述如下：
		public class Node{
     		public int value;		// 节点值
		    public Node next;		// 下一个节点
		    public Node rand;		
			
			public Node(int data){
				this.value = data
			}
		}
	rand指针是Node类中的新增的指针，这个指针可能指向链表中任意的一个节点，也可能指向null
	给定一个由 Node节点类型组成的无环单链表的头节点head，请实现一个 函数完成这个链表中 
	所有结构的复制，并返回复制的新链表的头节点
	进阶： 不使用额外数据结构，只用有限几个变量，时间复杂度为 O(N)
 
*/
public class CopyLinkListRand {
	public static class Node{
 		public int value;		// 节点值
	    public Node next;		// 下一个节点
	    public Node rand;		
		
		public Node(int data){
			this.value = data;
		}
	}
	
	public static void printRandLinkedList(Node head) {
		Node cur = head;
		System.out.print("order: ");
		while (cur != null) {
			System.out.print(cur.value + " ");
			cur = cur.next;
		}
		System.out.println();
		cur = head;
		System.out.print("rand:  ");
		while (cur != null) {
			System.out.print(cur.rand == null ? "- " : cur.rand.value + " ");
			cur = cur.next;
		}
		System.out.println();
	}
	
	public static Node copyLinkListRand1(Node head){
		if (head == null) {
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
			map.get(cur).rand = map.get(cur.rand);
			cur = cur.next;
		}
		return map.get(head);
	}
	
	public static Node copyLinkListRand2(Node head){
		if (head == null) {
			return null;
		}
		Node cur = head;
		Node next = null;
		// copy node and link to every node
		while (cur != null) {
			next = cur.next;
			cur.next = new Node(cur.value);
			cur.next.next = next;
			cur = next;
		}
		cur = head;
		Node curCopy = null;
		// set copy node rand
		while (cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			curCopy.rand = cur.rand != null ? cur.rand.next : null;
			cur = next;
		}
		Node res = head.next;
		cur = head;
		// split
		while (cur != null) {
			next = cur.next.next;
			curCopy = cur.next;
			cur.next = next;
			curCopy.next = next != null ? next.next : null;
			cur = next;
		}
		return res;
	}
		
		
	public static void main(String[] args) {
		
	}
	
}
