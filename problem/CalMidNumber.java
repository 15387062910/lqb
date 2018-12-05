package problem;

import java.util.Arrays;

// 一个流不断随机产生数 求随机产生的数的中位数  		
// TODO: 待完成
public class CalMidNumber {
	static int[] testArray = new int[33];
	static int testArraySize = 0;

	static int[] heapMax = new int[33];
	static int[] heapMin = new int[33];
	static int heapMaxSize = 0;
	static int heapMinSize = 0;
	static int heapMaxTop = -1;
	static int heapMinTop = -1;

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void calMidNumber(int num) {
		if (heapMaxSize - heapMinSize > 1) {
			// 把大根堆的堆顶移到小根堆
			heapMin[heapMinSize] = heapMaxTop;
			heapMinInsert(heapMin, heapMinSize++);
			swap(heapMax, 0, --heapMaxSize);
			heapifyMax(heapMax, 0, heapMaxSize);
			
			// printArray(heapMax);

		} else if (heapMinSize - heapMaxSize > 1) {
			// 把小根堆的堆顶移到大根堆
			heapMax[heapMaxSize] = heapMinTop;
			heapMaxInsert(heapMax, heapMaxSize++);
			swap(heapMin, 0, --heapMinSize);
			heapifyMin(heapMin, 0, heapMinSize);

		} else if (heapMaxSize == 0 || num <= heapMaxTop) {
			heapMax[heapMaxSize] = num;
			heapMaxInsert(heapMax, heapMaxSize++);
		} else {
			heapMin[heapMinSize] = num;
			heapMinInsert(heapMin, heapMinSize++);
		}

	}

	public static void heapMaxInsert(int[] arr, int index) {
		while (arr[index] > arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
		heapMaxTop = arr[0];
	}

	public static void heapMinInsert(int[] arr, int index) {
		while (arr[index] < arr[(index - 1) / 2]) {
			swap(arr, index, (index - 1) / 2);
			index = (index - 1) / 2;
		}
		heapMinTop = arr[0];
	}

	public static void heapifyMax(int[] arr, int index, int heapSize) {
		int left = index * 2 + 1;
		int right = left + 1;
		while (left < heapSize) {
			int largest = right < heapSize && arr[right] > arr[left] ? right
					: left;
			largest = arr[largest] > arr[index] ? largest : index;
			if (largest == index) {
				break;
			}
			swap(arr, index, largest);
			index = largest;
			left = index * 2 + 1;
			right = left + 1;
		}
	}

	public static void heapifyMin(int[] arr, int index, int heapSize) {
		int left = index * 2 + 1;
		int right = left + 1;
		while (left < heapSize) {
			int min = right < heapSize && arr[right] < arr[left] ? right : left;
			min = arr[min] < arr[index] ? min : index;
			if (min == index) {
				break;
			}
			swap(arr, index, min);
			index = min;
			left = index * 2 + 1;
			right = left + 1;
		}
	}

	public static int getMidNumber() {
		printArray(heapMax);
		printArray(heapMin);
		
		int nums = heapMaxSize + heapMinSize;
		if(nums % 2 == 0){
			return (heapMaxTop + heapMinTop) / 2;
		} else if(heapMaxSize % 2 == 0){
			return heapMaxTop;
		} else{
			return heapMinTop;
		}
	}

	// test
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	// test
	public static int[] arrayCopy(int[] arr, int length) {
		int[] newArr = new int[length];
		for (int i = 0; i < length; i++) {
			newArr[i] = arr[i];
		}

		return newArr;
	}

	// test
	public static int comparator() {
		int[] arr = arrayCopy(testArray, testArraySize);
		Arrays.sort(arr);
		printArray(arr);

		int mid = arr.length % 2 == 0 ? (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2
				: arr[arr.length / 2];

		return mid;
	}

	public static void main(String[] args) {
		// 用堆计算
		for (int i = 0; i < 10; i++) {
			int value = (int) (Math.random() * 100 + 1);
			calMidNumber(value);

			// test
			testArray[testArraySize++] = value;
		}
		System.out.println(getMidNumber());
		System.out.println(comparator());

	}

}
