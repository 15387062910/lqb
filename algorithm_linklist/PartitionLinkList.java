package algorithm_linklist;

// 将单向链表按某值划分成左边小、中间相等、右边大的形式
public class PartitionLinkList {
	public static class Node {
		public int value;
		public Node next;

		public Node(int data) {
			this.value = data;
		}
	}

	// get the length of linklist
	public static int getLinkListLength(Node head) {
		int length = 0;
		while (head != null) {
			length++;
			head = head.next;
		}

		return length;
	}

	// convert the linklist to array
	public static int[] LinkListToArray(Node head) {
		if (head == null) {
			return null;
		}
		int length = getLinkListLength(head);
		int[] arr = new int[length];
		int cur = 0;
		while (head != null) {
			arr[cur++] = head.value;
			head = head.next;
		}

		return arr;
	}

	// convert the array to linklist
	public static Node ArrayToLinkList(int[] arr) {
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

	// for test
	public static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println();
	}

	// for test
	public static void printArray(int[] arr) {
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// for test
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	// partition a array
	public static void partition(int[] arr, int num) {
		int less = -1;
		int more = arr.length;
		for (int i = 0; i < more; i++) {
			if (arr[i] < num) {
				swap(arr, i, ++less);
			} else if (arr[i] > num) {
				swap(arr, i, --more);
			}
		}
	}

	// 普通方法
	public static Node partitionLinkList1(Node head, int num) {
		// 将链表转换成数组 然后把数组partition一下 然后将partition后的数组再依次搞到链表中
		int[] arr = LinkListToArray(head);
		partition(arr, num);
		head = ArrayToLinkList(arr);

		return head;
	}

	// 进阶方法
	public static Node partitionLinkList2(Node head, int num) {
		Node sH = null; // small head
		Node sT = null; // small tail
		Node eH = null; // equal head
		Node eT = null; // equal tail
		Node bH = null; // big head
		Node bT = null; // big tail
		Node next = null; // save next node
		while (head != null) {
			// 拿出头节点head
			next = head.next;
			head.next = null;
			// 根据head的值将head放入对应的链表中
			if (head.value < num) {
				if (sH == null) {
					sH = head;
					sT = head;
				} else {
					sT.next = head;
					sT = head;
				}
			} else if (head.value > num) {
				if (bH == null) {
					bH = head;
					bT = head;
				} else {
					bT.next = head;
					bT = head;
				}
			} else {
				if (eH == null) {
					eH = head;
					eT = head;
				} else {
					eT.next = head;
					eT = head;
				}
			}

			// 拿到原head之后的链表
			head = next;
		}

		// printLinkedList(sH);
		// printLinkedList(eH);
		// printLinkedList(bH);

		// 将三个链表合并在一起
// 注释的是左神的写法:
//		if (sT != null) {
//			sT.next = eH;
//			eT = eT == null ? sT : eT;
//		}
//		if (eT != null) {
//			eT.next = bH;
//		}
//		return sH != null ? sH : (eH != null ? eH : bH);
		return mergeLinkList(mergeLinkList(sH, eH), bH);
	}

	// test
	public static void main(String[] args) {
		// test partitionLinkList1
		Node head = new Node(1);
		head.next = new Node(3);
		head.next.next = new Node(6);
		head.next.next.next = new Node(5);
		head.next.next.next.next = new Node(8);
		head.next.next.next.next.next = new Node(1);
		printLinkedList(head);
		head = partitionLinkList1(head, 5); // partition linklist
		printLinkedList(head);
		System.out.println("============================");

		// test partitionLinkList2
		Node head2 = new Node(1);
		head2.next = new Node(3);
		head2.next.next = new Node(6);
		head2.next.next.next = new Node(5);
		head2.next.next.next.next = new Node(8);
		head2.next.next.next.next.next = new Node(1);
		printLinkedList(head2);
		head2 = partitionLinkList2(head2, 5);
		printLinkedList(head2);
	}

}
