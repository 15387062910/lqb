package lqb_beikao;

// ��һ����ά�������Ұ��㣬������Ҳ����û��
// ����: ����ֵ��� ����ֵ��С
public class t9_SaddlePoint {
	static class Solution{
		public static boolean findSaddle(int arr[][]){
			int max, m; 
			boolean flag = false;
			for(int i1=0; i1<arr.length; i1++){
				// ����ÿһ���ҳ�ÿһ�����ֵ �����ֵ�������max��
				max = arr[i1][0]; 
				m = 0;
				flag = true;
				for(int j=0; j<arr[i1].length; j++){
					if(arr[i1][j]>max){
						max = arr[i1][j];
						m = j;
					}
				}
				// �жϵ�ǰ�е����ֵ�Ƿ��ǵ�ǰ�е���Сֵ
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
