package lqb_beikao;


// 编写程序求1+1/2!+1/3!+...+1/10!
public class t1_FactorialSum {
	// 计算阶乘
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
		System.out.println("结果为: " + res);			// 1.718281...
	}
}
