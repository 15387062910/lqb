package algorithm_sort;

import java.util.Arrays;

public class MergeSort {
	public static void mergeSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		sortProcess(arr, 0, arr.length - 1);
	}

	public static void sortProcess(int[] arr, int L, int R) {
		if (L == R) {
			return;
		}
		int mid = (L + R) / 2; 					// L和R中点的位置
		sortProcess(arr, L, mid);				// T(N/2)
		sortProcess(arr, mid + 1, R);			// T(N/2)
		merge(arr, L, mid, R);					// O(N)
		// T(N) = 2*T(N/2) + O(N) => T(N) = N ^ d * logN = N*logN
	}

	public static void merge(int[] arr, int L, int mid, int R) {
		// merge: sort the array(L to R)
		int[] help = new int[R - L + 1];		// auxiliary array
		int i = 0;
		int p1 = L;
		int p2 = mid + 1;
		while (p1 <= mid && p2 <= R) {
			// if the value of arr[p1] < arr[p2] give value arr[p1] to help[i]
			// else give value arr[p2] to help[i]
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		// p1\p2 must be and only one arrive the boundary
		// give the remain elements of no-arrive boundary's one(p1 or p2) to help 
		while (p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while (p2 <= R) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			// give elements of help to arr
			arr[L + i] = help[i];
		}
	}
	
	// for test
	public static void comparator(int[] arr) {
		// call java built-in sort
		Arrays.sort(arr);
	}

	// for test
	public static int[] generateRandomArray(int maxSize, int maxValue) {
		// generate a random array
		// (int) ((maxSize + 1) * Math.random()) -> [0, maxSize]
		int[] arr = new int[(int) ((maxSize + 1) * Math.random())];		
		for (int i = 0; i < arr.length; i++) {
			// value of array element -> [1 - maxValue, maxValue]
			arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
		}
		return arr;
	}

	// for test
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

	// for test
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

	// for test
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

	// for test
	public static void main(String[] args) {
		// test main function
		int testTime = 500000;
		int maxSize = 100;
		int maxValue = 100;
		boolean succeed = true;
		for (int i = 0; i < testTime; i++) {
			int[] arr1 = generateRandomArray(maxSize, maxValue);
			int[] arr2 = copyArray(arr1);
			mergeSort(arr1);
			comparator(arr2);
			if (!isEqual(arr1, arr2)) {
				succeed = false;
				break;
			}
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");
		
		// to generate a array and sort it
		int[] arr = generateRandomArray(maxSize, maxValue);
		printArray(arr);
		mergeSort(arr);
		printArray(arr);
	}

}
