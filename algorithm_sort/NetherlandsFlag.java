package algorithm_sort;

// 
// 荷兰国旗问题
/*
 给定一个数组 arr，和一个数 num，请把小于 num 的数放在数组的左边，等于 num 的数放在数组的中间，大于 num 的数放在数组的右边。
 要求额外空间复杂度 O(1)，时间复杂度 O(N)
 */
public class NetherlandsFlag {
	public static void swap(int[] arr, int i, int j) {
		// swap two elements of array
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void simpleSort(int[] arr, int num) {
		// 给定数组arr和数num 把小于等于num的放在数组左边 大于num的放在数组右边
		int x = -1; // 标记小于区域 (0到x)
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] <= num) {
				x += 1;
				swap(arr, i, x);
			} else {
				continue;
			}
		}
	}

	public static int[] partition(int[] arr, int L, int R, int num) {
		int less = L - 1;
		int more = R + 1;
		int cur = L;
		while (cur < more) {
			if (arr[cur] < num) {
				swap(arr, cur++, ++less);
			} else if (arr[cur] > num) {
				swap(arr, cur, --more);
			} else {
				cur++;
			}
		}
	
		// 返回的是等于区域的左边界和右边界
		if(less+1>more-1){
			// 表示不存在等于区域
			return new int[] { -1, -1 };
		}	
		else{
			// 等于区域存在
			return new int[] { less + 1, more - 1 };
		}
			
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
		// test simpleSort
		int[] test = generateArray();
		printArray(test);
		simpleSort(test, 5);
		printArray(test);

		// test partition
		int[] test2 = generateArray();
		printArray(test2);
		int[] res = partition(test2, 0, test2.length - 1, 5);
		printArray(test2);
		System.out.println(res[0]);
		System.out.println(res[1]);

	}
}
