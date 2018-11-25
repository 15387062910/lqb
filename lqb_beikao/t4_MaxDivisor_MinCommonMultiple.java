package lqb_beikao;

// �������������������Լ������С������
public class t4_MaxDivisor_MinCommonMultiple {
	static class Solution{	
		// �����Լ��
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
		
		// ����С������
		public static int min_common_multiple(int a, int b){
			int res = 0;
			if(a>b){
				int temp = a;
				a = b;
				b = temp;
			}
			// ��С������ * ���Լ�� = �������ĳ˻�
			int r = Solution.max_divisor(a, b);
			res = a*b/r;
			return res;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("���Լ��test: ");
		System.out.println(Solution.max_divisor(15, 5));
		System.out.println(Solution.max_divisor(6, 14));
		System.out.println(Solution.max_divisor(12, 16));
		System.out.println(Solution.max_divisor(8, 20));
		System.out.println(Solution.max_divisor(27, 9));
		System.out.println(Solution.max_divisor(1, 1));
		System.out.println(Solution.max_divisor(3, 3));
		System.out.println(Solution.max_divisor(2, 2));
		
		System.out.println("��С������test: ");
		System.out.println(Solution.min_common_multiple(1, 3));
		System.out.println(Solution.min_common_multiple(2, 3));
		System.out.println(Solution.min_common_multiple(4, 6));
		System.out.println(Solution.min_common_multiple(3, 8));
		
	}
	
}
