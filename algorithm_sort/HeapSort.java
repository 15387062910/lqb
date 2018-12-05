package algorithm_sort;

// 堆排序
public class HeapSort {
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void heapSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			// 逐步建立大根堆
			heapInsert(arr, i); 	// 0到i
		}
		int heapSize = arr.length;
		// 将最后一个和第一个(最大值)交换    然后heapSize减1 
		swap(arr, 0, --heapSize);		
		while (heapSize > 0) {
			heapify(arr, 0, heapSize);
			swap(arr, 0, --heapSize);
		}
	}

	public static void heapInsert(int[] arr, int index) {
		// 向大根堆中插入元素 并调整元素位置
		while (arr[index] > arr[(index - 1) / 2]) {
			// 子节点大于父节点 交换 子节点变成父节点
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
	}

	public static void heapify(int[] arr, int index, int heapSize) {
		// 拿出堆顶元素之后的调整堆
		int left = index * 2 + 1;
		int right = left + 1;
		while (left < heapSize) {
			int largest = right < heapSize && arr[right] > arr[left] ? right : left;
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, largest, index);		
			index = largest;
			left = index * 2 + 1;
			right = left + 1;
		}
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
	
	public static void main(String[] args) {
		int[] arr = {1, 5, 3, 6, 7};
		printArray(arr);
		heapSort(arr);
		printArray(arr);
	}
	
}
