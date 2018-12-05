package template;


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

	
}
