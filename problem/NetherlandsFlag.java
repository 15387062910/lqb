package problem;

// 荷兰国旗问题
/*
	 给定一个数组 arr，和一个数 num，请把小于 num 的数放在数组的左边，等于 num 的数放在数组的中间，大于 num 的数放在数组的右边。
	 要求额外空间复杂度 O(1)，时间复杂度 O(N)
*/
public class NetherlandsFlag {
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static int[] partition(int[] arr, int L, int R, int num) {
		int less = L - 1;
		int more = R + 1;
		int cur = L;
		while (cur < more) {
			if (arr[cur] < num) {
				swap(arr, ++less, cur++);			
			} else if (arr[cur] > num) {
				swap(arr, --more, cur);
			} else {	
				// arr[cur] == num
				cur++;
			}
		}
			
		// 返回的是等于区域的左边界和右边界
		return new int[] { less + 1, more - 1 };
	}
	
	// for test
	public static int[] generateArray() {
		int[] arr = new int[10];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 9);
		}
		return arr;
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
		int[] test = generateArray();

		printArray(test);
		int[] res = partition(test, 0, test.length - 1, 5);
		printArray(test);
		System.out.println(res[0]);
		System.out.println(res[1]);

	}
}
