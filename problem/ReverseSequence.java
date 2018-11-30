package problem;

// 逆序对问题
/*
 在一个数组中 如果左边的数比右边的数大 则这两个数构成构成一个逆序对 请打印所有逆序对
 */
public class ReverseSequence {
	public static void reverseSequence(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		mergeSort(arr, 0, arr.length - 1);
	}

	public static void mergeSort(int[] arr, int L, int R) {
		if (L == R) {
			return;
		}
		int mid = L + (R - L) / 2;
		mergeSort(arr, L, mid);
		mergeSort(arr, mid + 1, R);
		merge(arr, L, mid, R);
	}

	public static void merge(int[] arr, int L, int mid, int R) {
		int[] help = new int[R - L + 1];
		int i = 0;
		int p1 = L;
		int p2 = mid + 1;
		while (p1 <= mid && p2 <= R) {
			if (arr[p1] > arr[p2]) {
				System.out.println(arr[p1] + " " + arr[p2]);
			}
			help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
		}
		while (p1 <= mid) {
			help[i++] = arr[p1++];
		}
		while (p2 <= R) {
			help[i++] = arr[p2++];
		}
		for (i = 0; i < help.length; i++) {
			arr[L + i] = help[i];
		}

	}

	public static void main(String[] args) {
		int[] arr = { 3, 1, 2, 5, 3 };
		ReverseSequence.reverseSequence(arr);
	}
}
