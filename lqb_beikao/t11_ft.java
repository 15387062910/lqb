package lqb_beikao;

// 15颗糖 5颗绿的 3颗黄的 7颗蓝的， 从中抓出10颗糖，请你编程输出所有情况，并统计总共有多少组解
public class t11_ft {
	static class Solution{
		public static void ft(){
			int count = 0;
			for(int i=0; i<=5; i++){
				for(int j=0; j<=3; j++){
					for(int k=0; k<=7; k++){
						if(i+j+k==10){
							System.out.println(i + " " + j + " " + k);
							count += 1;
						}
					}
				}
			}
			
			System.out.println(count);
		}
	}
	
	public static void main(String[] args) {
		Solution.ft();
	}
}
