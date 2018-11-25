package lqb_beikao;

// 小明刚刚看完电影《第39级台阶》，离开电影院的时候，他数了数礼堂前的台阶数，恰好是39级!
// 站在台阶前，他突然又想着一个问题：
// 如果我每一步只能迈上1个或2个台阶。先迈左脚，然后左右交替，最后一步是迈右脚，也就是说一共要走偶数步。那么，上完39级台阶，有多少种不同的上法呢？
public class t14 {
	private static int f(int n){
		if(n==1){
			return 1;
		}
		if(n==2){
			return 2;
		}
		return f(n-1)+f(n-2);
	}
	
	public static void main(String[] args) {
		System.out.println(f(1));
		System.out.println(f(2));
		System.out.println(f(3));
		System.out.println(f(39));
	}
}
