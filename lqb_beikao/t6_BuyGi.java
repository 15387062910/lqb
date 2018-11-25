package lqb_beikao;

// 白钱买百鸡问题: 
// 一只公鸡5文钱，一只母鸡3文钱，三只小鸡1文钱，用100文钱买100只鸡那么各有公鸡、母鸡、小鸡各多少只
public class t6_BuyGi {
	static class Solution{
		public static void buy(){
			// i, j, k分别代表公鸡、母鸡、小鸡数目
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
