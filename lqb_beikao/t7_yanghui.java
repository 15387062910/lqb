package lqb_beikao;

// ��ӡ���������(���8��)��������������аٶ�
public class t7_yanghui {
	static class Solution{
		public static void yh(int n){
			final int maxn = 10;
			int ans[][] = new int[maxn][maxn];
			for(int i=0; i<n; i++){
				for(int j=0; j<n-i-1; j++){
					System.out.print("  ");
				}
				for(int j=0; j<i+1; j++){
					if(i>=2 && (j>=1&&j<i)){
						ans[i][j] = ans[i-1][j-1] + ans[i-1][j];
					}
					else{
						ans[i][j] = 1;
					}
					System.out.print("  " + ans[i][j]);
				}
				
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) {
		Solution.yh(8);
	}
}
