package algorithm_sort;

import java.util.Arrays;

// 随机快速排序
public class QuickSort {
	public static void swap(int[] arr, int i, int j) {
		// swap two elements of array
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int L, int R) {
		if (L < R) {
			// swap使最后一个数随机 减少极限情况的影响(eg: 1 2 3 4 5这样的数组)
			swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
			int[] p = partition(arr, L, R);
			quickSort(arr, L, p[0] - 1);
			quickSort(arr, p[1] + 1, R);
		}
	}

	public static int[] partition(int[] arr, int L, int R) {
		// 默认以最后一个位置做划分
		int less = L - 1;
		int more = R;
		while (L < more) {
			if (arr[L] < arr[R]) {
				swap(arr, L++, ++less);
			} else if (arr[L] > arr[R]) {
				swap(arr, L, --more);
			} else {
				L++;
			}
		}

		swap(arr, more, R);			// 将最后一个数替换到右边界
		// 返回等于区域的左右边界
		return new int[] { less + 1, more };
	} 
	
	// for test
	public static void comparator(int[] arr) {
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
	public static int[] copyArray(int[] arr) {
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	// for test
	public static boolean isEqual(int[] arr1, int[] arr2) {
		if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
			return false;
		}
		if (arr1 == null && arr2 == null) {
			return true;
		}
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != arr2[i]) {
				return false;
			}
		}
		return true;
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
	public static void main(String[] args) {
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			quickSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				printArray(arr1);
				printArray(arr2);
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		quickSort(arr);
		printArray(arr);

	}
	
}
