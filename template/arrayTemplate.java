package template;

import java.util.Arrays;

// 数组相关模板
public class arrayTemplate {
	public static void swap(int[] arr, int i, int j) {
		// to swap two element of array 
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void builtinSort(int[] arr) {
		// call java built-in sort
		Arrays.sort(arr);
	}

	public static int[] generateRandomArray(int maxSize, int maxValue) {
		// generate a random array
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];		// length of arr -> [0, maxSize]
		for (int i = 0; i < arr.length; i++) {
			// value of array element -> [1 - maxValue, maxValue]
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	public static int[] copyArray(int[] arr) {
		// copy a array to another array
		if (arr == null) {
			return null;
		}
		int[] res = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	public static boolean isEqual(int[] arr1, int[] arr2) {
		// to judge two array is equal
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

	public static void printArray(int[] arr) {
		// print all elements of array 
		if (arr == null) {
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void partition(int[] arr, int num) {
		// 把数组分成三部分 左边为小于num的数   中间为等于num的数  右边为大于num的数
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
	
}
