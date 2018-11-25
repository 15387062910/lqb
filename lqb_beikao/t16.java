package lqb_beikao;

// 回文素数
// 10301是个5位的素数。它有个特点，把数字倒过来还是它本身，具有这样特征的素数，我们称之为：回文素数
// 10501  10601  11311   这些都是5位的回文素数
// 请编程计算像这样的5位数的回文素数，一共有多少个？
public class t16 {
	private static boolean isHui(int n){
		// 判断一个数是否是回文数
		String s = n + "";
		for(int i=0; i<=s.length()/2; i++){
			if(s.charAt(i)!=s.charAt(s.length()-1-i)){
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isPrime(int n){
		// 判断一个数是否是素数
		for(int i=2; i*i<n; i++){
			if(n%i==0){
				return false;
			}
		}
		
		return true;
	}
	
	private static void f(){
		int res = 0;
		for(int i=10000; i<=99999; i++){
			if(isHui(i)){
				if(isPrime(i)){
					System.out.println(i);
					res += 1;
				}
			}
		}
		System.out.println(res);
	}
	
	public static void main(String[] args) {
		f();
	}
}
