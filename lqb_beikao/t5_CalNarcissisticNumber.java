package lqb_beikao;

// 求水仙花数
// 水仙花数是指一个三位数abc 满足：a*a*a+b*b*b+c*c*c=abc
public class t5_CalNarcissisticNumber {
	public static class Solution{
		public static void cal_narcissistic(){
			int res = 0;
			
			for(int i=100; i<=999; i++){
				int a = i % 10;
				int b = i / 10 % 10;
				int c = i / 100;
				// System.out.println(c + " " + b + " " + a);
				if((a*a*a+b*b*b+c*c*c)==i){
					System.out.println(i);
				}
			}
			
		} 
	}
	
	public static void main(String[] args) {
		Solution.cal_narcissistic();
	}
}
