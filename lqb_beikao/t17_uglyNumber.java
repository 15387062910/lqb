package lqb_beikao;

// ��дһ�������жϸ��������Ƿ�Ϊ������  ��������ֻ���������� 2, 3, 5 ��������
public class t17_uglyNumber {
	private static boolean isUglyNumber(int num){
		while(num%2 == 0){
			num /= 2;
		}
		while(num%3 == 0){
			num /= 3;
		}
		while(num%5 == 0){
			num /= 5;
		}	
		return (num == 1) ? true : false;
	}
	
	public static void main(String[] args) {
		System.out.println(isUglyNumber(6));
		System.out.println(isUglyNumber(8));
		System.out.println(isUglyNumber(14));
	}
}
