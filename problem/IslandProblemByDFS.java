package problem;

// 经典岛问题
/*
 岛问题是一个经典的问题，描述如下:
 一个矩阵中只有0和1两种值，每个位置都可以和自己的上、下、左、右 四个位置相连，
 如果有一片1连在一起，这个部分叫做一个岛，求一个 矩阵中有多少个岛？
 举例：
 0 0 1 0 1 0
 1 1 1 0 1 0 
 1 0 0 1 0 0 
 0 0 0 0 0 0
 这个矩阵中有三个岛
 */
public class IslandProblemByDFS {

	public static void infect(int[][] arr, int i, int j, int N, int M) {
		if (i < 0 || i >= N || j < 0 || j >= M || arr[i][j] != 1) {
			return;
		}
		arr[i][j] = 2;
		infect(arr, i + 1, j, N, M);
		infect(arr, i - 1, j, N, M);
		infect(arr, i, j + 1, N, M);
		infect(arr, i, j - 1, N, M);
	}

	public static int countIslands(int[][] arr) {
		if (arr == null || arr[0] == null) {
			return 0;
		}
		int N = arr.length;
		int M = arr[0].length;
		int res = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1) {
					res++;
					infect(arr, i, j, N, M);
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[][] m1 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 0, 1, 1, 1, 0 }, { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 1, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countIslands(m1));

		int[][] m2 = { { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 0, 1, 1, 1, 1, 1, 1, 1, 0 }, { 0, 1, 1, 1, 0, 0, 0, 1, 0 },
				{ 0, 1, 1, 0, 0, 0, 1, 1, 0 }, { 0, 0, 0, 0, 0, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1, 1, 1, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0 }, };
		System.out.println(countIslands(m2));
	}

}
