package problem;

// 之字形打印矩阵
/*
 给定一个矩阵matrix， 按照“之” 字形的方式打印这个矩阵， 例如： 1 2 3 4 5 6 7 8 9 10 11 12
 “之” 字形打印的结果为： 1， 2， 5， 9， 6， 3， 4， 7， 10， 11，8， 12
 要求额外空间复杂度为O(1)
 */
public class ZigZagPrintMatrix {
	private int M;
	private int N;
	private int[][] arr;
	private final int startValue = 1;

	public ZigZagPrintMatrix(int M, int N) {
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

	public void printLevel(int a, int b, int c, int d, boolean f) {
		// 打印一条斜线 f为true表示从右上到左下打印 
		if (f) {
			// (a, b) -> (c, d)
			while (a != c + 1) {
				System.out.print(arr[a++][b--] + " ");
			}
		} else {
			// (c, d) -> (a, b)
			while (d != b + 1) {
				System.out.print(arr[c--][d++] + " ");
			}
		}
	}

	public void printMatrixZigZag() {
		// 打印所有斜线
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int endR = M - 1;
		int endC = N - 1;
		boolean fromUp = false;
		while (a != endR + 1) {
			printLevel(a, b, c, d, fromUp);
			a = b == endC ? a + 1 : a;
			b = b == endC ? b : b + 1;
			d = c == endR ? d + 1 : d;
			c = c == endR ? c : c + 1;
			fromUp = !fromUp;
		}
		System.out.println();
	}

	// test
	public void printMartix() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		ZigZagPrintMatrix test = new ZigZagPrintMatrix(3, 4);
		test.printMartix();
		test.printMatrixZigZag();
	}
}
