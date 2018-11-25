package lqb_beikao;

// 在一个二维数组中找鞍点，可能有也可能没有
// 鞍点: 本行值最大 本列值最小
public class t9_SaddlePoint {
	static class Solution{
		public static boolean findSaddle(int arr[][]){
			int max, m; 
			boolean flag = false;
			for(int i1=0; i1<arr.length; i1++){
				// 遍历每一行找出每一行最大值 将最大值坐标存入max中
				max = arr[i1][0]; 
				m = 0;
				flag = true;
				for(int j=0; j<arr[i1].length; j++){
					if(arr[i1][j]>max){
						max = arr[i1][j];
						m = j;
					}
				}
				// 判断当前行的最大值是否是当前列的最小值
				for(int i2=0; i2<arr.length; i2++){
					if(max>arr[i2][m]){
						// System.out.println(max + " " + arr[i2][m]);
						flag = false;
						break;
					}
				}
				
				if(flag){
					return flag;
				}
			}

			return flag;
		}
	}
	
	public static void main(String[] args) {
		int arr[][] = {
				{3, 3, 13, 1},
				{4, 6, 5, 1},
				{7, 8, 9, 1}
		};
		int arr2[][] = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		System.out.println(Solution.findSaddle(arr));
		System.out.println(Solution.findSaddle(arr2));
		
	}
}
