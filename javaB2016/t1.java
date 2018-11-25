package javaB2016;

/*
有一堆煤球，堆成三角棱锥形。具体：
	第一层放1个，
	第二层3个（排列成三角形），
	第三层6个（排列成三角形），
	第四层10个（排列成三角形），
	....
	如果一共有100层，共有多少个煤球？ 不是5050  是171700  套路啊、、、
 */
public class t1 {
	private static int f(int n){		// 算第n层有多少个
		int res = 0;
		for(int i=1; i<=n; i++){
			res += i;
		}
		
		return res;
	}
	
	private static int cal(int n){
		int res = 0;
		for(int i=1; i<=n; i++){
			res += f(i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		// 按题目给的数据测试一下:
		System.out.println(f(1));
		System.out.println(f(2));
		System.out.println(f(3));
		System.out.println(f(4));
		
		// 题目要算的:
		System.out.println(cal(100));		// 最后答案是171700
	}
}
