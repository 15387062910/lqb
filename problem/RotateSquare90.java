package problem;

// 给定一个整型正方形矩阵matrix,请把该矩阵调整成 顺时针旋转90度的样子
public class RotateSquare90 {
	private int M;
	private int[][] arr;
	private final int startValue = 1;

	public RotateSquare90(int M) {
		this.M = M;
		int value = startValue;
		arr = new int[M][M];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < M; j++) {
				this.arr[i][j] = value++;
			}
		}
	}

	public void rotateEdge(int a, int b, int c, int d) {
		// 旋转一层
		int times = c - a;
		int tmp = 0;
		for (int i = 0; i < times; i++) {
			tmp = arr[a][b + i];
			arr[a][b + i] = arr[c - i][b];
			arr[c - i][b] = arr[c][d - i];
			arr[c][d - i] = arr[a + i][d];
			arr[a + i][d] = tmp;
		}
	}

	public void rotateAllEdge() {
		// 旋转所有层
		int i = 0;
		int j = 0;
		int m = this.M - 1;
		int n = this.M - 1;
		while(i<=m&&j<=n){
			rotateEdge(i++, j++, m--, n--);
		}
	}

	// for test
	public void printMatrix() {
		int[][] m = this.arr;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[0].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		RotateSquare90 test = new RotateSquare90(4);
		test.printMatrix();
		test.rotateAllEdge();
		test.printMatrix();
	}

}
