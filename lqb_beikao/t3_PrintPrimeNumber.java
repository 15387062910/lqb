package lqb_beikao;

// ��ӡ100��200֮�������
public class t3_PrintPrimeNumber {

	// ��ӡ��100��200֮�������
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
