package problem;

//转圈打印矩阵
/*
给定一个整形矩阵matrix,请按照转圈的方式打印它。
			
	例如：		
		1    2    3    4			
		5    6    7    8		
		9    10   11   12		
		13   14   15   16
			
	打印结果为： 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
	要求额外空间复杂度为O(1)
*/
public class RotateOutputMatrix {
	private int M;
	private int N;
	private int[][] arr;
	private final int startValue = 1;

	public RotateOutputMatrix(int M, int N) {
		this.M = M;
		this.N = N;
		int value = startValue;
		arr = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				this.arr[i][j] = value++;
			}
		}
	}

	public void printEdge(int a, int b, int c, int d) {
		// 输出一层
		// (a, b) -> 左上角 (c, d) -> 右下角
		if (b == d) {
			// 两个点在一列上
			for (int i = a; i <= c; i++) {
				System.out.print(arr[i][b] + " ");
			}
		} else if (a == c) {
			// 两个点在一行上
			for (int j = b; j <= d; j++) {
				System.out.print(arr[a][j] + " ");
			}
		} else {
			// 两个点不在一行也不在一列上 -> 两个点在对角线上
			int curA = a;
			int curB = b;
			while (curB < d) {
				System.out.print(arr[curA][curB] + " ");
				curB++;
			}
			while (curA < c) {
				System.out.print(arr[curA][curB] + " ");
				curA++;
			}
			while (curB > b) {
				System.out.print(arr[curA][curB] + " ");
				curB--;
			}
			while (curA > a) {
				System.out.print(arr[curA][curB] + " ");
				curA--;
			}
		}
	}

	public void printAllEdge() {
		// 输出所有的层
		int a = 0;
		int b = 0;
		int c = this.M - 1;
		int d = this.N - 1;
		while (a <= c && b <= d) {
			printEdge(a++, b++, c--, d--);
		}
	}
	
	// test
	public void printMartix(){
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[0].length; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		RotateOutputMatrix test = new RotateOutputMatrix(4, 4);
		test.printMartix();
		System.out.println("=================");
		test.printAllEdge();
	}
}
