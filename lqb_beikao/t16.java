package lqb_beikao;

// ��������
// 10301�Ǹ�5λ�����������и��ص㣬�����ֵ��������������������������������������ǳ�֮Ϊ����������
// 10501  10601  11311   ��Щ����5λ�Ļ�������
// ���̼�����������5λ���Ļ���������һ���ж��ٸ���
public class t16 {
	private static boolean isHui(int n){
		// �ж�һ�����Ƿ��ǻ�����
		String s = n + "";
		for(int i=0; i<=s.length()/2; i++){
			if(s.charAt(i)!=s.charAt(s.length()-1-i)){
				return false;
			}
		}
		
		return true;
	}
	
	private static boolean isPrime(int n){
		// �ж�һ�����Ƿ�������
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
