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
	
	// 按顺序合并两个链表(每个都可能为null)
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
	
	public static void main(String[] args) {
		
	}

	
}
