package problem;

/*
 给定一个N×M的整型矩阵matrix和一个正数K，matrix的每一行每一列都是排好序的。实现一个函数，判断K是否在matrix中
 例如： 
 0,　1,　2,　5 
 2,　3,　4,　7 
 4,　4,　4,　8 
 5,　7,　7,　9 
 如果K为7，返回True；如果K为6，返回False。 
 要求时间复杂度O(N+M)，空间复杂度O(1)

 */
public class FindNumberInMatrix {

	private static boolean find(int[][] arr, int num) {
		int row = 0;
		int col = arr[0].length - 1;
		while (row != arr[0].length - 1 && col != 0) {
			if (arr[row][col] == num) {
				return true;
			} else if (arr[row][col] > num) {
				col--;
			} else {
				row++;
			}
		}
	
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = { { 0, 1, 2, 5 }, { 2, 3, 4, 7 }, { 4, 4, 4, 8 },
				{ 5, 7, 7, 9 } };
		System.out.println(find(matrix, 7));
		System.out.println(find(matrix, 6));
	}
}
