package lqb_beikao;


// ��д������1+1/2!+1/3!+...+1/10!
public class t1_FactorialSum {
	// ����׳�
	private static int calFactorial(int n){
		int res = 1;
		for(int i=1; i<=n; i++){
			res = res * i;
		}
		return res;
	}
	
	public static void main(String[] args) {
		double res = 0;
		for(int i=1; i<=10; i++){
			res += 1.0/calFactorial(i);
		}
		System.out.println("���Ϊ: " + res);			// 1.718281...
	}
}
