package lqb_beikao;

// ��Ǯ��ټ�����: 
// һֻ����5��Ǯ��һֻĸ��3��Ǯ����ֻС��1��Ǯ����100��Ǯ��100ֻ����ô���й�����ĸ����С��������ֻ
public class t6_BuyGi {
	static class Solution{
		public static void buy(){
			// i, j, k�ֱ��������ĸ����С����Ŀ
			for(int i=0; i<=20; i++){
				for(int j=0; j<=33; j++){
					int k = 100 - i - j;
					if(i*5+j*3+k/3==100){
						if(k%3==0){
							System.out.println(i + " " + j + " " + k);
						}
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Solution.buy();
	}
}
