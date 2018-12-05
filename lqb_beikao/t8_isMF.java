package lqb_beikao;

// 如下所示一个三维矩阵的每一行和每一列以及每一条对角线的和都相等的矩阵为魔方阵：
//	8	1	6
//	3	5	7
//	4	9	2
//	请你判断一个三维矩阵是否是魔方阵
public class t8_isMF {
	public static boolean isMf(int[][] arr) {
		// 枚举魔方阵的所有必要条件
		if(arr[0][0] + arr[0][1] + arr[0][2] == arr[1][0] + arr[1][1] + arr[1][2]){
			if(arr[1][0] + arr[1][1] + arr[1][2] == arr[2][0] + arr[2][1] + arr[2][2]){
				if(arr[2][0] + arr[2][1] + arr[2][2] == arr[0][0] + arr[1][0] + arr[2][0]){
					if(arr[0][0] + arr[1][0] + arr[2][0] == arr[0][1] + arr[1][1] + arr[2][1]){
						if(arr[0][1] + arr[1][1] + arr[2][1] == arr[0][2] + arr[1][2] + arr[2][2]){
							if(arr[0][2] + arr[1][2] + arr[2][2] == arr[0][0] + arr[1][1] + arr[2][2]){
								if(arr[0][0] + arr[1][1] + arr[2][2] == arr[0][2] + arr[1][1] + arr[2][0]){
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	// test
	public static void swap(int[][] arr, int i, int j, int m, int n) {
		int temp = arr[i][j];
		arr[i][j] = arr[m][n];
		arr[m][n] = temp;
	}

	// test
	public static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
		
		System.out.println("====================");
	}

	// test
	public static int[][] generateRandomArray() {
		int[][] arr = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		for (int times = 0; times < 10; times++) {
			int a = (int)(Math.random() * 3);
			int b = (int)(Math.random() * 3);
			int m = (int)(Math.random() * 3);
			int n = (int)(Math.random() * 3);
			swap(arr, a, b, m, n);
		}

		return arr;
	}

	public static void main(String[] args) {
		// 题目给的固定矩阵(魔方阵)
		int[][] mf = { { 8, 1, 6 }, { 3, 5, 7 }, { 4, 9, 2 } };
		printArray(mf);
		System.out.println(isMf(mf));
		
		// 随机生成矩阵
		for(int times=0; times<100000; times++){
			int[][] arr = generateRandomArray();
			if(isMf(arr)==true){
				printArray(arr);
				System.out.println(isMf(arr));
			}
		}
		
	}
}
