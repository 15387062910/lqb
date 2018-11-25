package algorithm;

public class Test {
	private static void outputArr(int[] arr){
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int[] arr = {1, 6, 3, 8, 4, 3, 5};
		// 测试排序:
		BubbleSort.bubbleSort(arr); outputArr(arr);
		SelectionSort.selectionSort(arr); outputArr(arr);
		InsertionSort.insertionSort(arr); outputArr(arr);
	}
}
