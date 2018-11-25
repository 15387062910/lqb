package lqb_beikao;

// 打印100到200之间的素数
public class t3_PrintPrimeNumber {

	// 打印出100到200之间的素数
	static class Solution{
		public static boolean isPrime(int n){
			for(int i=2; i*i<n; i++){
				if(n%i==0){
					return false;
				}
			}
			return true;
		}
	}
	
	public static void main(String[] args) {
		for(int i=100; i<200; i++){
			if(Solution.isPrime(i)){
				System.out.println(i);
			}
		}
	}
}
