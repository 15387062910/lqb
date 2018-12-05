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
		if(head == null){
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

	public static void partition(int[] arr, int num) {
		int less = -1;
		int more = arr.length;
		for (int i = 0; i < arr.length && i <= more; i++) {
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

		Node res = new Node(0);
		return res;
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
		head = partitionLinkList1(head, 5);		// partition linklist
		printLinkedList(head);

	}

}
