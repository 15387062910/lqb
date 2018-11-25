package lqb_beikao;

// 给出两个数，计算最大公约数和最小公倍数
public class t4_MaxDivisor_MinCommonMultiple {
	static class Solution{	
		// 求最大公约数
		public static int max_divisor(int a, int b){
			int res = 1;
			if(a>b){
				int temp = a;
				a = b;
				b = temp;
			}
			int r = 2;
			while(r<=b){
				if(a%r==0&&b%r==0){
					res *= r;
					a = a/r;
					b = b/r;
				}
				else{
					r = r + 1;
				}
			}
			
			return res;
		}
		
		// 求最小公倍数
		public static int min_common_multiple(int a, int b){
			int res = 0;
			if(a>b){
				int temp = a;
				a = b;
				b = temp;
			}
			// 最小公倍数 * 最大公约数 = 两个数的乘积
			int r = Solution.max_divisor(a, b);
			res = a*b/r;
			return res;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("最大公约数test: ");
		System.out.println(Solution.max_divisor(15, 5));
		System.out.println(Solution.max_divisor(6, 14));
		System.out.println(Solution.max_divisor(12, 16));
		System.out.println(Solution.max_divisor(8, 20));
		System.out.println(Solution.max_divisor(27, 9));
		System.out.println(Solution.max_divisor(1, 1));
		System.out.println(Solution.max_divisor(3, 3));
		System.out.println(Solution.max_divisor(2, 2));
		
		System.out.println("最小公倍数test: ");
		System.out.println(Solution.min_common_multiple(1, 3));
		System.out.println(Solution.min_common_multiple(2, 3));
		System.out.println(Solution.min_common_multiple(4, 6));
		System.out.println(Solution.min_common_multiple(3, 8));
		
	}
	
}
