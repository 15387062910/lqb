package javaB2016;

/*
��һ��ú�򣬶ѳ�������׶�Ρ����壺
	��һ���1����
	�ڶ���3�������г������Σ���
	������6�������г������Σ���
	���Ĳ�10�������г������Σ���
	....
	���һ����100�㣬���ж��ٸ�ú�� ����5050  ��171700  ��·��������
 */
public class t1 {
	private static int f(int n){		// ���n���ж��ٸ�
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
		// ����Ŀ�������ݲ���һ��:
		System.out.println(f(1));
		System.out.println(f(2));
		System.out.println(f(3));
		System.out.println(f(4));
		
		// ��ĿҪ���:
		System.out.println(cal(100));		// ������171700
	}
}
